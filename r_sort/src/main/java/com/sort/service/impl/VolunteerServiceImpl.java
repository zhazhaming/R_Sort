package com.sort.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sort.constant.PageConstant;
import com.sort.entity.Volunteer;
import com.sort.entity.request.VolunteerApiRequest;
import com.sort.entity.vo.VolunteerVo;
import com.sort.mapper.VolunteerMapper;
import com.sort.service.VolunteerService;
import com.sort.util.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class VolunteerServiceImpl extends ServiceImpl<VolunteerMapper, Volunteer> implements VolunteerService {

    @Autowired
    private RestTemplateUtil restTemplateUtil;

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
        // 获取当前时间，筛选过期数据
        List<Volunteer> volunteerResList = VolunteerList.stream ( ).filter (v -> v.getEndDate ( ).isAfter (LocalDate.now ( ).atStartOfDay ())).collect(Collectors.toList());
        return volunteerResList;
    }

    @Override
    public Volunteer getVolunteerDetil(String volunteerId) {
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

    @Override
    public Integer reqVolunteer(Integer volunteerNumber) {
        String url = "https://www.izyz.org/v2/api/gdzyz/home/mission/screening?pageIndex=1&pageSize="+volunteerNumber+"&selectedLabelIdList=090f027df33511ea8f30a8494d31d019";
        String item_url = "https://www.izyz.org/mission/detail-";

        List<VolunteerVo> volunteerVoList = restTemplateUtil.get (url, VolunteerApiRequest.class).getData ( ).getRecords ( );
        List<Volunteer> volunteerMissionList = this.list (new LambdaQueryWrapper<Volunteer> ( ).select (Volunteer::getMissionId));

        // 使用stream流剔除volunteerVoList的missionId属性出现在volunteerMissionList集合中的类对象,最后使用map映射为Volunteer对象
        List <Volunteer> volunteersList = volunteerVoList.stream ( ).filter (volunteerVo -> !volunteerMissionList.contains (volunteerVo.getMissionId ( )))
                .map (volunteerVo -> new Volunteer (UUID.randomUUID ().toString (), volunteerVo.getMissionId (), volunteerVo.getDistrictName (), volunteerVo.getSubject (),volunteerVo.getStartDate (),
                        volunteerVo.getEndDate (),volunteerVo.getMissionTypeName (),volunteerVo.getMissionRegionName (),item_url+volunteerVo.getMissionId ())).collect (Collectors.toList ( ));

        // 加载到数据库中
        boolean saveBatch = this.saveBatch (volunteersList, volunteersList.size ( ));
        if (saveBatch) return volunteersList.size ();
        else return -1;

    }
}
