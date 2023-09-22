/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hpn.controllers;

import com.hpn.pojo.Transaction;
import com.hpn.service.TransactionService;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author defaultuser0
 */
@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    

    @GetMapping("/transactions")
    public String list(Model model) {
        model.addAttribute("transaction", new Transaction());
        return "transactions"; // zô title.jsp 
    }

    @GetMapping("/transactions/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("transaction", this.transactionService.getTransactionById(id));
        return "transactions";
    }

    @PostMapping("/transactions")
    public String add(@ModelAttribute(value = "transaction") @Valid Transaction t, BindingResult rs) {
        if (!rs.hasErrors()) {

            if (transactionService.addOrUpdateTransaction(t) == true) {
                return "redirect:/";
            }
        }
        return "transactions";
    }

  

}
