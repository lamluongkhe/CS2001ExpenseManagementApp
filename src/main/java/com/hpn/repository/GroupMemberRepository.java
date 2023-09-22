/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hpn.repository;

import com.hpn.pojo.Groupmember;
import com.hpn.pojo.User;
import java.util.List;

/**
 *
 * @author defaultuser0
 */
public interface GroupMemberRepository {

    List<Groupmember> getGroupMember();

    List<Groupmember> getGroupMemberForUser();

    List<Groupmember> getMemberOfGroup(int id);

    boolean addGroupMember(Groupmember g);

    boolean addUserInGroup(int id, int userId);

    List<Groupmember> getRoleInGroup(int id);
    
    
    
}
