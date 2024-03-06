package com.sort.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sort.entity.User;
import com.sort.entity.vo.AdminVo;

/**
 * @Author: zhazhaming
 * @Date: 2024/01/07/15:58
 */
public interface UserService extends IService<User> {

    public boolean createUser(User user);

    public User searchUser(String condition,String password);

    public int searchByName(String username);

    public int searchByEmail(String email);


}
