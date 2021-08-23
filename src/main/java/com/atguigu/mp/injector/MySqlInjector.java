package com.atguigu.mp.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

import java.util.List;

/**
 * @description: 自定义全局操作
 * @author: gxl
 * @createDate: 2021/8/23 17:24
 */
public class MySqlInjector extends AbstractMethod {

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        //注入SQL语句
        String sql = "delete from "+tableInfo.getTableName();
        //注入的方法名，一定要与EmployeeMapper接口中方法名一致
        String mySqlMethod = "deleteAll";

        //构造SqlSource对象
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);

        //构造一个删除的MappedStatement
        return addUpdateMappedStatement(mapperClass, modelClass, mySqlMethod, sqlSource);
    }
}
