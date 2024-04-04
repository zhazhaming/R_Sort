package com.sort.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sort.entity.Image;

import java.util.List;

public interface ImageService extends IService<Image> {

    public List<String> getImageUrl(Integer pageSize);

    public List<String> getVideoUrl(Integer pageSize);
}
