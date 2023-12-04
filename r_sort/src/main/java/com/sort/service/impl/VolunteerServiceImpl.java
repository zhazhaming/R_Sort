package com.sort.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sort.entity.Volunteer;
import com.sort.mapper.VolunteerMapper;
import com.sort.service.VolunteerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerServiceImpl extends ServiceImpl<VolunteerMapper, Volunteer> implements VolunteerService {
    @Override
    public List<Volunteer> getVolunteerList(Integer page, Integer pagesize) {
        Page<Volunteer>  volunteerPage= new Page<> (page,pagesize);
        QueryWrapper<Volunteer> wrapperVolunteer = new QueryWrapper<>();
        wrapperVolunteer.select("Id","SubjectName","Region","Organize","Url","StartTime","EndTime").orderByDesc("StartTime");
        baseMapper.selectPage(volunteerPage, wrapperVolunteer);
        List<Volunteer> VolunteerList = volunteerPage.getRecords();
        return VolunteerList;
    }

    @Override
    public Volunteer getVolunteerDetil(Integer volunteerId) {
        QueryWrapper<Volunteer> wrapperVolunteer = new QueryWrapper<>();
        wrapperVolunteer.eq("id",volunteerId);
        Volunteer volunteer = baseMapper.selectById(volunteerId);
        return volunteer;
    }

    @Override
    public Integer getVolunteerCounts() {
        QueryWrapper<Volunteer> wrapperVolunteer = new QueryWrapper<>();
        Integer volunteerCount = baseMapper.selectCount(wrapperVolunteer);
        return volunteerCount;
    }

    @Override
    public List<Volunteer> getVolunteerByRegion(String region) {
        QueryWrapper<Volunteer> wrapperVolunteer = new QueryWrapper<>();
        wrapperVolunteer.eq("Region",region).orderByDesc ("StartTime");
        List<Volunteer> volunteerList = baseMapper.selectList(wrapperVolunteer);
        return volunteerList;
    }

}
