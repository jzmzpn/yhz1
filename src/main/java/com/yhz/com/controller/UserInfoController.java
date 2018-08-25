package com.yhz.com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yhz.com.core.PageInfo;
import com.yhz.com.dao.UserInfoMapper;
import com.yhz.com.model.ClassInfo;
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
    
    @RequestMapping(value = "addGuardianInfo", method= RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addArticle(UserInfo userInfo) {
		Map<String, String> map = new HashMap<String, String>();
		if(userInfo.getStudentId() != null) {
			int insert = userInfoMapper.insert(userInfo);
			if(insert == 0) {
				map.put("code", "500");
				map.put("msg", "添加失败");
			} else {
				map.put("code", "200");
				map.put("msg", "添加成功");
			}
			return map;
		}
		map.put("code", "300");
		map.put("msg", "內容不能为空");
		return map;
	}
    
    @RequestMapping(value = "editGuardianInfo", method= RequestMethod.POST)
	@ResponseBody
	public Map<String, String> editArticle(UserInfo userInfo) {
		Map<String, String> map = new HashMap<String, String>();
		if(userInfo.getStudentId() != null) {
			int insert = userInfoMapper.updateByPrimaryKey(userInfo);
			if(insert == 0) {
				map.put("code", "500");
				map.put("msg", "修改失败");
			} else {
				map.put("code", "200");
				map.put("msg", "修改成功");
			}
			return map;
		}
		map.put("code", "300");
		map.put("msg", "內容不能为空");
		return map;
	}
    
    @RequestMapping(value = "deleteGuardian/{id}", method= RequestMethod.POST)
	@ResponseBody
	public Map<String, String> deleteByPrimaryKey(@PathVariable("id")Integer id) {
		Map<String, String> map = new HashMap<String, String>();
	
			map.put("code", "200");
			map.put("msg", "删除成功");
			return map;
	}
    
    
    @RequestMapping(value="getGuardianInfo/{studentId}", method=RequestMethod.GET)
	@ResponseBody
    public Map<String, Object> query1(@PathVariable("studentId")Integer studentId) {
    	List<UserInfo> info = userInfoMapper.getGuardianInfo(studentId);
    	Map<String, Object> map = new HashMap<String, Object>();
		map.put("userInfoMapper", info);
        return map;
    }
    
}
