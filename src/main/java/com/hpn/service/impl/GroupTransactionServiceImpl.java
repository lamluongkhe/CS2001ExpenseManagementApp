/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hpn.service.impl;

import com.hpn.pojo.Grouptransaction;
import com.hpn.pojo.Transaction;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hpn.service.GroupTansactionService;
import com.hpn.repository.GroupTransactionRepository;

/**
 *
 * @author defaultuser0
 */
@Service
public class GroupTransactionServiceImpl implements GroupTansactionService {

    @Autowired
    private GroupTransactionRepository groupTransactionRepo;

    @Override
    public List<Grouptransaction> getGroupTransaction() {
        return this.groupTransactionRepo.getGroupTransaction();
    }

    @Override
    public List<Grouptransaction> getGroupTransByIdGroup(int id) {

        return this.groupTransactionRepo.getGroupTransByIdGroup(id);
    }

    @Override
    public boolean addGroupTran(Transaction t, int id) {
        return this.groupTransactionRepo.addGroupTran(t, id);
    }

}
