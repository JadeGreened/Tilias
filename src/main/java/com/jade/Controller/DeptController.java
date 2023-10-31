package com.jade.Controller;

import com.jade.pojo.Dept;
import com.jade.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private com.jade.service.DeptService deptService;

    /**
     * Query all the department information
     * @return null
     */
    @GetMapping
    public Result list(){
        log.info("Query all the department");
        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }

    /**
     * Delete certain department
     * @return null
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) throws Exception {
        log.info("Delete the department by Id {}",id);
        deptService.delete(id);
        return Result.success();


    }

    @PostMapping
    public Result addDept(@RequestBody Dept dept){
        log.info("新增部门 :{}", dept);
        deptService.add(dept);
        return Result.success();
    }
    @PutMapping
    public Result Modify(@RequestBody Dept dept){
        log.info("修改部门 :{}", dept);
        deptService.modify(dept);
        return Result.success();

    }

    @GetMapping("/{id}")
    public Result query(@PathVariable Integer id){
        log.info("Query the department by Id");
        Dept dept = deptService.query(id);
        return Result.success(dept);
    }


}
