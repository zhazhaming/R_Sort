package com.sort.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sort.Enum.ObjectEnum;
import com.sort.Enum.ResponMsg;
import com.sort.constant.AdminConstant;
import com.sort.entity.Admin;
import com.sort.entity.vo.AdminVo;
import com.sort.mapper.AdminMapper;
import com.sort.service.AdminService;
import com.sort.util.JwtUtil;
import com.sort.util.RedisOperator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhazhaming
 * @Date: 2024/01/07/16:01
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private RedisOperator redis;

    @Override
    public AdminVo selectByNameAndPassword(String username, String password) {
        Admin admin = this.getOne (new LambdaQueryWrapper<Admin> (  ).eq (Admin::getUsername, username).eq (Admin::getPassword,password));
        String token = jwtUtil.generateToken (ObjectEnum.ADMIN.getRole (), admin);
        AdminVo adminVo = new AdminVo (  );
        BeanUtils.copyProperties (admin,adminVo);
        adminVo.setToken (token);
        redis.set (AdminConstant.ADMIN_LOGIN_PREFIX+admin.getId (),token,24*60*60);
        return adminVo;
    }

    @Override
    public void logout(String adminId) {
        redis.del (AdminConstant.ADMIN_LOGIN_PREFIX+adminId);
    }
}
