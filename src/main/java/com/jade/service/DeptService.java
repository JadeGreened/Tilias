package com.jade.service;

import com.jade.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * Query all the department
     * @return
     */
    List<Dept> list();

    /**
     * Delete the target department
     * @param id
     */
    void delete(Integer id) throws Exception;

    /**
     * Add the target Department name
     * @param name
     */
    void add(Dept dept);

    /**
     * Modify the target department
     * @param dept
     */
    void modify(Dept dept);

    /**
     * Query the department by Id
     * @return
     */
    Dept query(Integer id);
}
