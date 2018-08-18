package com.yhz.com.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yhz.com.model.KAdmin;

@Repository
public interface KAdminMapper {
	
	KAdmin getUserByName(@Param("userName") String userName);
	
}