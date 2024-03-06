package com.sort.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zhazhaming
 * @Date: 2024/03/06/23:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {

    private String username;
    private String password;
    private String email;
}
