package com.sort.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sort.Enum.ResponMsg;
import com.sort.entity.Image;
import com.sort.mapper.ImageMapper;
import com.sort.service.ImageService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements ImageService {

    @Override
    public List<String> getImageUrl(Integer pageSize){
        //传参设置
        if (pageSize == null ){
            R.failed(ResponMsg.ARTICLE_PAGESIZE_ERROR.msg()).setCode(400);
        }
        //传参小于0判断
        if (pageSize <= 0){
            if (pageSize<=0) pageSize=1;
        }
        // 获取pageNum、pageSize最大边界值
        int maxCount = this.getImageNumber();
        if (pageSize>maxCount) pageSize = maxCount;
        LambdaQueryWrapper<Image> imageLambdaQueryWrapper = new LambdaQueryWrapper<Image>().select( Image::getUrl);
        List<Image> imglist = this.list (imageLambdaQueryWrapper);
        Collections.shuffle(imglist);
        List<String> randomList = imglist.stream ().map (Image::getUrl).collect(Collectors.toList()).subList (0,pageSize);
        return randomList;
    }


    public Integer getImageNumber(){
        int ImageCount = this.count(new LambdaQueryWrapper<Image>());
        return ImageCount;
    }

}
