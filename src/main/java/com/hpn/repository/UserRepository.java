/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hpn.repository;

import com.hpn.pojo.User;
import java.util.List;

/**
 *
 * @author defaultuser0
 */
public interface UserRepository {

    boolean addUser(User user);

    boolean authUser(String username, String password);

    List<User> getUsers(String username);

    User getUserByUsername(String username);

    List<User> getUsersForAdmin();

    User getUserById(int id);

    boolean updateUser(User u);
}
