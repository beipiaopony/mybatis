package com.epoch.demo.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epoch.demo.mapper.db1.GroupMapper;
import com.epoch.demo.mapper.db2.UserMapper;
import com.epoch.demo.model.Group;
import com.epoch.demo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * @author rogerwang
 * create 2020-03-11 20:30
 * Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Resource
    private GroupMapper mapper;

    @Resource
    private UserMapper userMapper;

    @Test
    public void userTest(){
        User u = userMapper.findByName("wuqian");
        System.out.println(u);
    }
    @Test
    public void aInsert() {
        Group group = new Group();
        //group.setId("");
        group.setGroupName("test1");
        group.setGroupDesc("test2");
        group.setProductCode("FSSC");
        group.setCreateTime(new Date());
        group.setUpdateTime(new Date());
        group.setPriority(1);
        group.setTest("test");

        assertThat(mapper.insert(group)).isGreaterThan(0);
        // 成功直接拿会写的 ID
        assertThat(group.getGroupId()).isNotNull();
    }

    @Test
    public void cUpdate() {

        QueryWrapper<Group> groupWrapper = new QueryWrapper<>();

        groupWrapper.lambda().eq(Group::getGroupId,"Group-c4fb47c40e11ca44dcf9a3bc6f");
        groupWrapper.lambda().and(wrapper-> wrapper.eq(Group::getGroupName,"Group-c4fb47c40e11ca44dcf9a3bc6f"));
        groupWrapper.lambda().or(wrapper->wrapper.eq(Group::getGroupDesc,"test2").or().eq(Group::getGroupDesc,"test3"));



        assertThat(mapper.updateById(new Group().setGroupId("Group-c4fb47c40e11ca44dcf9a3bc6f").setGroupDesc("test2"))).isGreaterThan(0);
        assertThat(
                mapper.update(
                        new Group().setProductCode("c112"),
                        groupWrapper

                )
        ).isGreaterThan(0);

    }
    @Test
    public void bDelete() {
        //assertThat(mapper.deleteById("6aa7ff1386d14d49a213500b536bf59b")).isGreaterThan(0);
        assertThat(mapper.delete(new QueryWrapper<Group>()
                .lambda().eq(Group::getGroupName, "test13"))).isGreaterThan(0);
    }


    @Test
    public void orderBy() {
        List<Group> groups = mapper.selectList(Wrappers.<Group>query().lambda().orderByAsc(Group::getGroupName));

        assertThat(groups).isNotEmpty();
    }

    @Test
    public void dSelect() {

        QueryWrapper<Group> groupWrapper = new QueryWrapper<>();
        groupWrapper.lambda().select(Group::getGroupName,Group::getGroupId);
        groupWrapper.lambda().eq(Group::getGroupId,"Group-c4fb47c40e11ca44dcf9a3bc6f");
        groupWrapper.lambda().or(wrapper-> wrapper.eq(Group::getGroupName,"test1"));
        groupWrapper.lambda().or(wrapper->wrapper.eq(Group::getGroupDesc,"test2").or().eq(Group::getGroupDesc,"test3"));


        List list = mapper.selectList(groupWrapper);

    }

    @Test
    public void selectByPage() {
        QueryWrapper<Group> groupWrapper = new QueryWrapper<>();
        groupWrapper.lambda().eq(Group::getGroupId,"Group-c4fb47c40e11ca44dcf9a3bc6f");
        groupWrapper.lambda().or(wrapper-> wrapper.eq(Group::getGroupName,"test1"));
        groupWrapper.lambda().or(wrapper->wrapper.eq(Group::getGroupDesc,"test2").or().eq(Group::getGroupDesc,"test3"));

        Page<Group> page = new Page<>(1,2);
        IPage<Group> groupPage = mapper.selectPage(page, groupWrapper);

        //mapper.selectMapsPage()

        System.out.println(groupPage);

        System.out.println("总页数"+groupPage.getPages());
        System.out.println("总记录数"+groupPage.getTotal());
        List<Group> records = groupPage.getRecords();
        records.forEach(System.out::println);

    }

    @Test
    public void selectByMyPage() {

        QueryWrapper<Group> groupWrapper = new QueryWrapper<>();
        groupWrapper.lambda().eq(Group::getGroupId,"Group-c4fb47c40e11ca44dcf9a3bc6f");
        groupWrapper.lambda().or(wrapper-> wrapper.eq(Group::getGroupName,"test1"));
        groupWrapper.lambda().or(wrapper->wrapper.eq(Group::getGroupDesc,"test2").or().eq(Group::getGroupDesc,"test3"));

        Page<Group> page = new Page<>(1,2);
        IPage<Group> groupPage = mapper.selectMyPage(page, groupWrapper);

        System.out.println("总页数"+groupPage.getPages());
        System.out.println("总记录数"+groupPage.getTotal());
        List<Group> records = groupPage.getRecords();
        records.forEach(System.out::println);


    }

    @Test
    public void selectAnnotationPage() {

        Page<Group> page = new Page<>(1,2);
        IPage<Group> groupPage = mapper.selectAnnotationPage(page, "1");

        System.out.println("总页数"+groupPage.getPages());
        System.out.println("总记录数"+groupPage.getTotal());
        List<Group> records = groupPage.getRecords();
        records.forEach(System.out::println);
    }
}
