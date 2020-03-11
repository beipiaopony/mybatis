package com.epoch.demo.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author rogerwang
 * create 2020-03-11 20:30
 * Description:
 */

@Data
@Accessors(chain = true)
@TableName(value="t_console_group")
public class Group {
    //主键 ， IdType.ASSIGN_UUID 主键生成方式,
    @TableId(value = "GROUP_ID",type = IdType.ASSIGN_UUID)
    private String groupId;
    @TableField(value = "GROUP_NAME")
    private String groupName;
    //驼峰命名可以不用映射，其他特殊需要映射
    //@TableField(value = "GROUP_DESC")
    private String groupDesc;
    //@TableField(value = "PRODUCT_CODE")
    private String productCode;
    //@TableField(value = "CREATE_TIME")
    private Date createTime;
    //@TableField(value = "UPDATE_TIME")
    private Date updateTime;
    @TableField(value = "PRIORITY")
    private int priority;

    @TableField(exist = false)
    private String test;
}
