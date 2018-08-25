package com.yhz.com.dao;

import java.util.Date;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yhz.com.model.Attendance;

public interface AttendanceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Attendance record);

    int insertSelective(Attendance record);

    Attendance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Attendance record);

    int updateByPrimaryKey(Attendance record);
    
    int countByDate(@Param("classId")Integer classId, @Param("date") String date, @Param("status") Boolean status);
    
    Map<String, Object> classDetail(@Param("classId")Integer classId, @Param("date") String date);
}