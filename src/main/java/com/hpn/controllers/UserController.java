/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hpn.controllers;

import com.hpn.pojo.User;
import com.hpn.service.UserService;
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


/**
 *
 * @author defaultuser0
 */
@Controller
public class UserController {

    @Autowired
    private UserService UserDetailsService;
    @Autowired
    private Environment env;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute(value = "user") User user) {
        String errMsg = "";
        if (user.getPassword().equals(user.getConfirmPassword())) {
            if (this.UserDetailsService.addUser(user) == true) {
                return "redirect:/login";
            } else {
                errMsg = "Da co loi xay ra";
            }
        } else {
            errMsg = "Error Password";
        }

        model.addAttribute("errMsg", errMsg);
        return "register";
    }

    @GetMapping("/formusers")
    public String formUser(Model model) {
        model.addAttribute("user", this.UserDetailsService.getUsersForAdmin());
//         int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
//        int count = this.UserDetailsService.countTransactions();
//        model.addAttribute("counter", Math.ceil(count * 1.0 / pageSize));
        return "formusers";
    }

    @GetMapping("/formusers/update/{id}")
    public String updateUserId(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("user", this.UserDetailsService.getUserById(id));
        return "formuserupdate";
    }

    @PostMapping("/formusers/update")
    public String updateUser(@ModelAttribute(value = "user") @Valid User u, BindingResult rs) {
        if (!rs.hasErrors()) {
            if (UserDetailsService.updateUser(u) == true) {
                return "redirect:/formusers";
            }
        }
        return "formuserupdate";
    }

//    @GetMapping("/formusers/update")
//    public String list(Model model) {
//        model.addAttribute("user", new User());
//        return "formusersupdate"; // zô title.jsp 
//    }
}
