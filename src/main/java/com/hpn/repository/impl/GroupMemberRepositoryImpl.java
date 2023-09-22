/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hpn.repository.impl;

import com.hpn.pojo.Groupmember;
import com.hpn.pojo.Teamgroup;
import com.hpn.pojo.User;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.hpn.repository.GroupMemberRepository;
import com.hpn.repository.TeamgroupRepository;
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
public class GroupMemberRepositoryImpl implements GroupMemberRepository {

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

    @Override
    public List<Groupmember> getGroupMember() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Groupmember");

        return q.getResultList();
    }

    @Override
    public List<Groupmember> getGroupMemberForUser() {
        Session s = this.factory.getObject().getCurrentSession();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());
        Query q = s.createQuery("From Groupmember Where userId.id=:id");
        q.setParameter("id", user.getId());
        return q.getResultList();
    }

    @Override
    public List<Groupmember> getMemberOfGroup(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Groupmember Where teamgroupId.id=:id");
        q.setParameter("id", id);
        return q.getResultList();
    }

    @Override
    public boolean addGroupMember(Groupmember g) {
        Session s = this.factory.getObject().getCurrentSession();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());
        try {
            if (g.getId() == null) {
                s.save(g);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addUserInGroup(int id, int userId) {
        Session s = this.factory.getObject().getCurrentSession();
        Teamgroup t = this.teamGroupRepo.getTeamgroupById(id);
        User u = this.userRepo.getUserById(userId);
        Groupmember g = new Groupmember();
        g.setRoleingroup("User");
        g.setUserId(u);
        g.setTeamgroupId(t);
        try {
            if (g.getId() == null) {
                s.save(g);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Groupmember> getRoleInGroup(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());
        Query q = s.createQuery("From Groupmember Where userId.id=:id And teamgroupId=:team");
        q.setParameter("id", user.getId());
        Teamgroup t = this.teamGroupRepo.getTeamgroupById(id);
        q.setParameter("team", t);
        return q.getResultList();
    }
}
