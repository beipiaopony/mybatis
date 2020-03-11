package com.epoch.demo.controller;

import com.epoch.demo.model.User;
import com.epoch.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rogerwang
 * create 2020-03-11 20:30
 * Description:
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public User findOneCity(@RequestParam(value = "userName", required = true) String userName) {
        return userService.findUserByName(userName);
    }

}
