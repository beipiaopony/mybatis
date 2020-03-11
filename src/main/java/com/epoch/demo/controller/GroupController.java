package com.epoch.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epoch.demo.model.Group;
import com.epoch.demo.service.GroupService;
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
public class GroupController {

    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/api/group", method = RequestMethod.GET)
    public Group getOne(@RequestParam(value = "groupName", required = true) String groupName){
        //获取一个对象，如果返回多个抛异常
        return groupService.getOne(Wrappers.<Group>lambdaQuery().eq(Group::getGroupName,"test1"));

        /* 单表增删改查，全部可以不用代码

        //新增
        groupService.save(group);
        //新增或者更新
        groupService.saveOrUpdate(group);
        //id删除
        groupService.removeById("");
        //删除多个id
        groupService.removeByIds(list);

        */


        //分页 list , 不推荐这样用，还是应该在mapper里定义分页方法，在service中处理查询条件
        /*
        QueryWrapper<Group> groupWrapper = new QueryWrapper<>();
        groupWrapper.lambda().eq(Group::getGroupId,"Group-c4fb47c40e11ca44dcf9a3bc6f");
        groupWrapper.lambda().or(wrapper-> wrapper.eq(Group::getGroupName,"test1"));
        groupWrapper.lambda().or(wrapper->wrapper.eq(Group::getGroupDesc,"test2").or().eq(Group::getGroupDesc,"test3"));
        Page<Group> page = new Page<>(1,2);

        groupService.page(page,groupWrapper);
        */


    }

}
