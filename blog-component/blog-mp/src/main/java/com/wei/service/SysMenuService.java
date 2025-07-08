package com.wei.service;

import com.wei.domain.entity.SysMenuEntity;

import java.util.List;

/**
 * @Author xinhao
 * @Date 2025/7/8 15:16
 */
public interface SysMenuService {

    List<SysMenuEntity> getSysMenuList();

    List<String> simpleQueryUsed();

}
