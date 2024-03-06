package com.sort.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.sort.Enum.ResponMsg;
import com.sort.entity.User;
import com.sort.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "用户端接口")
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public R<User> login(String condition, String password){
        if (condition==null || password==null){
            return R.failed(ResponMsg.USER_LOGIN_ERROR.msg());
        }
        User user = userService.searchUser(condition, password);
        return R.ok(user).setCode(200);
    }

    @GetMapping("/check")
    public R<Boolean> check(String condition){
        int count = 0;
        if (search(condition,'@')){
            count = userService.searchByEmail(condition);
        }else {
            count = userService.searchByName(condition);
        }
        Boolean isTrue = count>0?true:false;
        return R.ok(isTrue).setCode(200);
    }

    public boolean search(String target, char s){
        for (int i = 0; i <target.length() ; i++) {
            if (s == target.charAt(i)) return true;
        }
        return false;
    }

}
