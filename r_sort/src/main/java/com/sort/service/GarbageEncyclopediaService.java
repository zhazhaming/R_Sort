package com.sort.service;

import com.sort.entity.GarbageEncyclopedia;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2022-02-08
 */
public interface GarbageEncyclopediaService extends IService<GarbageEncyclopedia> {

    List<GarbageEncyclopedia> getByName(String name);

    List<GarbageEncyclopedia> selectByType(String typeId);
}
