package com.jade.service.impl;

import com.jade.mapper.DeptLogMapper;
import com.jade.mapper.DeptMapper;
import com.jade.mapper.EmpMapper;
import com.jade.pojo.Dept;
import com.jade.pojo.DeptLog;
import com.jade.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogMapper deptLogMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) throws Exception {
        try {
            deptMapper.delete(id);
            empMapper.deleteByDeptId(id);
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("Deleted the department with id " + id);
            deptLogMapper.insert(deptLog);

        }

    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }

    @Override
    public void modify(Dept dept) {
        deptMapper.modify(dept);
    }

    @Override
    public Dept query(Integer id) {
        return deptMapper.query(id);
    }
}
