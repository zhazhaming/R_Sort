package com.sort.service;

import com.sort.entity.GarbageEncyclopedia;
import com.sort.entity.GarbageType;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sort.entity.vo.GarbageTypeVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2022-02-13
 */
public interface GarbageTypeService extends IService<GarbageType> {

    GarbageTypeVo getByType(int type);

    List<GarbageTypeVo> selectList(List<GarbageEncyclopedia> garbageEncyclopediaList);
}
