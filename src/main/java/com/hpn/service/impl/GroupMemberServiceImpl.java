/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hpn.service.impl;

import com.hpn.pojo.Groupmember;
import com.hpn.pojo.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hpn.service.GroupMemberService;
import com.hpn.repository.GroupMemberRepository;

/**
 *
 * @author defaultuser0
 */
@Service
public class GroupMemberServiceImpl implements GroupMemberService {

    @Autowired
    private GroupMemberRepository groupMemberRepo;
    @Autowired
    private GroupMemberService groupMemberService;

    @Override
    public List<Groupmember> getGroupMember() {
        return this.groupMemberRepo.getGroupMember();
    }

    @Override
    public List<Groupmember> getGroupMemberForUser() {
        return this.groupMemberRepo.getGroupMemberForUser();
    }

    @Override
    public List<Groupmember> getMemberOfGroup(int id) {
        return this.groupMemberRepo.getMemberOfGroup(id);
    }

    @Override
    public boolean addUserInGroup(int id, int userId) {
        return this.groupMemberRepo.addUserInGroup(id, userId);
    }

    @Override
    public List<Groupmember> getRoleInGroup(int id) {
        return this.groupMemberRepo.getRoleInGroup(id);
    }

}
