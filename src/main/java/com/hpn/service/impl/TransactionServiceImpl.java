/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hpn.service.impl;

import com.hpn.pojo.Grouptransaction;
import com.hpn.pojo.Transaction;
import com.hpn.repository.GroupTransactionRepository;
import com.hpn.repository.TransactionRepository;
import com.hpn.service.TransactionService;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author defaultuser0
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepo;
    @Autowired
    private GroupTransactionRepository groupTransactionRepo;

    @Override
    public List<Transaction> getTransactions(Map<String, String> params) {
        return this.transactionRepo.getTransaction(params);
    }

    @Override
    public int countTransactions() {
        return this.transactionRepo.countTransaction();
    }

    @Override
    public boolean addOrUpdateTransaction(Transaction t) {
        return this.transactionRepo.addOrUpdateTransaction(t);
    }

    @Override
    public Transaction getTransactionById(int id) {
        return this.transactionRepo.getTransactionById(id);
    }

    @Override
    public boolean deleteTransaction(int id) {
        return this.transactionRepo.deleteTransaction(id);
    }

    @Override
    public List<Transaction> getTransactionByTypeIncome(Map<String, String> params) {
        return this.transactionRepo.getTransactionByTypeIncome(params);
    }

    @Override
    public List<Transaction> getTransactionByTypeExpense(Map<String, String> params) {
        return this.transactionRepo.getTransactionByTypeExpense(params);
    }

    @Override
    public List<Transaction> getTransactionByUsername(Map<String, String> params) {
        return this.transactionRepo.getTransactionByUsername(params);
    }

    @Override
    public List<Integer> TotalIncome(int id) {
        return this.transactionRepo.TotalIncome(id);
    }

    @Override
    public List<Integer> TotalExpense(int id) {
        return this.transactionRepo.TotalExpense(id);
    }

    @Override
    public List<Integer> Total(Map<String, String> params) {
        return this.transactionRepo.Total(params);
    }

    @Override
    public int countTransactionByUser() {
        return this.transactionRepo.countTransactionByUser();
    }

    @Override
    public int countTransactionByUserIncome() {
        return this.transactionRepo.countTransactionByUserIncome();
    }

    @Override
    public int countTransactionByUserExpense() {
        return this.transactionRepo.countTransactionByUserExpense();
    }

    @Override
    public List<Transaction> getListTransByGroupTrans(int id, Map<String, String> params) {

        List<Grouptransaction> groupTran = this.groupTransactionRepo.getGroupTransByIdGroup(id);
        List<Transaction> tran = this.transactionRepo.getTransaction(params);

        Set<Integer> tranIdInGroup = new HashSet<>();
        for (Grouptransaction g : groupTran) {
            tranIdInGroup.add(g.getTransactionId().getId());
        }
        List<Transaction> tranNew = new ArrayList<>();
        for (Transaction t : tran) {
            if (tranIdInGroup.contains(t.getId())) {
                tranNew.add(t);
            }
        }

        return tranNew;
    }

}
