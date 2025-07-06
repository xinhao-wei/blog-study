package com.wei.config;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyBaseMapper<T> extends BaseMapper<T> {

    Integer deleteAll();

    int myInsertAll(T entity);

    int mysqlInsertAllBatch(@Param("list") List<T> batchList);
}