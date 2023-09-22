/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hpn.controllers;

import com.hpn.pojo.Transaction;
import com.hpn.service.TransactionService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author defaultuser0
 */
@Controller
public class ExpenseController {

    @Autowired
    private TransactionService transactionService;
    @Autowired
    private Environment env;

    @GetMapping("/expenses")
    public String expense(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("expense", this.transactionService.getTransactionByTypeExpense(params));
        model.addAttribute("totalexpense",this.transactionService.TotalExpense(0));
        
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        int count = this.transactionService.countTransactionByUserExpense();
        model.addAttribute("counter", Math.ceil(count * 1.0 / pageSize));
        return "expenses";
    }

    @GetMapping("/expenses/add")
    public String list(Model model) {
        model.addAttribute("expense", new Transaction());
        return "expenseadd"; // zô title.jsp 
    }

    @GetMapping("/expenses/add/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("expense", this.transactionService.getTransactionById(id));
        return "expenseadd";
    }

    @PostMapping("/expenses/add")
    public String addIncome(@ModelAttribute(value = "expense") @Valid Transaction t, BindingResult rs) {
        if (!rs.hasErrors()) {
            if (transactionService.addOrUpdateTransaction(t) == true) {
                return "redirect:/expenses";
            }
        }
        return "expenseadd";
    }
}
