/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hpn.fomatter;

import com.hpn.pojo.Teamgroup;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author defaultuser0
 */
public class TeamgroupFormatter implements Formatter<Teamgroup> {

    @Override
    public String print(Teamgroup teamgroup, Locale locale) {
        return String.valueOf(teamgroup.getId());
    }

    @Override
    public Teamgroup parse(String categoryId, Locale locale) throws ParseException {
        int id = Integer.parseInt(categoryId);
        return new Teamgroup(id);
    }
}
