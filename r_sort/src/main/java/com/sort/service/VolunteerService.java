package com.sort.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sort.entity.Article;
import com.sort.entity.Volunteer;

import java.util.List;

public interface VolunteerService extends IService<Volunteer> {

    public List<Volunteer> getVolunteerList(Integer page,Integer pagesize);

    public Volunteer getVolunteerDetil(String articleId);

    public Integer getVolunteerCounts();

    public List<Volunteer> getVolunteerByRegion(String region);

    public Integer reqVolunteer(Integer  volunteerNumber);
}
