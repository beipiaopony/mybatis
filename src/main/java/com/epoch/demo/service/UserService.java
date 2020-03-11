package com.epoch.demo.service;

import com.epoch.demo.model.User;

/**
 * @author rogerwang
 * create 2020-03-11 20:30
 * Description:
 */

public interface UserService {

    User findUserByName(String userName);
}
