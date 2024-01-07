package com.sort.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.sort.entity.GarbageEncyclopedia;
import com.sort.entity.vo.GarbageTypeVo;
import com.sort.service.GarbageEncyclopediaService;
import com.sort.service.GarbageTypeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-02-13
 */
@RestController
@RequestMapping("api/v1/sort/garbagetype")
@CrossOrigin
public class GarbageTypeController {
    @Autowired
    private GarbageEncyclopediaService garbageEncyclopediaService;
    @Autowired
    private GarbageTypeService garbageTypeService;


    @GetMapping()
    @ApiOperation(value = "模糊查询垃圾类别,参数为空时")
    public R getPublishCourseInfo() {
        List<GarbageTypeVo> garbageTypeVos = new ArrayList<>();
        return R.ok(garbageTypeVos);
    }

    @GetMapping("{name}")
    @ApiOperation(value = "模糊查询垃圾类别")
    public R getPublishCourseInfo(@PathVariable(value = "name") String name) {
        List<GarbageEncyclopedia> garbageEncyclopediaList = garbageEncyclopediaService.getByName(name);

        List<GarbageTypeVo> garbageTypeVos = garbageTypeService.selectList(garbageEncyclopediaList);
        return R.ok(garbageTypeVos);
    }
}

