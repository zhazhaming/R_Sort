package com.sort.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.sort.entity.GarbageEncyclopedia;
import com.sort.mapper.GarbageEncyclopediaMapper;
import com.sort.service.GarbageEncyclopediaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-02-08
 */
@Service
public class GarbageEncyclopediaServiceImpl extends ServiceImpl<GarbageEncyclopediaMapper, GarbageEncyclopedia> implements GarbageEncyclopediaService {

    @Override
    public List<GarbageEncyclopedia> getByName(String name) {
        QueryWrapper<GarbageEncyclopedia> wrapperEncyclopedia = new QueryWrapper<>();
        QueryWrapper<GarbageEncyclopedia> garbage_name = wrapperEncyclopedia.like("garbage_name", name);

        List<GarbageEncyclopedia> garbageEncyclopedias = baseMapper.selectList(wrapperEncyclopedia);
        return garbageEncyclopedias;
    }

    @Override
    public List<GarbageEncyclopedia> selectByType(String typeId) {
        QueryWrapper<GarbageEncyclopedia> wrapperEncyclopedia = new QueryWrapper<>();
        wrapperEncyclopedia.eq("garbage_type", typeId);
        List<GarbageEncyclopedia> garbageEncyclopedias = baseMapper.selectList(wrapperEncyclopedia);
        return garbageEncyclopedias;
    }


}
