/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hpn.controllers;

import com.hpn.pojo.Groupmember;
import com.hpn.pojo.Grouptransaction;
import com.hpn.pojo.Teamgroup;
import com.hpn.pojo.Transaction;
import com.hpn.pojo.User;
import com.hpn.repository.TeamgroupRepository;
import com.hpn.service.GroupMemberService;
import com.hpn.service.GroupTansactionService;
import com.hpn.service.TeamgroupService;
import com.hpn.service.TransactionService;
import com.hpn.service.UserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
public class GroupController {

    @Autowired
    private TeamgroupService groupService;
    @Autowired
    private GroupMemberService groupMemberService;
    @Autowired
    private UserService UserDetailsService;
    @Autowired
    private GroupTansactionService groupTransService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private TeamgroupRepository teamGroupRepo;

    @GetMapping("/groups")
    public String groups(Model model) {
        model.addAttribute("group", this.groupService.getTeamgroup());
        model.addAttribute("groupmember", this.groupMemberService.getGroupMemberForUser());
        return "groups";
    }

    @GetMapping("/groups/add")
    public String addGroup(Model model) {
        model.addAttribute("group", new Teamgroup());
        return "groupadd";
    }

    @PostMapping("/groups/add")
    public String addIncome(@ModelAttribute(value = "group") @Valid Teamgroup t, BindingResult rs) {
        if (!rs.hasErrors()) {
            if (groupService.addGroup(t) == true) {
                return "redirect:/groups";
            }
        }
        return "groupadd";
    }

    @GetMapping("/groups/transactions/{id}")
    public String addGroupTransaction(Model model, @PathVariable(value = "id") int id, @RequestParam Map<String, String> params) {
        model.addAttribute("newtran", this.transactionService.getListTransByGroupTrans(id, params));
        return "grouptrans";
    }

    @GetMapping("/groups/transactions/{id}/addtrans")
    public String addGroupTransaction(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("transaction", new Transaction());
        return "groupaddtran";
    }

    @PostMapping("/groups/transactions/{id}/addtrans")
    public String add(@PathVariable int id, @ModelAttribute(value = "transaction") @Valid Transaction t, BindingResult rs) {

        if (transactionService.addOrUpdateTransaction(t) == true && groupTransService.addGroupTran(t, id) == true) {

            return "redirect:/groups";
        }

        return "groupaddtran";
    }

    // lam ve detail
    @GetMapping("/details")
    public String details(Model model) {
        model.addAttribute("detail", this.groupMemberService.getGroupMemberForUser());
        return "details";
    }

    @GetMapping("/details/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("detail", this.groupMemberService.getMemberOfGroup(id));
        model.addAttribute("groupmember", this.groupMemberService.getRoleInGroup(id));
        return "details";
    }

    @GetMapping("/details/{id}/add")
    public String detailAdd(Model model, @PathVariable(value = "id") int id) {

        model.addAttribute("users", new User());
//        model.addAttribute("user", this.UserDetailsService.getUsersForAdmin());
//        model.addAttribute("detail", this.groupMemberService.getMemberOfGroup(id));
        List<Groupmember> g = this.groupMemberService.getMemberOfGroup(id);

        List<User> u = this.UserDetailsService.getUsersForAdmin();
        Set<Integer> userIdInGroup = new HashSet<>();
        for (Groupmember gm : g) {
            userIdInGroup.add(gm.getUserId().getId());
        }
        List<User> userNotInGroup = new ArrayList<>();
        for (User user : u) {
            if (!userIdInGroup.contains(user.getId())) {
                userNotInGroup.add(user);
            }
        }

        model.addAttribute("user", userNotInGroup);
        return "detailAdd";
    }

    @PostMapping("/details/{id}/add")
    public String addUserInGroup(@PathVariable int id,
            @ModelAttribute(value = "users") @Valid User userId, BindingResult rs) {

        if (groupMemberService.addUserInGroup(id, userId.getId()) == true) {
            return "redirect:/groups";
        }

        return "detailAdd";
    }
}
