package com.sort.entity.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Author: zhazhaming
 * @Date: 2024/04/04/15:53
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="RequestLoginVo对象", description="获取微信服务器登录凭证接收对象")
public class RequestLoginVo {

    private String session_key;
    private String unionid;
    private String errmsg;
    private String openid;
    private int errcode;
}
