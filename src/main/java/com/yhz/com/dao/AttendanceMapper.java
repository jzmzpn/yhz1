package com.yhz.com.dao;

import com.yhz.com.model.Attendance;

public interface AttendanceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Attendance record);

    int insertSelective(Attendance record);

    Attendance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Attendance record);

    int updateByPrimaryKey(Attendance record);
}