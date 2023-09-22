/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hpn.controllers;

import com.hpn.pojo.Grouptransaction;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hpn.service.GroupTansactionService;

/**
 *
 * @author defaultuser0
 */
@RestController
@RequestMapping("/api")
public class ApiGroupTransactionController {

    @Autowired
    private GroupTansactionService groupTransactionService;

    @GetMapping("/grouptransactions")
    @CrossOrigin
    public ResponseEntity<List<Grouptransaction>> list() {
        return new ResponseEntity<>(this.groupTransactionService.getGroupTransaction(), HttpStatus.OK);
    }
}
