package com.yhz.com.dao;

import org.apache.ibatis.annotations.Param;
import java.util.List;

import java.util.Map;

import com.yhz.com.model.ClassInfo;

public interface ClassInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClassInfo record);

    int insertSelective(ClassInfo record);

    ClassInfo selectByPrimaryKey(Integer id);
    
    ClassInfo selectByTeacherId(Integer id);

    int updateByPrimaryKeySelective(ClassInfo record);

    int updateByPrimaryKey(ClassInfo record);
    
    List<Map<String, Object>> selectClassByDate(@Param("kid") Integer kid, @Param("date")String date);
    
    List<ClassInfo> selectByClassOrTeacher(@Param("classId") Integer classId, @Param("teacherId")Integer teacherId);
}