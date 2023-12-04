package com.sort.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.sort.config.ResponMsg;
import com.sort.entity.Article;
import com.sort.entity.Volunteer;
import com.sort.service.VolunteerService;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(description = "志愿查询接口")
@CrossOrigin
@RequestMapping("/volunteer")
public class VolunteerController {

    @Autowired
    VolunteerService volunteerService;

    @GetMapping("/getVolunteerList")
    public R<List<Volunteer>> getVolunteerList(@RequestParam Integer page,
                                            @RequestParam Integer pageSize){
        //传参设置判断
        if (page==null || pageSize==null){
            R.failed(ResponMsg.VOLUNTEER_PAGESIZE_ERROR.msg());
        }
        //传参小于0判断
        if (page<=0 ||pageSize <= 0){
            if (page<=0) page = 1;
            if (pageSize<=0) pageSize=1;
        }
        Integer count = volunteerService.getVolunteerCounts ();
        if (pageSize>count) pageSize = count;
        Integer pageLimit = count/pageSize;
        //传参页数大于所有数据判断
        if (page>pageLimit){
            page = pageLimit;
        }
        List<Volunteer> volunteerList = volunteerService.getVolunteerList (page, pageSize);
        return R.ok (volunteerList);
    }

    @GetMapping("/getVolunteerDetail")
    public R<Volunteer> getVolunteerDetail(@RequestParam Integer volunteerId){
        if (volunteerId==null){
            R.failed(ResponMsg.VOLUNTEER_ID_ERROR.msg());
        }
        Volunteer volunteerDetil = volunteerService.getVolunteerDetil (volunteerId);
        return R.ok (volunteerDetil);
    }

    @GetMapping("/getVolunteerByRegion")
    public R<List<Volunteer>> getVolunteerByRegion(@RequestParam String region){
        if (region.equals ("") || region==null){
            R.failed(ResponMsg.VOLUNTEER_REGION_ERROR.msg());
        }
        List<Volunteer> volunteerRegionList = volunteerService.getVolunteerByRegion (region);
        return R.ok (volunteerRegionList);
    }
}
