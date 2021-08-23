package com.atguigu.mp.metaObjectHandler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * @description: 自定义的公共字段填充处理器
 * @author: gxl
 * @createDate: 2021/8/23 19:09
 */
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入操作自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        //获取需要被填充的字段的值
        Object fieldValue = getFieldValByName("name",metaObject);
        if(fieldValue == null){
            System.out.println("*****插入操作满足填充条件******");
            setFieldValByName("name","tdr",metaObject);
        }
    }

    /**
     * 修改操作自动填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        Object fieldValue = getFieldValByName("name",metaObject);
        if(fieldValue == null){
            System.out.println("*****更新操作满足填充条件******");
            setFieldValByName("name","jxf",metaObject);
        }
    }
}
