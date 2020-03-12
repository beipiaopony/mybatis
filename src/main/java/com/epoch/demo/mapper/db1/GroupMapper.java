package com.epoch.demo.mapper.db1;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.epoch.demo.model.Group;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author rogerwang
 * create 2020-03-11 20:30
 * Description:
 */

@Mapper
public interface GroupMapper extends BaseMapper<Group> {


    IPage<Group> selectMyPage(IPage<Group> page, @Param(Constants.WRAPPER) Wrapper<Group> queryWrapper);

    @Select("<script>"+
            "select * from t_console_group "+
            "where 1=1 "+
            "<![CDATA[and group_id <> '1']]>"+
            " <if test='nameCn != null and nameCn.trim() != &quot;&quot;'>" +
            " AND group_name like CONCAT('%',#{nameCn},'%')" +
            " </if>" +
            "</script>")
    IPage<Group> selectAnnotationPage(IPage<Group> page, @Param("nameCn") String nameCn);

}
