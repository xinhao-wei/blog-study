package com.wei.controller;

import com.wei.common.R;
import com.wei.service.impl.SysUserServiceImpl;
import com.wei.system.sys.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserServiceImpl sysUserService;


    @PostMapping
    public R Login(String userName, String password){
        return R.ok();
    }

    @GetMapping("/user/list")
    public R<List<SysUserEntity>> getUserList(){
        List<SysUserEntity> userEntities = sysUserService.list();
        return R.ok(userEntities);
    }

    @GetMapping("id")
    public R<SysUserEntity> getUser(){
        SysUserEntity sysUserEntity = sysUserService.getById(1L);
        return R.ok(sysUserEntity);
    }

}
