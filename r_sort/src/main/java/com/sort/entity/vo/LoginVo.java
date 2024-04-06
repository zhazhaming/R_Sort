package com.sort.entity.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Author: zhazhaming
 * @Date: 2024/04/04/23:11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="LoginVo对象", description="返回vo对象给前端")
public class LoginVo {

    private String username;

    private int gender;

    private int score;

    private String token;

}
