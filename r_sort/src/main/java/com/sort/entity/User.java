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

    @TableField("gender")
    private int gender;

    @TableField("score")
    private int score;

    @TableField("openid")
    private String openid;

    @TableField("sessionKey")
    private String sessionKey;

    @TableField("unionId")
    private String unionId;

    @TableField("img_url")
    private String img_url;

    @TableField("sign")
    private int sign;
}
