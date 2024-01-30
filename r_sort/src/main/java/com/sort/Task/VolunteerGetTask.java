package com.sort.Task;

import com.sort.constant.VolunteerConstant;
import com.sort.service.VolunteerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: zhazhaming
 * @Date: 2024/01/13/16:57
 */
@Slf4j
@Component
public class VolunteerGetTask {

    @Autowired
    VolunteerService volunteerService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void getVolunteerTask(){
        log.info ("执行定时任务,每天零点获取志愿者任务");
        volunteerService.reqVolunteer (VolunteerConstant.volunteer_request_number);
    }



}
