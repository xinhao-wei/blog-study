package com.wei.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wei.system.sys.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {
    /**
     * 批量插入
     * @param list 插入数据
     * @return 影响记录行数
     */
    int insertBatchSomeColumn(@Param("list") List<SysUserEntity> list);

}
