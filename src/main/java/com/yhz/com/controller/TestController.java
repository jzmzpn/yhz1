package com.yhz.com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yhz.com.model.KAdmin;
import com.yhz.com.service.KAdminService;

@Controller
public class TestController {
	
	@Resource(name = "kAdminService")
	private KAdminService kAdminService;
	
	@RequestMapping(value="/user-list", method=RequestMethod.GET)
	public String login(String userName, String password) {
		return "/user/user-list";
	}
	
	
	public Map<String, Object> userjson() {
		List<Map<String, String>> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", i + "");
			map.put("name", "test" + i);
			map.put("price", new Integer(i).toString());
			list.add(map);
			
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("limit", 20);
		map.put("offset", 1000);
		map.put("res", list);
		map.put("total", 100);
		return map;
	}
	

}
