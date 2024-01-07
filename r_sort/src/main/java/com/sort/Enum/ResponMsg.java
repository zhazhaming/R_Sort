package com.sort.Enum;

public enum ResponMsg {

    ARTICLE_PAGESIZE_ERROR(505,false,"文章分页设置错误，请重试！！"),
    ARTICLE_ID_ERROR(506,false,"文章id错误，请重试！！"),
    VOLUNTEER_PAGESIZE_ERROR(507,false,"志愿者分页设置错误，请重试！！"),
    VOLUNTEER_ID_ERROR(508,false,"志愿者id错误，请重试！！"),
    VOLUNTEER_REGION_ERROR(509,false,"志愿者所在地区错误，请重试！！"),
    ADMIN_LOGIN_PARAMERROR(510,false,"管理员名称和密码不能为空，请重试！！");


    // 响应业务状态
    private Integer status;
    // 调用是否成功
    private Boolean success;
    // 响应消息，可以为成功或者失败的消息
    private String msg;

    ResponMsg(Integer status,Boolean success,String msg){
        this.status = status;
        this.success = success;
        this.msg = msg;
    }
    public Integer status(){
        return status;
    }
    public Boolean success(){
        return success;
    }
    public String msg(){
        return msg;
    }
}
