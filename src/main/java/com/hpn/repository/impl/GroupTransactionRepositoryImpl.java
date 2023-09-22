/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hpn.repository.impl;

import com.hpn.pojo.Grouptransaction;
import com.hpn.pojo.Teamgroup;
import com.hpn.pojo.Transaction;
import com.hpn.pojo.User;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.hpn.repository.GroupTransactionRepository;
import com.hpn.repository.TeamgroupRepository;
import com.hpn.repository.TransactionRepository;
import com.hpn.repository.UserRepository;
import java.text.SimpleDateFormat;
import org.hibernate.HibernateException;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author defaultuser0
 */
@Repository
@Transactional
public class GroupTransactionRepositoryImpl implements GroupTransactionRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;
    @Autowired
    private SimpleDateFormat f;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private TeamgroupRepository teamGroupRepo;
    @Autowired
    private TransactionRepository transactionRepo;
    
    @Override
    public List<Grouptransaction> getGroupTransaction() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Grouptransaction");

        return q.getResultList();
    }

    @Override
    public List<Grouptransaction> getGroupTransByIdGroup(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Grouptransaction Where teamgroupId=:id");
        Teamgroup t = this.teamGroupRepo.getTeamgroupById(id);
        q.setParameter("id", t);
        return q.getResultList();
    }

    @Override
    public boolean addGroupTran(Transaction t, int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Grouptransaction grouptran = new Grouptransaction();
        Teamgroup tg = this.teamGroupRepo.getTeamgroupById(id);
        grouptran.setTeamgroupId(tg);
        grouptran.setTransactionId(t);
        try {
            if (t.getId() != null) {
                s.save(grouptran);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
