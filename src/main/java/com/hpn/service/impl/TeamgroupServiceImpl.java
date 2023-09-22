/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hpn.service.impl;

import com.hpn.pojo.Groupmember;
import com.hpn.pojo.Teamgroup;
import com.hpn.repository.GroupMemberRepository;
import com.hpn.repository.TeamgroupRepository;
import com.hpn.service.TeamgroupService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author defaultuser0
 */
@Service
public class TeamgroupServiceImpl implements TeamgroupService {
    @Autowired
    private TeamgroupRepository teamgroupRepo;
    @Autowired
    private GroupMemberRepository groupMemberRepo;
    
    @Override
    public List<Teamgroup> getTeamgroup() {
        return this.teamgroupRepo.getTeamgroup();
    }
//    public List<Teamgroup> group(){
//        List<Groupmember> groupmember = (List<Groupmember>) new Groupmember();
//        groupmember = this.groupMemberRepo.getGroupMemberForUser() ;
//        List<Teamgroup> teamgroups = this.teamgroupRepo.getTeamgroup();
//        List<Teamgroup> teamgroupsNew=
//        return null;
//    }

    @Override
    public boolean addGroup(Teamgroup t) {
        
        return this.teamgroupRepo.addGroup(t);
    }
    
}
