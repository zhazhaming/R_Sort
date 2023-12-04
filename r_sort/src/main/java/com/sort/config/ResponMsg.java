package com.sort.config;

public enum ResponMsg {

    ARTICLE_PAGESIZE_ERROR(505,false,"文章分页设置错误，请重试！！"),
    ARTICLE_ID_ERROR(506,false,"文章id错误，请重试！！");


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
