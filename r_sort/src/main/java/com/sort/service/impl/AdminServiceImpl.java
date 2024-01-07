package com.sort.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sort.Enum.ObjectEnum;
import com.sort.Enum.ResponMsg;
import com.sort.entity.Admin;
import com.sort.entity.vo.AdminVo;
import com.sort.mapper.AdminMapper;
import com.sort.service.AdminService;
import com.sort.util.JwtUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public AdminVo selectByNameAndPassword(String username, String password) {

        Admin admin = this.getOne (new LambdaQueryWrapper<Admin> (  ).eq (Admin::getUsername, username).eq (Admin::getPassword,password));
        Assert.isTrue (admin!=null, "未查询到管理员，请重试！！");
        String token = jwtUtil.generateToken (ObjectEnum.ADMIN.getRole (), admin);
        AdminVo adminVo = new AdminVo (  );
        BeanUtils.copyProperties (admin,adminVo);
        adminVo.setToken (token);
        System.out.println (token );
        System.out.println (adminVo.getUsername () );
        return adminVo;
    }
}
