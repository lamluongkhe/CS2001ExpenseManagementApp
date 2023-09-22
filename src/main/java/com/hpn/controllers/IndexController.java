/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hpn.controllers;

import com.hpn.service.CategoryService;
import com.hpn.service.TransactionService;
import com.hpn.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author defaultuser0
 */
@Controller
@Transactional
@ControllerAdvice // sai cho tat ca controller
@PropertySource("classpath:configs.properties")
public class IndexController {

    @Autowired
    private TransactionService transactionService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    
    @Autowired
    private Environment env;

    // Tra ra tuong tu
    @ModelAttribute
    public void commonArr(Model model) {
        model.addAttribute("categories", this.categoryService.getCategories());
    }

    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("transactions", this.transactionService.getTransactions(params));
        model.addAttribute("categories", this.categoryService.getCategories());

        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        int count = this.transactionService.countTransactions();
        model.addAttribute("counter", Math.ceil(count * 1.0 / pageSize));
        return "index";

    }

}
