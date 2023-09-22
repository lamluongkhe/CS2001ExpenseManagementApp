/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hpn.repository.impl;

import com.hpn.pojo.Groupmember;
import com.hpn.pojo.Teamgroup;
import com.hpn.pojo.User;
import com.hpn.repository.GroupMemberRepository;
import com.hpn.repository.TeamgroupRepository;
import com.hpn.repository.UserRepository;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
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
public class TeamgroupRepositoryImpl implements TeamgroupRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;
    @Autowired
    private SimpleDateFormat f;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private GroupMemberRepository groupMemberRepo;

    @Override
    public List<Teamgroup> getTeamgroup() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Teamgroup");

        return q.getResultList();
    }

    @Override
    public boolean addGroup(Teamgroup t) {
        Session s = this.factory.getObject().getCurrentSession();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userRepo.getUserByUsername(authentication.getName());
        Groupmember groupmember = new Groupmember();
        groupmember.setUserId(user);
        groupmember.setRoleingroup("Admin");
        groupmember.setTeamgroupId(t);
        try {
            if (t.getId() == null) {
                s.save(t);
                this.groupMemberRepo.addGroupMember(groupmember);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Teamgroup getTeamgroupById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Teamgroup.class, id);
    }

}
