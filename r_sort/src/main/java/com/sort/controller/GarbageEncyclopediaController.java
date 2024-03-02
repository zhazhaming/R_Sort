package com.sort.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.sort.Enum.ResponMsg;
import com.sort.entity.GarbageEncyclopedia;
import com.sort.service.GarbageEncyclopediaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-02-08
 */
@RestController
@Api(description = "垃圾百科接口")
@CrossOrigin
@RequestMapping("api/v1/sort/garbage-encyclopedia")
public class GarbageEncyclopediaController {
    @Autowired
    private GarbageEncyclopediaService garbageEncyclopediaService;

    @GetMapping("{typeId}")
    @ApiOperation(value = "分类查询垃圾数据")
    public R<List<GarbageEncyclopedia>> getGarbageEncyclopedia(@PathVariable @ApiParam("类别编号，1其他垃圾，2可回收垃圾，3厨余垃圾，4有害垃圾") String typeId){
        List<GarbageEncyclopedia> list = garbageEncyclopediaService.selectByType(typeId);
        return R.ok(list).setCode (ResponMsg.Success.status ( ));
    }

    @GetMapping("/random")
    @ApiOperation(value = "随机10个垃圾数据,做知识竞赛数据")
    public R<List<GarbageEncyclopedia>> getGarbageEncyclopediaRandom(){
        List<GarbageEncyclopedia> list = garbageEncyclopediaService.list();
        Collections.shuffle(list);
        List<GarbageEncyclopedia> randomSeries = list.subList(0, 10);
        return R.ok(randomSeries).setCode (ResponMsg.Success.status ( ));
        }

}

