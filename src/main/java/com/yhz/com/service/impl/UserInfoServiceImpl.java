package com.yhz.com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yhz.com.dao.UserInfoMapper;
import com.yhz.com.model.UserInfo;
import com.yhz.com.service.UserInfoService;


/**
 * Created by CodeGenerator on 2018/08/05.
 */
@Service("userInfoService")
@Transactional
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;
    
    public List<UserInfo> getUsers(String name, Integer start, Integer rows) {
    	return userInfoMapper.getUsers(name, start, rows);
    }

	@Override
	public int getUsersSize(String name) {
		// TODO Auto-generated method stub
		return userInfoMapper.getUsersSize(name);
	}

}