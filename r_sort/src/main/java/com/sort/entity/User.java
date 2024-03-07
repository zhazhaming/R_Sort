package com.sort.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="User对象", description="")
@TableName("user")
public class User {

    @TableField("id")
    private int id;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("score")
    private int score;

    @TableField("email")
    private String email;

    @TableField("create_time")
    private Date createTime;

    @TableField("img_url")
    private String imgUrl;

    @TableField("sign")
    private Integer sign;
}
