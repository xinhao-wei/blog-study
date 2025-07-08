package com.wei.controller;

import com.wei.common.R;
import com.wei.domain.entity.SysMenuEntity;
import com.wei.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author xinhao
 * @Date 2025/7/8 15:15
 */
@RequestMapping("/menu")
@RestController
public class SysMenuController {
    @Autowired
    SysMenuService sysMenuService;

    @RequestMapping("/list")
    public R<List<SysMenuEntity>> getSysMenuList(){
        List<SysMenuEntity> sysMenuEntities = sysMenuService.getSysMenuList();
        return R.ok(sysMenuEntities);
    }

    @GetMapping("/simple-query")
    public R<List<String>> simpleQuery() {
        List<String> sysMenuEntities = sysMenuService.simpleQueryUsed();
        return R.ok(sysMenuEntities);
    }

}
