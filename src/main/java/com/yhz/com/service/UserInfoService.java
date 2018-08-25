package com.yhz.com.service;
import java.util.List;


import com.yhz.com.model.UserInfo;


/**
 * Created by CodeGenerator on 2018/08/05.
 */
public interface UserInfoService {
	
	int getUsersSize( String name);
	
	List<UserInfo> getUsers(String name, Integer start, Integer rows);

	int insert(UserInfo userIofo);
	
	int updateByPrimaryKey(UserInfo userIofo);
	
	int deleteByPrimaryKey(Integer id);
	
	List<UserInfo> getGuardianInfo(Integer studentId);
	
}