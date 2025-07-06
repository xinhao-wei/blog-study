//package com.wei.config;
//
//import com.baomidou.mybatisplus.core.injector.AbstractMethod;
//import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
//import com.baomidou.mybatisplus.core.metadata.TableInfo;
//import org.apache.ibatis.session.Configuration;
//
//import java.util.List;
//
///**
// * @Author xinhao
// * @Date 2025/7/7 0:08
// */
//public class MyLogicSqlInjector extends DefaultSqlInjector {
//
//    @Override
//    public List<AbstractMethod> getMethodList(Configuration configuration, Class<?> mapperClass, TableInfo tableInfo) {
//        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
//        methodList.add(new DeleteAll());
//        methodList.add(new MyInsertAll());
//        methodList.add(new MysqlInsertAllBatch());
//        return methodList;
//    }
//}
