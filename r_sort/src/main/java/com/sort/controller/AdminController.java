package com.sort.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.sort.Enum.ResponMsg;
import com.sort.entity.Admin;
import com.sort.entity.vo.AdminVo;
import com.sort.service.AdminService;
import com.sort.util.JwtUtil;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zhazhaming
 * @Date: 2024/01/07/11:13
 */

@RestController
@Api(description = "管理员端接口")
@CrossOrigin
@RequestMapping("api/v1/admin")
public class AdminController {



    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public R<AdminVo> login(@RequestParam String username, @RequestParam String password){
        if (StringUtils.isBlank (username) || StringUtils.isBlank (password)){
            R.failed (ResponMsg.ADMIN_LOGIN_PARAMERROR.msg ());
        }
        AdminVo admin = adminService.selectByNameAndPassword (username, password);
        return R.ok (admin);
    }
}
