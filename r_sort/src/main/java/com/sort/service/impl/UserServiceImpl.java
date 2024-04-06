package com.sort.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sort.entity.User;
import com.sort.entity.vo.LoginVo;
import com.sort.entity.vo.RequestLoginVo;
import com.sort.entity.vo.UserVo;
import com.sort.mapper.UserMapper;
import com.sort.service.UserService;
import com.sort.util.JwtUtil;
import com.sort.util.RestTemplateUtil;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
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
    public LoginVo wxLogin(UserVo userVo) {
        // 调用微信接口
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+userVo.getAppid ()+"&secret="+userVo.getAppSceret ()+"&js_code="+userVo.getCode ()+"&grant_type=authorization_code";
        RequestLoginVo requestLoginVo = restTemplateUtil.post (url, RequestLoginVo.class);
        System.out.println (requestLoginVo );
        //如果不存在就添加用户
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
        //返回令牌
        String token = jwtUtil.createToken (map1);
        LoginVo loginVo = new LoginVo ();
        User user = getUserInfo (requestLoginVo.getOpenid ());
        BeanUtils.copyProperties (user,loginVo);
        loginVo.setToken (token);
        return loginVo;
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

    @Override
    public int updateScore(String username, int score) {
        User user = this.getOne (new LambdaQueryWrapper<User> ().eq (User::getUsername, username));
        int score_before = user.getScore ();
        boolean save = false;
        if (user.getSign () == 0){
            user.setScore (score_before + score);
            user.setSign (1);
            save = this.saveOrUpdate (user);
        }
        if (save) return score_before + score;
        return score_before;
    }

    public boolean createUser(User user){
        boolean save = this.save (user);
        return save;
    }

    public boolean isExist(String openid){
        User user = this.getOne (new LambdaQueryWrapper<User> ().eq (User::getOpenid, openid));
        return true? user!=null:false;
    }

    public User getUserInfo(String openid){
        User user = new User (  );
        if (StringUtils.isNotBlank (openid)){
            user = this.getOne (new LambdaQueryWrapper<User> ().eq (User::getOpenid, openid));

        }
        return user;
    }
}

