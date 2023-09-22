/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hpn.fomatter;

import com.hpn.pojo.Transaction;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author defaultuser0
 */
public class TransactionFormatter implements Formatter<Transaction> {
    @Override
    public String print(Transaction transaction, Locale locale) {
        return String.valueOf(transaction.getId());
    }

    @Override
    public Transaction parse(String categoryId, Locale locale) throws ParseException {
        int id = Integer.parseInt(categoryId);
        return new Transaction(id);
    }
}
