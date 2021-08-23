package com.atguigu.mp.test;

import com.atguigu.mp.beans.Employee;
import com.atguigu.mp.beans.User;
import com.atguigu.mp.mapper.EmployeeMapper;
import com.atguigu.mp.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author gxl
 * @date 2021年08月22日 12:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMP {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    UserMapper userMapper;

    /**
     * 测试公告字段填充
     */
    @Test
    public void testMetaObjectHandler(){
        User user = new User();
        user.setId(5);
        user.setLogicFlag(1);
        userMapper.updateById(user);
    }

    /**
     * 逻辑删除
     */
    @Test
    public void testLogicDelete(){
//        int result = userMapper.deleteById(1);
//        System.out.println("result："+result);

        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    /**
     * 测试自定义全局操作
     */
    @Test
    public void testSqlInjector(){
        int result = employeeMapper.deleteAll();
        System.out.println("result："+result);
    }

    /**
     * 测试乐观锁插件
     */
    @Test
    public void testOptimisticLockerInnerInterceptor(){
        //更新操作
        Employee employee = new Employee();
        employee.setId(14);
        employee.setLastName("Tom");
        employee.setEmail("tom@qq.com");
        employee.setVersion(1);

        employeeMapper.updateById(employee);

    }

    /**
     * 测试性能分析插件
     */
    @Test
    public void testIllegalSQLInnerInterceptor(){
        Employee employee = new Employee("雷神","ls@qq.com","1",21);

        employeeMapper.insert(employee);
    }

    /**
     * 测试SQL执行分析插件
     */
    @Test
    public void testSQLExplain(){
        employeeMapper.delete(null); //全表删除
    }

    /**
     * 测试分页插件
     */
    @Test
    public void testPage(){
        Page<Employee> page = new Page<>(1, 1);

        employeeMapper.selectPage(page,null);

        System.out.println("========获取分页相关的信息=============");
        System.out.println("总条数："+page.getTotal());
        System.out.println("当前页码："+page.getCurrent());
        System.out.println("总页码："+page.getPages());
        System.out.println("每页显示的条数："+page.getSize());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("是否有下一页："+page.hasNext());
    }
}
