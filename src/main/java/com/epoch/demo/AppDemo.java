package com.epoch.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author rogerwang
 * create 2020-03-11 20:30
 * Description:
 */


@SpringBootApplication
public class AppDemo {
    public static void main(String[] args) {
        // 程序启动入口
        SpringApplication.run(AppDemo.class,args);
    }
}
