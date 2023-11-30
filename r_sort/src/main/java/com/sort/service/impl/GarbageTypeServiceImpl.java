package com.sort.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sort.entity.GarbageEncyclopedia;
import com.sort.entity.GarbageType;
import com.sort.entity.vo.GarbageTypeVo;
import com.sort.mapper.GarbageTypeMapper;
import com.sort.service.GarbageTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.swing.text.WrappedPlainView;
import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-02-13
 */
@Service
public class GarbageTypeServiceImpl extends ServiceImpl<GarbageTypeMapper, GarbageType> implements GarbageTypeService {

    @Override
    public GarbageTypeVo getByType(int type) {
        QueryWrapper<GarbageType> wrapperType = new QueryWrapper<>();
        wrapperType.eq("g_type",type);
        GarbageType garbageType = baseMapper.selectOne(wrapperType);
        GarbageTypeVo garbageTypeVo = new GarbageTypeVo();
        BeanUtils.copyProperties(garbageType,garbageTypeVo);
        return garbageTypeVo;
    }

    @Override
    public List<GarbageTypeVo> selectList(List<GarbageEncyclopedia> garbageEncyclopediaList) {
        List<GarbageTypeVo> garbageTypeVos = new ArrayList<>();
        for (int i = 0;i < garbageEncyclopediaList.size();i++){
            GarbageTypeVo garbageTypeVo = getByType(garbageEncyclopediaList.get(i).getGarbageType());
            garbageTypeVo.setName(garbageEncyclopediaList.get(i).getGarbageName());
            garbageTypeVos.add(garbageTypeVo);
        }
        return garbageTypeVos;
    }
}
