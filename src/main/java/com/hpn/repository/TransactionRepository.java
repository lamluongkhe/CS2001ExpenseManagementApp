/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hpn.repository;

import com.hpn.pojo.Transaction;
import java.util.List;
import java.util.Map;

/**
 *
 * @author defaultuser0
 */
public interface TransactionRepository {

    List<Transaction> getTransaction(Map<String, String> params);

    int countTransaction();

    int countTransactionByUser();

    int countTransactionByUserIncome();

    int countTransactionByUserExpense();

    boolean addOrUpdateTransaction(Transaction t);

    Transaction getTransactionById(int id);

    boolean deleteTransaction(int id);

    List<Transaction> getTransactionByTypeIncome(Map<String, String> params);

//    List<Transaction> getTransactionIncome(int id);
    List<Transaction> getTransactionByTypeExpense(Map<String, String> params);

    List<Transaction> getTransactionByUsername(Map<String, String> params);

    List<Integer> TotalIncome(int id);

    List<Integer> TotalExpense(int id);

    List<Integer> Total(Map<String, String> params);

}
