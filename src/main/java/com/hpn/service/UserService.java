/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hpn.service;

import com.hpn.pojo.User;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author defaultuser0
 */
public interface UserService extends UserDetailsService {

    List<User> getUsers(String username);

    boolean addUser(User user);

    // cua thay
    User addUser(Map<String, String> params, MultipartFile avatar);

    User getUserByUn(String username);

    boolean authUser(String username, String password);

    List<User> getUsersForAdmin();

    User getUserById(int id);

    boolean updateUser(User u);
}
