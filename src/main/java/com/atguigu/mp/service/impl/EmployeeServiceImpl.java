package com.atguigu.mp.service.impl;

import com.atguigu.mp.beans.Employee;
import com.atguigu.mp.mapper.EmployeeMapper;
import com.atguigu.mp.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gxl
 * @since 2021-08-23
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    //不用再进行mapper的注入

    /**
     * EmployeeServiceImpl 继承了ServiceImpl
     * 1.在ServiceImpl中已经完成了Mapper对象的注入，直接在EmployeeServiceImpl中进行使用
     * 2.在ServiceImpl中也提供了常用的CRUD方法。基本的一些CRUD方法在Service中不需要自己定义
     */
}
