package com.yhz.com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yhz.com.core.PageInfo;
import com.yhz.com.dao.UserInfoMapper;
import com.yhz.com.model.MessageInfo;
import com.yhz.com.model.UserInfo;
import com.yhz.com.service.UserInfoService;

/**
* Created by CodeGenerator on 2018/08/05.
*/
@Controller
@RequestMapping("userInfo")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;
    
    @Resource
    private UserInfoMapper userInfoMapper;
    
    @RequestMapping(value="/userjson", method=RequestMethod.GET)
	@ResponseBody
    public PageInfo query(Integer page, Integer rows, String sortOrder, String name) {
    	PageInfo pageInfo = new PageInfo();
    	pageInfo.setPage(page);
    	pageInfo.setRows(rows);
    	pageInfo.setSortOrder(sortOrder);
    	pageInfo.setTotal(userInfoService.getUsersSize(name));
    	if(pageInfo.getTotal() != 0) {
    		int start  = 0;
            if(page != 1) {
            	start = rows * (page - 1); 
            }
            List<UserInfo> list = userInfoService.getUsers(name, start, rows);
            pageInfo.setList(list);
    	}
        return pageInfo;
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody
    public Map<String, Object> query(@PathVariable("id")Integer id) {
    	UserInfo info = userInfoMapper.selectByPrimaryKey(id);
    	Map<String, Object> map = new HashMap<String, Object>();
		map.put("userInfo", info);
        return map;
    }
}
