package com.sort.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.sort.Enum.ResponMsg;
import com.sort.constant.PageConstant;
import com.sort.entity.Volunteer;
import com.sort.service.VolunteerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(description = "志愿查询接口")
@CrossOrigin
@RequestMapping("api/v1/volunteer")
public class VolunteerController {

    @Autowired
    VolunteerService volunteerService;

    @GetMapping("/getVolunteerList")
    public R<List<Volunteer>> getVolunteerList(@RequestParam Integer pageNum,
                                            @RequestParam Integer pageSize){

        List<Volunteer> volunteerList = volunteerService.getVolunteerList (pageNum, pageSize);
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
