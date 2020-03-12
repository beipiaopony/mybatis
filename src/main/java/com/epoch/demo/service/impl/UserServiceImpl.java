package com.epoch.demo.service.impl;


import com.epoch.demo.mapper.db2.UserMapper;
import com.epoch.demo.model.User;
import com.epoch.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author rogerwang
 * create 2020-03-11 20:30
 * Description:
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findUserByName(String userName) {
        return userMapper.findByName(userName);
    }

}