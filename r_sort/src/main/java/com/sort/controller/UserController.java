package com.sort.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.sort.Enum.ResponMsg;
import com.sort.entity.User;
import com.sort.entity.vo.RequestLoginVo;
import com.sort.entity.vo.UserVo;
import com.sort.service.UserService;
import com.sort.util.RestTemplateUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(description = "用户端接口")
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RestTemplateUtil restTemplateUtil;

    @PostMapping("/wx_login")
    public R<String> wxLogin(@RequestBody UserVo userVo){
        String token = userService.wxLogin (userVo);
        System.out.println (token );
        return R.ok (token).setMsg (ResponMsg.Success.msg ()).setCode (ResponMsg.Success.status ());
    }

}
