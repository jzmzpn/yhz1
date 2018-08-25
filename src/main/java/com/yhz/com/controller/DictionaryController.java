package com.yhz.com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yhz.com.core.PageInfo;
import com.yhz.com.model.Dictionary;
import com.yhz.com.model.UserInfo;
import com.yhz.com.service.DictionaryService;

/**
* Created by CodeGenerator on 2018/08/05.
*/
@Controller
@RequestMapping("/dictionary")
public class DictionaryController {
  
	@Resource
	DictionaryService dictionaryService;

	@RequestMapping(value="/dictionary-list", method=RequestMethod.GET)
	public String getDictionaryList() {
		return "/dictionary/dictionary-list";
	}
	
    @RequestMapping(value="/dictionary-edit/{id}", method=RequestMethod.GET)
    public String editDictionary(@PathVariable("id")Integer id,HttpServletRequest request) {
    	Dictionary info = dictionaryService.selectByPrimaryKey(id);
		request.setAttribute("dictionaryInfo", info);
		return "/dictionary/dictionary-edit";
	}
    
    @RequestMapping(value="/dictionary-add", method=RequestMethod.GET)
   	public String addDictionary() {
   		return "/dictionary/dictionary-add";
   	}
    
    @RequestMapping(value="/dictionary-edit/{id}", method=RequestMethod.POST)
	@ResponseBody
    public String editDictionary(@PathVariable("id")Integer id,String value,String remark) {
    	dictionaryService.updateDictionary(id,value,remark);
    	return "Success";
	}
    
    @RequestMapping(value="/dictionary-add", method=RequestMethod.POST)
	@ResponseBody
   	public String addDictionary(String value,String remark) {
    	dictionaryService.saveDictionary(value,remark);
   		return "Success";
   	}
    
    @RequestMapping(value="/dictionary-delete/{id}", method=RequestMethod.POST)
	@ResponseBody
    public String deleteDictionary(@PathVariable("id")Integer id) {
    	dictionaryService.deleteDictionary(id);
    	return "Success";
	}
    
	
    @RequestMapping(value="/dictionaryjson", method=RequestMethod.GET)
	@ResponseBody
    public PageInfo query(Integer page, Integer rows, String sortOrder, String name) {
    	PageInfo pageInfo = new PageInfo();
    	pageInfo.setPage(page);
    	pageInfo.setRows(rows);
    	pageInfo.setSortOrder(sortOrder);
    	pageInfo.setTotal(dictionaryService.getDictionarySize(name));
    	if(pageInfo.getTotal() != 0) {
    		int start  = 0;
            if(page != 1) {
            	start = rows * (page - 1); 
            }
            List<Dictionary> list = dictionaryService.getDictionary(name, start, rows);
            pageInfo.setList(list);
    	}
        return pageInfo;
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody
    public Map<String, Object> query(@PathVariable("id")Integer id) {
    	Dictionary info = dictionaryService.selectByPrimaryKey(id);
    	Map<String, Object> map = new HashMap<String, Object>();
		map.put("dictionaryInfo", info);
        return map;
    }
    
}
