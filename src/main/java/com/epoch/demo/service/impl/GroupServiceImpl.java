package com.epoch.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.epoch.demo.mapper.GroupMapper;
import com.epoch.demo.model.Group;
import com.epoch.demo.service.GroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author rogerwang
 * create 2020-03-11 20:30
 * Description: 继承 mybatisplus 的 ServiceImpl 无需任何代码，直接绝大部分功能
 */

@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper,Group> implements GroupService {

    @Resource
    private GroupMapper mapper;

    /**
     * 插件提供的 selectPage 方法
     * @param currentPage
     * @param size
     * @return
     */
    @Override
    public IPage<Group> queryGroupForPageByPlusAuto(int currentPage, int size) {
        //组合查询条件
        QueryWrapper<Group> groupWrapper = new QueryWrapper<>();
        groupWrapper.lambda().eq(Group::getGroupId,"Group-c4fb47c40e11ca44dcf9a3bc6f");
        groupWrapper.lambda().or(wrapper-> wrapper.eq(Group::getGroupName,"test1"));
        groupWrapper.lambda().or(wrapper->wrapper.eq(Group::getGroupDesc,"test2").or().eq(Group::getGroupDesc,"test3"));

        Page<Group> page = new Page<>(currentPage,size);

        //如果需要map
        //mapper.selectMapsPage()

        return  mapper.selectPage(page, groupWrapper);
    }

    /**
     * 在 GroupMapper.xml 自定义sql， 主要是多表联合查询
     * 也可以使用传统的Map 传递参数
     * @param currentPage
     * @param size
     * @return
     */
    @Override
    public IPage<Group> queryGroupForPageByMySQL(int currentPage, int size) {
        //组合查询条件
        QueryWrapper<Group> groupWrapper = new QueryWrapper<>();
        //此处使用字段名， 多表查询可以使用表别名： t.group_id
        groupWrapper.eq("group_id","xxxxxxxxxxxxxx").like("","").or().like("","");

        Page<Group> page = new Page<>(currentPage,size);
        //map 传递参数
        //return mapper.selectMyPage(page, paramsMap);
        return mapper.selectMyPage(page, groupWrapper);
    }

    /**
     *  在mapper中使用注解 写sql
     * @param currentPage
     * @param size
     * @return
     */
    @Override
    public IPage<Group> queryGroupForPageByAnnotation(int currentPage, int size) {
        Page<Group> page = new Page<>(currentPage,size);
        return mapper.selectAnnotationPage(page, "test");
    }
}
