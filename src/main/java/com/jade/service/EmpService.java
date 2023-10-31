package com.jade.service;


import com.jade.pojo.Emp;
import com.jade.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin,  LocalDate end);

    void delete(List<Integer> ids);

    void save(Emp emp);

    Emp getById(Integer id);

    void modifyById(Emp emp);

    Emp login(Emp emp);
}
