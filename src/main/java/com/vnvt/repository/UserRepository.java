/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnvt.repository;

import com.vnvt.pojo.User;
import java.util.List;

/**
 *
 * @author 18510
 */
public interface UserRepository {

    User getUserById(int userId);

    boolean addUser(User user);

    List<User> getUsers(String username);
}
