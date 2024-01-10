package com.sort.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sort.constant.PageConstant;
import com.sort.entity.Volunteer;
import com.sort.mapper.VolunteerMapper;
import com.sort.service.VolunteerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerServiceImpl extends ServiceImpl<VolunteerMapper, Volunteer> implements VolunteerService {

    @Override
    public List<Volunteer> getVolunteerList(Integer pageNum, Integer pageSize) {
        //传参设置判断
        if (pageNum==null || pageSize==null){
            pageNum = PageConstant.pageNum;
            pageSize = PageConstant.pageSize;
        }
        //传参小于0判断
        if (pageNum<=0 ||pageSize <= 0){
            if (pageNum<=0) pageNum = 1;
            if (pageSize<=0) pageSize=10;
        }
        Integer count = this.getVolunteerCounts ();
        if (pageSize>count) pageSize = count;
        Integer pageLimit = count/pageSize;
        //传参页数大于所有数据判断
        if (pageNum>pageLimit){
            pageNum = pageLimit;
        }
        Page<Volunteer>  volunteerPage= new Page<> (pageNum,pageSize);
        LambdaQueryWrapper<Volunteer> volunteerLambdaQueryWrapper = new LambdaQueryWrapper<Volunteer> ( ).select (Volunteer::getId, Volunteer::getMissionId, Volunteer::getDistrictName, Volunteer::getSubject,
                Volunteer::getStartDate, Volunteer::getEndDate, Volunteer::getMissionTypeName, Volunteer::getMissionRegionName, Volunteer::getUrl).orderByDesc (Volunteer::getStartDate);
        baseMapper.selectPage(volunteerPage, volunteerLambdaQueryWrapper);
        List<Volunteer> VolunteerList = volunteerPage.getRecords();
        return VolunteerList;
    }

    @Override
    public Volunteer getVolunteerDetil(Integer volunteerId) {

        Volunteer volunteer = this.getOne ( new LambdaQueryWrapper<Volunteer> (  ).eq (Volunteer::getId,volunteerId) );
        return volunteer;
    }

    @Override
    public Integer getVolunteerCounts() {
        Integer volunteerCount = this.count ( new LambdaQueryWrapper<Volunteer> (  ) );
        return volunteerCount;
    }

    @Override
    public List<Volunteer> getVolunteerByRegion(String region) {

        List<Volunteer> volunteerList = this.list ( new LambdaQueryWrapper<Volunteer> (  ).eq (Volunteer::getMissionRegionName,region).orderByDesc (Volunteer::getStartDate) );
        return volunteerList;
    }

}
