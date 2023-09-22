/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hpn.controllers;

import com.hpn.pojo.Category;
import com.hpn.pojo.Transaction;
import com.hpn.service.StatsService;
import com.hpn.service.TransactionService;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author defaultuser0
 */
@RestController
@RequestMapping("/api")
public class ApiTransactionController {

    @Autowired
    private TransactionService transactionService;

    //READ
    @GetMapping("/transactions/")
    @CrossOrigin
    public ResponseEntity<List<Transaction>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.transactionService.getTransactions(params), HttpStatus.OK);
    }

    @GetMapping("/transactions/income")
    @CrossOrigin
    public ResponseEntity<List<Transaction>> list1(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.transactionService.getTransactionByTypeIncome(params), HttpStatus.OK);
    }

    //CREATE
    @PostMapping("/transactions/add/")
    @CrossOrigin
    public ResponseEntity<Transaction> addTransaction(@RequestParam Transaction t) {
        if (this.transactionService.addOrUpdateTransaction(t) == true) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }

    //DELETE
    @DeleteMapping("/transactions/{id}")
    @CrossOrigin
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") int id) {
        this.transactionService.deleteTransaction(id);
    }

}
