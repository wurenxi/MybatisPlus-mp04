package com.atguigu.mp.mapper;

import com.atguigu.mp.beans.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gxl
 * @since 2021-08-23
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
    int deleteAll();
}
