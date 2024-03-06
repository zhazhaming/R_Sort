package com.sort.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sort.entity.User;
import com.sort.mapper.UserMapper;
import com.sort.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public boolean createUser(User user) {
        String imgUrl = "http://47.115.231.19:8888/group1/M00/00/00/L3PnE2Xn1byAAa6PAAAXsbiK4hg124.png";
        user.imgUrl = imgUrl;
        boolean save = this.save(user);
        return save;
    }

    @Override
    public User searchUser(String condition, String password) {

        User user = new User();
        if (search(condition,'@')){
            user = this.getOne(new LambdaQueryWrapper<User>().select(User::getEmail, User::getPassword));
        }else {
            user = this.getOne(new LambdaQueryWrapper<User>().select(User::getUsername, User::getPassword))
        }

        return user;
    }

    @Override
    public int searchByName(String username) {

        return this.count(new LambdaQueryWrapper<User>().select(User::getUsername));
    }

    @Override
    public int searchByEmail(String email) {
        return  this.count(new LambdaQueryWrapper<User>().select(User::getEmail));;
    }

    public boolean search(String target, char s){
        for (int i = 0; i <target.length() ; i++) {
            if (s == target.charAt(i)) return true;
        }
        return false;
    }
}
