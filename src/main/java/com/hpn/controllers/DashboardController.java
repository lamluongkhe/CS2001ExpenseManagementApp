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
public class DashboardController {

    @Autowired
    private TransactionService transactionService;
    @Autowired
    private Environment env;
    @Autowired
    private SimpleDateFormat f;

    @GetMapping("/dashboards")
    public String dashboard() {
        return "dashboards";
    }
}
