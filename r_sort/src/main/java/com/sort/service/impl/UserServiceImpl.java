package com.sort.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sort.entity.User;
import com.sort.entity.vo.RequestLoginVo;
import com.sort.entity.vo.UserVo;
import com.sort.mapper.UserMapper;
import com.sort.service.UserService;
import com.sort.util.JwtUtil;
import com.sort.util.RestTemplateUtil;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    RestTemplateUtil restTemplateUtil;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public String wxLogin(UserVo userVo) {
//        Map<String, Object> map = new HashMap<> ();
//        map.put ("appid",userVo.getAppid ());
//        map.put ("secret",userVo.getAppSceret ());
//        map.put ("js_code",userVo.getCode ());
//        map.put ("grant_type","authorization_code");
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+userVo.getAppid ()+"&secret="+userVo.getAppSceret ()+"&js_code="+userVo.getCode ()+"&grant_type=authorization_code";
        RequestLoginVo requestLoginVo = restTemplateUtil.post (url, RequestLoginVo.class);
        System.out.println (requestLoginVo );
        if (!isExist (requestLoginVo.getOpenid ())){
            User user = new User (  );
            BeanUtils.copyProperties (userVo,user);
            user.setScore (0);
            user.setOpenid (requestLoginVo.getOpenid ());
            user.setSessionKey (requestLoginVo.getSession_key ());
            user.setUnionId (requestLoginVo.getOpenid ());
            boolean user1 = createUser (user);
        }
        Map<String,Object> map1 =new HashMap<> (  );
        map1.put ("openid",requestLoginVo.getOpenid ());
        map1.put ("sessionkey",requestLoginVo.getSession_key ());
        return jwtUtil.createToken (map1);
    }

    public boolean createUser(User user){
        boolean save = this.save (user);
        return save;
    }

    public boolean isExist(String openid){
        User user = this.getOne (new LambdaQueryWrapper<User> ().eq (User::getOpenid, openid));
        return true? user!=null:false;
    }

    @Override
    public boolean updateSign() {
        List<User> userList = this.list (new LambdaQueryWrapper<User> ( ));
        for (User users: userList) {
            users.setSign (0);
        }
        boolean save = this.saveOrUpdateBatch (userList,userList.size ());
        return save;
    }
}
