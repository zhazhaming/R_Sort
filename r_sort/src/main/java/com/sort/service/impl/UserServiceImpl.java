package com.sort.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sort.entity.User;
import com.sort.entity.vo.UserVo;
import com.sort.mapper.UserMapper;
import com.sort.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public boolean createUser(UserVo uservo) {
        String imgUrl = "http://47.115.231.19:8888/group1/M00/00/00/L3PnE2Xn1byAAa6PAAAXsbiK4hg124.png";
        User user = new User (  );
        BeanUtils.copyProperties (uservo,user);
        user.setImgUrl (imgUrl);
        user.setScore (0);
        user.setCreateTime (new Date (  ));
        boolean save = this.save(user);
        return save;
    }

    @Override
    public User searchUser(String condition, String password) {

        User user = new User();
        if (search(condition,'@')){
        user = this.getOne(new LambdaQueryWrapper<User>().eq (User::getEmail,condition).eq (User::getPassword,password));
        }else {
            user = this.getOne(new LambdaQueryWrapper<User>().eq(User::getUsername, condition).eq (User::getPassword,password));
        }
        return user;
    }

    @Override
    public int searchByName(String username) {

        return this.count(new LambdaQueryWrapper<User>().eq(User::getUsername,username));
    }

    @Override
    public int searchByEmail(String email) {
        return  this.count(new LambdaQueryWrapper<User>().eq(User::getEmail,email));
    }

    @Override
    public boolean updateScore(String username,int score) {
        User user = this.getOne (new LambdaQueryWrapper<User> (  ).eq (User::getUsername,username));
        int score1 = user.getScore ();
        user.setScore (score1+5);
        this.saveOrUpdate (user);
        return true;
    }

    public boolean search(String target, char s){
        for (int i = 0; i <target.length() ; i++) {
            if (s == target.charAt(i)) return true;
        }
        return false;
    }
}
