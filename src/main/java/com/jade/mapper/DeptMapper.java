package com.jade.mapper;

import com.jade.pojo.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * Query all the department
     *
     * @return a list of department
     */

    @Select("select * from tlias.dept")
    List<Dept> list();

    @Delete("DELETE from tlias.dept where id = #{id}")
    void delete(Integer id);

    @Insert("insert into tlias.dept(name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void add(Dept dept);

    @Update("update tlias.dept set name = #{name} where id = #{id}")
    void modify(Dept dept);

    @Select("select id,name,create_time,update_time from tlias.dept where id = #{id}")
    Dept query(Integer id);
}
