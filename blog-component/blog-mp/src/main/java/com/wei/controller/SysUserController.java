package com.wei.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wei.common.R;
import com.wei.service.impl.SysUserServiceImpl;
import com.wei.system.sys.SysUserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserServiceImpl sysUserService;


    @PostMapping
    public R Login(String userName, String password){
        return R.ok();
    }

    public R<Boolean> addUser() {

        return R.ok();
    }

    @GetMapping("/user/list")
    public R<List<SysUserEntity>> getUserList(){
        List<SysUserEntity> userEntities = sysUserService.list();
        return R.ok(userEntities);
    }

    @GetMapping("id")
    public R<SysUserEntity> getUser(@RequestParam("userId") Long userId){
        SysUserEntity sysUserEntity = sysUserService.getById(userId);
        return R.ok(sysUserEntity);
    }

    @GetMapping("page")
    public R<List<SysUserEntity>> getUserPage(@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                              @RequestParam("pageNum") Integer pageNum){
        Page<SysUserEntity> sysUserEntityPage = new Page<>(pageSize, pageNum);
        QueryWrapper<SysUserEntity> sysUserEntityQueryWrapper = new QueryWrapper<>();
        sysUserEntityQueryWrapper.eq("username", "admin");
        Page<SysUserEntity> page = sysUserService.page(sysUserEntityPage, sysUserEntityQueryWrapper);
        List<SysUserEntity> records = page.getRecords();
        long total = page.getTotal();
        log.info("总数量" + total);
        return R.ok(records);
    }

    @GetMapping("count")
    public R<Long> getUserCount(){
        // 直接查询
        long count = sysUserService.count();
        // 适用query查询条件
        QueryWrapper<SysUserEntity> sysUserEntityQueryWrapper = new QueryWrapper<>();
        sysUserEntityQueryWrapper.eq("username", "admin");
        long queryCount = sysUserService.count(sysUserEntityQueryWrapper);
        log.info("查询条件的数量：" + queryCount);
        return R.ok(count);
    }

    @GetMapping("flow")
    public R<List<SysUserEntity>> flowSelect() {
        List<SysUserEntity> sysUserEntities = sysUserService.flowSelect();
        return R.ok(sysUserEntities);
    }


    @PostMapping("plugin")
    public R<Integer> selectInstallPlugin(@RequestBody List<SysUserEntity> addUserList) {
        Integer count = sysUserService.selectInstallPlugin(addUserList);
        return R.ok(count);
    }

}
