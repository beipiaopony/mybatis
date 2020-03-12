package com.epoch.demo.mapper.db2;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.epoch.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author rogerwang
 * create 2020-03-11 20:30
 * Description:
 */

@DS("slave_1")
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User findByName(@Param("userName") String userName);
}
