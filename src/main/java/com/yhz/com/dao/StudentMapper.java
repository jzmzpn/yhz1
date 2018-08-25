package com.yhz.com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yhz.com.model.NewsInfo;
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
    
    int getStusSize(@Param("newsType") Integer newsType);
	
	List<Student> getStus(@Param("newsType") Integer newsType, @Param("start") Integer start, @Param("rows") Integer rows);
}