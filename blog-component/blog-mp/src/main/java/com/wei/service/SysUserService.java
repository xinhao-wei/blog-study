package com.wei.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wei.system.sys.SysUserEntity;

import java.util.List;

public interface SysUserService extends IService<SysUserEntity> {
    /**
     * 添加用户接口
     * @param user
     */
    public void insertUser(SysUserEntity user);

    public List<SysUserEntity> flowSelect();

    /**
     * 选装组件使用
     * @return
     */
    Integer selectInstallPlugin(List<SysUserEntity> addUserList);
}
