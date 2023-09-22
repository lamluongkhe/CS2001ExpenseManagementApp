/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hpn.controllers;

import com.hpn.pojo.Transaction;
import com.hpn.service.StatsService;
import com.hpn.service.TransactionService;
import java.text.SimpleDateFormat;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
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
@PropertySource("classpath:configs.properties")
public class IncomeController {

    @Autowired
    private TransactionService transactionService;
    @Autowired
    private StatsService statsService;
    @Autowired
    private Environment env;
    @Autowired
    private SimpleDateFormat f;

    @GetMapping("/incomes")
    public String income(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("income", this.transactionService.getTransactionByTypeIncome(params));
        model.addAttribute("totalincome", this.transactionService.TotalIncome(0));
        model.addAttribute("totalexpense", this.transactionService.TotalExpense(0));
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        int count = this.transactionService.countTransactionByUserIncome();
        model.addAttribute("counter", Math.ceil(count * 1.0 / pageSize));
        return "incomes";
    }

    @GetMapping("/incomes/add")
    public String list(Model model) {
        model.addAttribute("income", new Transaction());
        return "incomeadd"; // zô title.jsp 
    }

    @GetMapping("/incomes/add/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("income", this.transactionService.getTransactionById(id));
        return "incomeadd";
    }

    @PostMapping("/incomes/add")
    public String addIncome(@ModelAttribute(value = "income") @Valid Transaction t, BindingResult rs) {
        if (!rs.hasErrors()) {
            if (transactionService.addOrUpdateTransaction(t) == true) {
                return "redirect:/incomes";
            }
        }
        return "incomeadd";
    }

//    @GetMapping("/incomes/delete/{id}")
//    public String delete(Model model, @PathVariable(value = "id") int id) {
//        model.addAttribute("income", this.transactionService.deleteTransaction(id));
//        return "incomeadd";
//    }
}
