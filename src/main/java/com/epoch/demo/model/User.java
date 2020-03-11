package com.epoch.demo.model;


import lombok.Data;

import java.util.Date;

/**
 * @author rogerwang
 * create 2020-03-11 20:30
 * Description:
 */


@Data
public class User {

    private String id;
    private String userName;
    private String loginName;
    private Date creteTime;

}
