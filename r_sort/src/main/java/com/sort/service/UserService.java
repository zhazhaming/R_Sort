package com.sort.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sort.entity.User;
import com.sort.entity.vo.AdminVo;
import com.sort.entity.vo.UserVo;

/**
 * @Author: zhazhaming
 * @Date: 2024/01/07/15:58
 */
public interface UserService extends IService<User> {

    public boolean createUser(UserVo uservo);

    public User searchUser(String condition,String password);

    public int searchByName(String username);

    public int searchByEmail(String email);

    public boolean updateScore(String username,int score);
}
