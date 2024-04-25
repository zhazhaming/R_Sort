package com.sort.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.sort.Enum.ResponMsg;
import com.sort.entity.User;
import com.sort.entity.vo.LoginVo;
import com.sort.entity.vo.RequestLoginVo;
import com.sort.entity.vo.UserVo;
import com.sort.service.UserService;
import com.sort.util.RestTemplateUtil;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
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
    public R<LoginVo> wxLogin(@RequestBody UserVo userVo){
        if (userVo.getCode () == null || userVo.getCode ().equals ("")){
            return R.failed (ResponMsg.Error.msg ());
        }
        LoginVo loginVo = userService.wxLogin (userVo);
        return R.ok (loginVo).setMsg (ResponMsg.Success.msg ()).setCode (ResponMsg.Success.status ());
    }

    @PostMapping("/updateScore")
    public R<Integer> updateScore(@RequestParam String username, @RequestParam Integer score){
        if (StringUtils.isBlank (username)){
            R.failed (ResponMsg.PARAMETER_ERROR.msg ());
        }
        Integer result = userService.updateScore (username, score);
        if (result>0) return R.ok (result).setMsg (ResponMsg.Success.msg ()).setCode (ResponMsg.Success.status ());
        return R.failed (ResponMsg.USER_UPDATA_SCORE_ERROR.msg ());
    }

    @GetMapping("/getScore")
    public R<Integer> getscore(@RequestParam String openid){
        int getscore = userService.getscore (openid);
        if (getscore == -1){
            return R.failed ("用户不存在或者openid错误");
        }
        return R.ok(getscore).setCode (ResponMsg.Success.status ());
    }

}
