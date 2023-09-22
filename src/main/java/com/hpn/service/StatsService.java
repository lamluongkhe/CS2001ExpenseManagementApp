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
public interface StatsService {

    List<Integer> getYearByUser(int year);

    List<Transaction> getAmountByUser(int amount);

    List<Integer> getMonthByUser(int month);

    List<Transaction> getMonthAndTypeByUSer(int month);

    List<Transaction> getTypeForMonth(int month);

    List<Transaction> getYearAndTypeByUSer(int year);

    List<Transaction> getTypeForYear(int year);

    List<Transaction> getMonthAndYearByUser(int month, int year);

    List<Transaction> getTypeForMonthAndYear(int month, int year);

}
