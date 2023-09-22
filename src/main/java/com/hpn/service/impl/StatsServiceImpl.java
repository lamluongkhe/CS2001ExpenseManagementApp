/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hpn.service.impl;

import com.hpn.pojo.Transaction;
import com.hpn.repository.StatsRepository;
import com.hpn.service.StatsService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author defaultuser0
 */
@Service
public class StatsServiceImpl implements StatsService {

    @Autowired
    private StatsRepository statsRepo;

    @Override
    public List<Integer> getYearByUser(int year) {
        return this.statsRepo.getYearByUser(year);
    }

    @Override
    public List<Transaction> getAmountByUser(int amount) {
        return this.statsRepo.getAmountByUser(amount);
    }

    @Override
    public List<Integer> getMonthByUser(int month) {
        return this.statsRepo.getMonthByUser(month);
    }

    @Override
    public List<Transaction> getMonthAndTypeByUSer(int month) {
        return this.statsRepo.getMonthAndTypeByUSer(month);
    }

    @Override
    public List<Transaction> getTypeForMonth(int month) {
        return this.statsRepo.getTypeForMonth(month);
    }

    @Override
    public List<Transaction> getTypeForYear(int year) {
        return this.statsRepo.getTypeForYear(year);
    }

    @Override
    public List<Transaction> getYearAndTypeByUSer(int year) {
        return this.statsRepo.getYearAndTypeByUSer(year);
    }

    @Override
    public List<Transaction> getMonthAndYearByUser(int month, int year) {
        return this.statsRepo.getMonthAndYearByUser(month, year);
    }

    @Override
    public List<Transaction> getTypeForMonthAndYear(int month, int year) {
        return this.statsRepo.getMonthAndTypeByUSer(month);
    }

}
