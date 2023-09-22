/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hpn.service;

import com.hpn.pojo.Transaction;
import java.util.List;
import java.util.Map;

/**
 *
 * @author defaultuser0
 */
public interface TransactionService {

    List<Transaction> getTransactions(Map<String, String> params);

    int countTransactions();

    boolean addOrUpdateTransaction(Transaction t);

    int countTransactionByUserIncome();

    int countTransactionByUserExpense();

    Transaction getTransactionById(int id);

    boolean deleteTransaction(int id);

    int countTransactionByUser();

    List<Transaction> getTransactionByTypeIncome(Map<String, String> params);

    List<Transaction> getTransactionByTypeExpense(Map<String, String> params);

    List<Transaction> getTransactionByUsername(Map<String, String> params);

    List<Integer> TotalIncome(int id);

    List<Integer> TotalExpense(int id);

    List<Integer> Total(Map<String, String> params);
    
    List<Transaction> getListTransByGroupTrans(int id, Map<String, String> params);
}
