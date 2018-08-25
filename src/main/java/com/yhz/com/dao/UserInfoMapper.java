package com.yhz.com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yhz.com.model.UserInfo;

public interface UserInfoMapper {
	
	int getUsersSize(@Param("name") String name);
	
	List<UserInfo> getUsers(@Param("name") String name, @Param("start") Integer start, @Param("rows") Integer rows);
	
	UserInfo selectByPrimaryKey(Integer id);
	
	int insert(UserInfo record);
	
	int updateByPrimaryKey(UserInfo record);
	
	int deleteByPrimaryKey(Integer id);
	
    List<UserInfo> getGuardianInfo(@Param("studentId") Integer studentId);
    
}