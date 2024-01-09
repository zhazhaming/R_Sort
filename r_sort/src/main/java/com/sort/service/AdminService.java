package com.sort.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sort.entity.Admin;
import com.sort.entity.vo.AdminVo;
import com.sort.mapper.AdminMapper;
import org.springframework.stereotype.Service;

/**
 * @Author: zhazhaming
 * @Date: 2024/01/07/15:58
 */
public interface AdminService extends IService<Admin> {

    public AdminVo selectByNameAndPassword(String username, String password);

    public void logout(String adminId);
}
