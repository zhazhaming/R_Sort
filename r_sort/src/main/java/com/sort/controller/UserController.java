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

    @PostMapping("/test")
    public R<RequestLoginVo> test(){
        Map<String, Object> map = new HashMap<> ();
        String appid = "wx8b5515246d31aede";
        String  secret = "e94d75e317a404349bd1fbc36aef8b87";
        String js_code = "0a3Gl10006cjSR1yjh100LZ7rH3Gl104";

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+js_code+"&grant_type=authorization_code";
        RequestLoginVo requestLoginVo = restTemplateUtil.post (url, RequestLoginVo.class);
        System.out.println (requestLoginVo );
        return R.ok (requestLoginVo).setMsg (ResponMsg.Success.msg ()).setCode (ResponMsg.Success.status ());
    }

}
