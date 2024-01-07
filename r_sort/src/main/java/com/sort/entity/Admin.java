package com.sort.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: zhazhaming
 * @Date: 2024/01/07/11:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="Admin对象", description="")
@TableName("Admin")
public class Admin {

    @TableField("id")
    private int Id;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("createDate")
    private Date createDate;
}
