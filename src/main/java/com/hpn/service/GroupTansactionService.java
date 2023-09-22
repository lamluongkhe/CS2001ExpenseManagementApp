/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hpn.service;

import com.hpn.pojo.Grouptransaction;
import com.hpn.pojo.Transaction;
import java.util.List;

/**
 *
 * @author defaultuser0
 */
public interface GroupTansactionService {

    List<Grouptransaction> getGroupTransaction();

    List<Grouptransaction> getGroupTransByIdGroup(int id);

    boolean addGroupTran(Transaction t, int id);
}
