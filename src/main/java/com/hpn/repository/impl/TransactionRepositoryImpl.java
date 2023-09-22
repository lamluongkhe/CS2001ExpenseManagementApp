/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hpn.repository.impl;

import com.hpn.pojo.Transaction;

import com.hpn.pojo.User;
import com.hpn.repository.TransactionRepository;
import com.hpn.repository.UserRepository;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.transaction.internal.TransactionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author defaultuser0
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class TransactionRepositoryImpl implements TransactionRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;
    @Autowired
    private SimpleDateFormat f;
    @Autowired
    private UserRepository userRepo;

    @Override
    public List<Transaction> getTransaction(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Transaction> q = b.createQuery(Transaction.class);
        Root root = q.from(Transaction.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            // Tim kiem theo "title"
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("title"), String.format("%%%s%%", kw)));
            }
             String type = params.get("type");
            if (type != null && !type.isEmpty()) {
                predicates.add(b.like(root.get("type"), String.format("%%%s%%", kw)));
            }

            // Loc gia theo "amount"
            String fromAmount = params.get("fromAmount");
            if (fromAmount != null && !fromAmount.isEmpty()) {
                predicates.add(b.greaterThanOrEqualTo(root.get("amount"), Integer.parseInt(fromAmount)));
            }

            String cateId = params.get("cateId");
            if (cateId != null && !cateId.isEmpty()) {
                predicates.add(b.equal(root.get("categoryId"), Integer.parseInt(cateId)));
            }

            String quarter = params.get("quarter");
            if (quarter != null && !quarter.isEmpty()) {
                String year = params.get("year");
                if (year != null && !year.isEmpty()) {
                    predicates.addAll(Arrays.asList(
                            b.equal(b.function("YEAR", Integer.class, root.get("date")), Integer.parseInt(year)),
                            b.equal(b.function("QUARTER", Integer.class, root.get("date")), Integer.parseInt(quarter))
                    ));
                }
            }

            q.where(predicates.toArray(Predicate[]::new));
        }
        q.orderBy(b.asc(root.get("id")));
        Query query = session.createQuery(q);

        if (params != null) {
            String p = params.get("page");
            if (p != null && !p.isEmpty()) {
                int page = Integer.parseInt(p);
                // bo so trang vao 
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
                // so luong phan tu trang muon lay
                query.setMaxResults(pageSize);
                query.setFirstResult((page - 1) * pageSize);
            }
        }

        return query.getResultList();
    }

    @Override
    public int countTransaction() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("Select count(*) From Transaction");
        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public int countTransactionByUser() {
        Session s = this.factory.getObject().getCurrentSession();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());
        Query q = s.createQuery("Select count(*) From Transaction Where userId.id=:id");
        q.setParameter("id", user.getId());
        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public int countTransactionByUserIncome() {
        Session s = this.factory.getObject().getCurrentSession();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());
        Query q = s.createQuery("Select count(*) From Transaction Where userId.id=:id And type='Income'");
        q.setParameter("id", user.getId());
        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public int countTransactionByUserExpense() {
        Session s = this.factory.getObject().getCurrentSession();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());
        Query q = s.createQuery("Select count(*) From Transaction Where userId.id=:id And type='Expense'");
        q.setParameter("id", user.getId());
        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public boolean addOrUpdateTransaction(Transaction t) {
        Session s = this.factory.getObject().getCurrentSession();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());
        try {
            if (t.getId() == null) {
                t.setUserId(user);
                s.save(t);
            } else {
                t.setUserId(user);
                s.update(t);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Transaction getTransactionById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Transaction.class, id);
    }

    @Override
    public boolean deleteTransaction(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Transaction t = this.getTransactionById(id);
        try {
            s.delete(t);
            return true;
        } catch (HibernateError ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Transaction> getTransactionByTypeIncome(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        // lay ng dung hien tai
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Transaction> q = b.createQuery(Transaction.class);
        Root root = q.from(Transaction.class);
        List<Predicate> predicates = new ArrayList<>();
//        Selection<Integer> sumAmount = b.sum(root.get("amount"));
        if (params != null) {

            // Tim kiem theo "title"
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                try {
                    predicates.add(b.like(root.get("date"), f.parse(kw).toString()));
                } catch (ParseException ex) {
                    Logger.getLogger(TransactionRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            String fd = params.get("fromDate");
            if (fd != null && !fd.isEmpty()) {
                try {
                    predicates.add(b.greaterThanOrEqualTo(root.get("date"), f.parse(fd)));
                } catch (ParseException ex) {
                    Logger.getLogger(TransactionImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            String td = params.get("toDate");
            if (td != null && !td.isEmpty()) {
                try {
                    predicates.add(b.lessThanOrEqualTo(root.get("date"), f.parse(td)));
                } catch (ParseException ex) {
                    Logger.getLogger(TransactionImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            predicates.add(b.equal(root.get("type"), "Income"));
            predicates.add(b.equal(root.get("userId"), user.getId()));
            q.where(predicates.toArray(Predicate[]::new));
        }
        Query query = session.createQuery(q);
//        Query q = session.createQuery("From Transaction Where userId=:id");
//        q.setParameter("id", user);
        if (params != null) {
            String p = params.get("page");
            if (p != null && !p.isEmpty()) {
                int page = Integer.parseInt(p);
                // bo so trang vao 
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
                // so luong phan tu trang muon lay
                query.setMaxResults(pageSize);
                query.setFirstResult((page - 1) * pageSize);
            }
        }

        return query.getResultList();
    }

    @Override
    public List<Transaction> getTransactionByTypeExpense(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        // lay ng dung hien tai
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Transaction> q = b.createQuery(Transaction.class);
        Root root = q.from(Transaction.class);

        List<Predicate> predicates = new ArrayList<>();
        if (params != null) {

            // Tim kiem theo "title"
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("description"), String.format("%%%s%%", kw)));
            }
            String fd = params.get("fromDate");
            if (fd != null && !fd.isEmpty()) {
                try {
                    predicates.add(b.greaterThanOrEqualTo(root.get("date"), f.parse(fd)));
                } catch (ParseException ex) {
                    Logger.getLogger(TransactionImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            String td = params.get("toDate");
            if (td != null && !td.isEmpty()) {
                try {
                    predicates.add(b.lessThanOrEqualTo(root.get("date"), f.parse(td)));
                } catch (ParseException ex) {
                    Logger.getLogger(TransactionImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            predicates.add(b.equal(root.get("type"), "Expense"));
            predicates.add(b.equal(root.get("userId"), user.getId()));
            q.where(predicates.toArray(Predicate[]::new));
        }
        Query query = session.createQuery(q);
//        Query q = session.createQuery("From Transaction Where userId=:id");
//        q.setParameter("id", user);

        return query.getResultList();
    }

    @Override
    public List<Transaction> getTransactionByUsername(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        // lay ng dung hien tai
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Transaction> q = b.createQuery(Transaction.class);
        Root root = q.from(Transaction.class);
        List<Predicate> predicates = new ArrayList<>();
        if (params != null) {

            // Tim kiem theo "title"
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("description"), String.format("%%%s%%", kw)));
            }
            String fd = params.get("fromDate");
            if (fd != null && !fd.isEmpty()) {
                try {
                    predicates.add(b.greaterThanOrEqualTo(root.get("date"), f.parse(fd)));
                } catch (ParseException ex) {
                    Logger.getLogger(TransactionImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            String td = params.get("toDate");
            if (td != null && !td.isEmpty()) {
                try {
                    predicates.add(b.lessThanOrEqualTo(root.get("date"), f.parse(td)));
                } catch (ParseException ex) {
                    Logger.getLogger(TransactionImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            String quarter = params.get("quarter");
            if (quarter != null && !quarter.isEmpty()) {
                String year = params.get("year");
                if (year != null && !year.isEmpty()) {
                    predicates.addAll(Arrays.asList(
                            b.equal(b.function("YEAR", Integer.class, root.get("date")), Integer.parseInt(year)),
                            b.equal(b.function("QUARTER", Integer.class, root.get("date")), Integer.parseInt(quarter))
                    ));
                }
            }
            predicates.add(b.equal(root.get("userId"), user.getId()));
            q.where(predicates.toArray(Predicate[]::new));
        }

        Query query = session.createQuery(q);
        if (params != null) {
            String p = params.get("page");
            if (p != null && !p.isEmpty()) {
                int page = Integer.parseInt(p);
                // bo so trang vao 
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
                query.setMaxResults(pageSize);
                query.setFirstResult((page - 1) * pageSize);
            }

        }
        if (params != null) {
            String n = params.get("numberItem");

            if (n != null && !n.isEmpty()) {
                int page = Integer.parseInt(n);
                int t = 0;
                // bo so trang vao 
                if (page == 10) {
                    int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE10"));
                    t = pageSize;
                }

                if (page == 20) {
                    int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE20"));
                    t = pageSize;
                }

                query.setMaxResults(t);
                query.setFirstResult((page - t) * t);
            }
        }

        return query.getResultList();
    }

    @Override
    public List<Integer> TotalIncome(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        // lay ng dung hien tai
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());
        Query q = s.createQuery("Select sum(amount) From Transaction Where userId.id=:id And type = 'Income' ");
        q.setParameter("id", user.getId());
        return q.getResultList();
    }

    @Override
    public List<Integer> TotalExpense(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        // lay ng dung hien tai
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());
        Query q = s.createQuery("Select sum(amount) From Transaction Where userId.id=:id And type = 'Expense' ");
        q.setParameter("id", user.getId());
        return q.getResultList();
    }

    @Override
    public List<Integer> Total(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        // lay ng dung hien tai
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());
        Query q = s.createQuery("");
        q = s.createQuery("Select sum(amount) From Transaction Where userId.id=:id");
        q.setParameter("id", user.getId());

        // Tim kiem theo "title"
//        String fd = params.get("fromDate");
//        String td = params.get("toDate");
//        if (fd != null && !fd.isEmpty() && td != null && !td.isEmpty()) {
//            q = s.createQuery("Select sum(amount) From Transaction Where userId.id=:id And date Between '=:fromdate' And '=:todate'");
//            q.setParameter("fromdate", fd);
//            q.setParameter("todate", td);
//            q.setParameter("id", user.getId());
//        }
//        String td = params.get("toDate");
//        if (td != null && !td.isEmpty()) {
//            q = s.createQuery("Select sum(amount) From Transaction Where userId.id=:id And date <= ':todate'");
//            q.setParameter("todate", td);
//            q.setParameter("id", user.getId());
//        }
        return q.getResultList();
    }

}
