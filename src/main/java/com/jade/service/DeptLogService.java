package com.jade.service;

import com.jade.pojo.DeptLog;
import com.jade.pojo.DeptLog;
import org.springframework.transaction.annotation.Transactional;

public interface DeptLogService {

    @Transactional
//(propagation = Propagation.REQUIRES_NEW)
    void insert(DeptLog deptLog);
}
