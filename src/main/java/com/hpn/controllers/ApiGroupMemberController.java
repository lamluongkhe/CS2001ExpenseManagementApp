/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hpn.controllers;

import com.hpn.pojo.Groupmember;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hpn.service.GroupMemberService;

/**
 *
 * @author defaultuser0
 */
@RestController
@RequestMapping("/api")
public class ApiGroupMemberController {

    @Autowired
    private GroupMemberService groupMemberService;

    @GetMapping("/groupmembers")
    @CrossOrigin
    public ResponseEntity<List<Groupmember>> list() {
        return new ResponseEntity<>(this.groupMemberService.getGroupMember(), HttpStatus.OK);
    }
}
