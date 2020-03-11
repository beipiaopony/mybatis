package com.epoch.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.epoch.demo.model.Group;

/**
 * @author rogerwang
 * create 2020-03-11 20:30
 * Description:
 */

public interface GroupService extends IService<Group> {
    IPage<Group> queryGroupForPageByPlusAuto(int currentPage, int size);

    IPage<Group> queryGroupForPageByMySQL(int currentPage, int size);

    IPage<Group> queryGroupForPageByAnnotation(int currentPage, int size);
}
