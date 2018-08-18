package com.yhz.com.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yhz.com.dao.KAdminMapper;
import com.yhz.com.model.KAdmin;
import com.yhz.com.service.KAdminService;


/**
 * Created by CodeGenerator on 2018/08/02.
 */
@Service("kAdminService")
@Transactional
public class KAdminServiceImpl implements KAdminService {
    @Resource
    private KAdminMapper kAdminMapper;

	@Override
	public KAdmin getUserByName(String userName) {
		// TODO Auto-generated method stub
		return kAdminMapper.getUserByName(userName);
	}
    
    

}