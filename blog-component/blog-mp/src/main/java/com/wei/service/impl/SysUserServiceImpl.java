package com.wei.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wei.dao.SysUserMapper;
import com.wei.service.SysUserService;
import com.wei.system.sys.SysUserEntity;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {

    @Override
    public void insertUser(SysUserEntity user) {
        baseMapper.insert(user);
    }

    @Override
    public List<SysUserEntity> flowSelect() {

        // 结合分页，按批次从数据库拉取数据出来跑批，例如从数据库获取10万记录，做数据处理
        Page<SysUserEntity> page = new Page<>(1, 100000);
        baseMapper.selectList(page, Wrappers.emptyWrapper(), new ResultHandler<SysUserEntity>() {
            int count = 0;
            @Override
            public void handleResult(ResultContext<? extends SysUserEntity> resultContext) {
                SysUserEntity sysUserEntity = resultContext.getResultObject();
                System.out.println("当前处理第" + (++count) + "条记录: " + sysUserEntity);
                // 在这里进行你的业务处理，比如分发任务
            }
        });

        return null;
    }
}
