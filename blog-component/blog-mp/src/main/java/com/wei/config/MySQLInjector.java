package com.wei.config;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;
import org.apache.ibatis.session.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class MySQLInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Configuration configuration, Class<?> mapperClass, TableInfo tableInfo) {
        // 1. 获取父级创建的方法
        List<AbstractMethod> methodList = super.getMethodList(configuration, mapperClass, tableInfo);
        // 2. 增加组件，新增操作时，不会对逻辑删除字段进行设置
        /** InsertBatchSomeColumn有无参和带参两种构造方法
         *	无参构造会将插入记录的所有属性进行设置
         *	带参构造可自定义具体对一条数据的哪些属性进行设置
         */
        methodList.add(new InsertBatchSomeColumn(new Predicate<TableFieldInfo>() {
            @Override
            public boolean test(TableFieldInfo tableFieldInfo) {
                // 排除逻辑删除字段（可以给多个不需要的字段）
                return !tableFieldInfo.isLogicDelete();
            }
        }));
        // 3. 返回
        return methodList;
    }
}
