/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hpn.repository.impl;

import com.hpn.pojo.Transaction;
import com.hpn.pojo.User;
import com.hpn.repository.StatsRepository;
import com.hpn.repository.UserRepository;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
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
public class StatsRepositoryImpl implements StatsRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;
    @Autowired
    private SimpleDateFormat f;
    @Autowired
    private UserRepository userRepo;

    @Override
    public List<Integer> getYearByUser(int year) {
        Session s = this.factory.getObject().getCurrentSession();
        // lay ng dung hien tai
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());
        Query q = s.createQuery("SELECT Year(date) FROM Transaction Where userId.id=:id GROUP BY userId.id, YEAR(date) ");
        q.setParameter("id", user.getId());
        return q.getResultList();
    }

    @Override
    public List<Transaction> getAmountByUser(int amount) {
        Session s = this.factory.getObject().getCurrentSession();
        // lay ng dung hien tai
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());
        Query q = s.createQuery("SELECT sum(amount) FROM Transaction Where userId.id=:id GROUP BY userId.id, YEAR(date) ");
        q.setParameter("id", user.getId());
        return q.getResultList();
    }

    @Override
    public List<Integer> getMonthByUser(int month) {
        Session s = this.factory.getObject().getCurrentSession();
        // lay ng dung hien tai
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());
        Query q = s.createQuery("SELECT Month(date) FROM Transaction Where userId.id=:id");
        q.setParameter("id", user.getId());
        return q.getResultList();
    }

    @Override
    public List<Transaction> getMonthAndTypeByUSer(int month) {
        Session s = this.factory.getObject().getCurrentSession();
        // lay ng dung hien tai
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());
        Query q = s.createQuery("Select sum(amount) FROM Transaction Where userId.id=:id AND Month(date)=:date Group By type");
        q.setParameter("id", user.getId());
        q.setParameter("date", month);
        return q.getResultList();
    }

    @Override
    public List<Transaction> getTypeForMonth(int month) {
        Session s = this.factory.getObject().getCurrentSession();
        // lay ng dung hien tai
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());
        Query q = s.createQuery("Select type FROM Transaction Where userId.id=:id AND Month(date)=:date Group By type");
        q.setParameter("id", user.getId());
        q.setParameter("date", month);
        return q.getResultList();
    }

    @Override
    public List<Transaction> getYearAndTypeByUSer(int year) {
        Session s = this.factory.getObject().getCurrentSession();
        // lay ng dung hien tai
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());
        Query q = s.createQuery("Select sum(amount) FROM Transaction Where userId.id=:id AND Year(date)=:date Group By type");
        q.setParameter("id", user.getId());
        q.setParameter("date", year);
        return q.getResultList();
    }

    @Override
    public List<Transaction> getTypeForYear(int year) {
        Session s = this.factory.getObject().getCurrentSession();
        // lay ng dung hien tai
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());
        Query q = s.createQuery("Select type FROM Transaction Where userId.id=:id AND Year(date)=:date Group By type");
        q.setParameter("id", user.getId());
        q.setParameter("date", year);
        return q.getResultList();
    }

    @Override
    public List<Transaction> getMonthAndYearByUser(int month, int year) {
        Session s = this.factory.getObject().getCurrentSession();
        // lay ng dung hien tai
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());
        Query q = s.createQuery("Select sum(amount) FROM Transaction Where userId.id=:id AND Month(date)=:month And Year(date)=:year Group By type");
        q.setParameter("id", user.getId());
        q.setParameter("month", month);
        q.setParameter("year", year);
        return q.getResultList();
    }

    @Override
    public List<Transaction> getTypeForMonthAndYear(int month, int year) {
        Session s = this.factory.getObject().getCurrentSession();
        // lay ng dung hien tai
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());
        Query q = s.createQuery("Select type FROM Transaction Where userId.id=:id AND Month(date)=:month AND Year(date)=:year Group By type");
        q.setParameter("id", user.getId());
        q.setParameter("month", month);
        q.setParameter("year", year);
        return q.getResultList();
    }

}
