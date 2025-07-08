package com.wei.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.toolkit.SimpleQuery;
import com.wei.domain.entity.SysMenuEntity;
import com.wei.service.SysMenuService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @Author xinhao
 * @Date 2025/7/8 15:16
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Override
    public List<SysMenuEntity> getSysMenuList() {
        SysMenuEntity sysMenuEntity = new SysMenuEntity();
        QueryWrapper<SysMenuEntity> sysMenuEntityQueryWrapper = new QueryWrapper<>();
        sysMenuEntityQueryWrapper.in("menu_id", Arrays.asList(1L, 2L, 3L));
        List<SysMenuEntity> sysMenuEntities = sysMenuEntity.selectList(sysMenuEntityQueryWrapper);
        return sysMenuEntities;
    }

    @Override
    public List<String> simpleQueryUsed() {
        return SimpleQuery.list(
                Wrappers.lambdaQuery(SysMenuEntity.class).like(SysMenuEntity::getName, "看"),
                SysMenuEntity::getName,
                // 进行peek操作
                System.out::println
        );
    }
}
