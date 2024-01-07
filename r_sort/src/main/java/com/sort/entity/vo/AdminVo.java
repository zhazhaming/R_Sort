package com.sort.entity.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zhazhaming
 * @Date: 2024/01/07/17:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="AdminVo对象", description="")
public class AdminVo {

    private int Id;

    private String username;

    private String token;
}
