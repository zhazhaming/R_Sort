package com.sort.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sort.entity.User;
import com.sort.entity.vo.AdminVo;
import com.sort.entity.vo.RequestLoginVo;
import com.sort.entity.vo.UserVo;

/**
 * @Author: zhazhaming
 * @Date: 2024/01/07/15:58
 */
public interface UserService extends IService<User> {


    public String wxLogin(UserVo userVo);

    public boolean updateSign();

}
