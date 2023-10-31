package com.jade.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jade.mapper.EmpMapper;
import com.jade.pojo.Emp;
import com.jade.pojo.PageBean;
import com.jade.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;


    //    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        //1.获取总记录数
//        Long count = empMapper.count();
//
//        //2.获取分页查询结果列表
//        Integer start = (page-1)*pageSize;
//        List<Emp> list = empMapper.pageQuery(start,pageSize);
//
//
//        //3.封装PageBean对象
//
//        return new PageBean(count,list);
//    }
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        PageHelper.startPage(page,pageSize);
        List<Emp> list = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) list;
        //3.封装PageBean对象
        return new PageBean(p.getTotal(),p.getResult());
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.save(emp);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    @Override
    public void modifyById(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.modifyById(emp);
    }

    @Override
    public Emp login(Emp emp) {
        Emp emp1 = empMapper.login(emp);
        if(emp1==null){
            throw new RuntimeException("用户名或密码错误");
        }
        return emp1;
    }
}
