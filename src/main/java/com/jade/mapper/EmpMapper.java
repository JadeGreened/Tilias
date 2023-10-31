package com.jade.mapper;

import com.jade.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;


@Mapper
public interface EmpMapper {
    //    @Select("select COUNT(*) from tlias.emp")
//    public Long count();
//
//
//    @Select("select * from tlias.emp limit #{start},#{pageSize}")
//    public List<Emp> pageQuery(Integer start, Integer pageSize);
    //@Select("select * from tlias.emp")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    @Insert("insert into tlias.emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void save(Emp emp);

    Emp getById(Integer id);

    void modifyById(Emp emp);

    @Select("select * from tlias.emp where username=#{username} and password=#{password}")
    Emp login(Emp emp);

    @Delete("delete from tlias.emp where dept_id=#{id}")
    void deleteByDeptId(Integer id);
}
