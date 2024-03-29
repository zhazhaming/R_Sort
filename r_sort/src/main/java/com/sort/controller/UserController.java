package com.sort.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.sort.Enum.ResponMsg;
import com.sort.entity.User;
import com.sort.entity.vo.UserVo;
import com.sort.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
        if (user != null) return R.ok(user).setCode(200).setMsg (ResponMsg.USER_LOGIN_SUCCESS.msg ( ));
        return R.ok (user).setCode (200).setMsg (ResponMsg.USER_LOGIN_NULL.msg ());
    }

    @Transactional
    @PostMapping("/register")
    public R<Boolean> register(UserVo uservo){
        boolean isRegister = userService.createUser (uservo);
        if (isRegister) return R.ok(isRegister).setCode(200).setMsg (ResponMsg.USER_REGISTER_SUCCESS.msg ());
        return R.ok(isRegister).setCode(ResponMsg.USER_REGISTER_ERROR.status ()).setMsg (ResponMsg.USER_REGISTER_ERROR.msg ());
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

    @Transactional
    @PostMapping("/updateScore")
    public R<Boolean> updateScore(String username, int score){
        boolean updateScore = userService.updateScoreAndSign (username, score);
        return R.ok (updateScore).setCode (200);
    }

    public boolean search(String target, char s){
        for (int i = 0; i <target.length() ; i++) {
            if (s == target.charAt(i)) return true;
        }
        return false;
    }

}
