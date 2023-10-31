package com.jade.Controller;

import com.jade.pojo.Emp;
import com.jade.pojo.PageBean;
import com.jade.pojo.Result;
import com.jade.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    EmpService empService;

    @GetMapping()
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10")Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("Query all the employees by page {},{},{},{},{},{}", page,pageSize,name,gender,begin,end);
        PageBean pageBean =  empService.page(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("Delete in large quantity{}",ids);
        empService.delete(ids);
        return Result.success();
    }

    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("Saving emp {}",emp);
        empService.save(emp);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("Query by id : {}",id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    @PutMapping()
    public Result modifyById(@RequestBody Emp emp){
        log.info("Modify the target by Id:{}",emp.getId());
        empService.modifyById(emp);
        return Result.success();
    }
}
