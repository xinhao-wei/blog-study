package com.wei.config;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;

/**
 * @Author xinhao
 * @Date 2025/7/7 0:07
 */
public class SqlInsertAllBatch extends AbstractMethod {
    /**
     * @param methodName 方法名
     * @since 3.5.0
     */
    protected SqlInsertAllBatch(String methodName) {
        super(methodName);
    }

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        return null;
    }
}
