package com.epoch.demo.mapper;

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

@Mapper
public interface UserMapper extends BaseMapper<User> {
    User findByName(@Param("userName") String userName);
}
