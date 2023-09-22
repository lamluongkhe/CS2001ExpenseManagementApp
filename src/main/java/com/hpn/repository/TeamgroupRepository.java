/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hpn.repository;

import com.hpn.pojo.Teamgroup;
import java.util.List;

/**
 *
 * @author defaultuser0
 */
public interface TeamgroupRepository {

    List<Teamgroup> getTeamgroup();
//     List<Teamgroup> groupOfCurrentUser();
    boolean addGroup(Teamgroup t);
        Teamgroup getTeamgroupById(int id);

}
