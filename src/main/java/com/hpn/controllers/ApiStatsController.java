/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hpn.controllers;

import com.hpn.pojo.Transaction;
import com.hpn.service.StatsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author defaultuser0
 */
@RestController
@RequestMapping("/api")
public class ApiStatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping("/getyears/")
    @CrossOrigin
    public ResponseEntity<List<Integer>> getYear() {
        return new ResponseEntity<>(this.statsService.getYearByUser(0), HttpStatus.OK);
    }

    @GetMapping("/getmonths/{month}")
    @CrossOrigin
    public ResponseEntity<List<Integer>> getMonth() {
        return new ResponseEntity<>(this.statsService.getMonthByUser(0), HttpStatus.OK);
    }

    @GetMapping("/getamounts/")
    @CrossOrigin
    public ResponseEntity<List<Transaction>> getAmount() {
        return new ResponseEntity<>(this.statsService.getAmountByUser(0), HttpStatus.OK);
    }

    @GetMapping("/getMonthAmount/{month}")
    @CrossOrigin
    public ResponseEntity<List<Transaction>> getMonthAmount(@PathVariable(value = "month") int month) {
        return new ResponseEntity<>(this.statsService.getMonthAndTypeByUSer(month), HttpStatus.OK);
    }

    @GetMapping("/getMonthType/{month}")
    @CrossOrigin
    public ResponseEntity<List<Transaction>> getMonthType(@PathVariable(value = "month") int month) {
        return new ResponseEntity<>(this.statsService.getTypeForMonth(month), HttpStatus.OK);
    }

    @GetMapping("/getYearAmount/{year}")
    @CrossOrigin
    public ResponseEntity<List<Transaction>> getYearAmount(@PathVariable(value = "year") int year) {
        return new ResponseEntity<>(this.statsService.getYearAndTypeByUSer(year), HttpStatus.OK);
    }

    @GetMapping("/getYearType/{year}")
    @CrossOrigin
    public ResponseEntity<List<Transaction>> getYearType(@PathVariable(value = "year") int year) {
        return new ResponseEntity<>(this.statsService.getTypeForYear(year), HttpStatus.OK);
    }

    @GetMapping("/getMonthYearAmount/{month}/{year}")
    @CrossOrigin
    public ResponseEntity<List<Transaction>> getMonthYearAmount(@PathVariable int month, @PathVariable int year) {
        return new ResponseEntity<>(this.statsService.getMonthAndYearByUser(month, year), HttpStatus.OK);
    }

    @GetMapping("/getMonthYearType/{month}/{year}")
    @CrossOrigin
    public ResponseEntity<List<Transaction>> getMonthYearType(@PathVariable int month, @PathVariable int year) {
        return new ResponseEntity<>(this.statsService.getTypeForMonthAndYear(month, year), HttpStatus.OK);
    }
}
