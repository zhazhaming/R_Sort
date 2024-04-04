package com.sort.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.sort.Enum.ResponMsg;
import com.sort.service.ImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(description = "图片服务接口")
@CrossOrigin
@RequestMapping("api/v1/images")
public class ImageController {

    @Autowired
    ImageService imageService;

    @GetMapping("/random")
    @ApiOperation(value = "随机返回n个图片url")
    public R <List<String>> get_random_picture(@RequestParam Integer pageSize){
        List<String> UrlList = imageService.getImageUrl(pageSize);
        return R.ok(UrlList).setCode(ResponMsg.Success.status ( ));
    }

    @GetMapping("/randomVideo")
    @ApiOperation(value = "随机返回n个视频url")
    public R <List<String>> get_random_video(@RequestParam Integer pageSize){
        List<String> UrlList = imageService.getVideoUrl(pageSize);
        return R.ok(UrlList).setCode(ResponMsg.Success.status ( ));
    }
}