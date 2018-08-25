package com.yhz.com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yhz.com.model.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
    int getMaleNum(@Param("classId")Integer classId);
    
    List<Student> selectByClassId(@Param("classId") Integer classId);
    
    List<Student> studentDetail(@Param("Id") Integer id);
}