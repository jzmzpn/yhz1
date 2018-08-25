package com.yhz.com.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yhz.com.dao.DictionaryMapper;
import com.yhz.com.dao.FoodMapper;

@Controller
@RequestMapping("finance")
public class FinanceController {
	
	
	@Resource
	private FoodMapper foodMapper;
	
	@Resource
	private DictionaryMapper dictionaryMapper;
	
	@RequestMapping(value = "foodTypeList", method = RequestMethod.GET)
	@ResponseBody
	public Object foodTypeList() {
		return foodMapper.select(null);
	}
	
	@RequestMapping(value = "foodDetailList", method = RequestMethod.GET)
	public Object foodDetailList(String type) {
		return foodMapper.select(type);
	}
	
	@RequestMapping(value = "getPayItem", method = RequestMethod.GET)
	public Object getPayItem() {
		return dictionaryMapper.select();
	}
	
	@RequestMapping(value = "purchaseApply", method = RequestMethod.GET)
	public Object purchaseApply() {
		return null;
	}
	
}
