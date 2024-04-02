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

    public User getUserInfo(String condition);

    public int searchCountByName(String username);

    public int searchCountByEmail(String email);

    public int updateScoreAndSign(String username,int score);

    public boolean updateSign();
}
