/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hpn.controllers;

import com.hpn.service.TransactionService;
import java.text.SimpleDateFormat;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author defaultuser0
 */
@Controller
public class ViewTransactionController {

    @Autowired
    private TransactionService transactionService;
    @Autowired
    private Environment env;
    @Autowired
    private SimpleDateFormat f;

    @GetMapping("/viewTrans")
    public String dashboard(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("view", this.transactionService.getTransactionByUsername(params));
        model.addAttribute("totalincome", this.transactionService.TotalIncome(0));
        model.addAttribute("totalexpense", this.transactionService.TotalExpense(0));
//        model.addAttribute("total", this.transactionService.Total(params));


        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        int count1 = this.transactionService.countTransactionByUser();
        model.addAttribute("counter", Math.ceil(count1 * 1.0 / pageSize));
        return "viewTrans";
    }
}
