package com.sort.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.sort.Enum.ResponMsg;
import com.sort.constant.PageConstant;
import com.sort.constant.VolunteerConstant;
import com.sort.entity.Volunteer;
import com.sort.service.VolunteerService;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
        return R.ok (volunteerList).setCode (ResponMsg.Success.status ( ));
    }

    @GetMapping("/getVolunteerDetail")
    public R<Volunteer> getVolunteerDetail(@RequestParam String volunteerId){
        if (StringUtils.isBlank (volunteerId)){
            R.failed(ResponMsg.VOLUNTEER_ID_ERROR.msg()).setCode (ResponMsg.VOLUNTEER_ID_ERROR.status ( ));
        }
        Volunteer volunteerDetil = volunteerService.getVolunteerDetil (volunteerId);
        return R.ok (volunteerDetil).setCode (ResponMsg.Success.status ( ));
    }

    @GetMapping("/getVolunteerByRegion")
    public R<List<Volunteer>> getVolunteerByRegion(@RequestParam String region){
        if (region.equals ("") || region==null){
            R.failed(ResponMsg.VOLUNTEER_REGION_ERROR.msg()).setCode (ResponMsg.VOLUNTEER_REGION_ERROR.status ());
        }
        List<Volunteer> volunteerRegionList = volunteerService.getVolunteerByRegion (region);
        return R.ok (volunteerRegionList).setCode (ResponMsg.Success.status ( ));
    }

    @GetMapping("/reqVolunteer")
    @Transactional
    public R<Integer> reqVolunteer(){
        Integer integer = volunteerService.reqVolunteer (VolunteerConstant.volunteer_request_number);
        return  integer>=0?R.ok (integer).setCode (ResponMsg.Success.status ( )):R.failed (ResponMsg.VOLUNTEER_REQUSET_ERROR.msg());
    }
}
