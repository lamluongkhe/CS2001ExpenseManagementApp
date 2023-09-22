/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hpn.controllers;

import com.hpn.pojo.Teamgroup;
import com.hpn.service.TeamgroupService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author defaultuser0
 */
@RestController
@RequestMapping("/api")
public class ApiTeamgroupController {

    @Autowired
    private TeamgroupService teamgroupService;

    @GetMapping("/teamgroups")
    @CrossOrigin
    public ResponseEntity<List<Teamgroup>> list() {
        return new ResponseEntity<>(this.teamgroupService.getTeamgroup(), HttpStatus.OK);
    }
}
