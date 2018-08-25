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

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yhz.com.core.PageInfo;
import com.yhz.com.dao.MessageInfoMapper;
import com.yhz.com.model.MessageInfo;

/**
* Created by CodeGenerator on 2018/08/05.
*/
@Controller
@RequestMapping("message")
public class MessageController {
    @Resource
    private MessageInfoMapper messageInfoMapper;
    
    @RequestMapping(value="/json", method=RequestMethod.GET)
	@ResponseBody
    public PageInfo query(Integer page, Integer rows, String sortOrder, Integer receiveUid) {
    	PageInfo pageInfo = new PageInfo();
    	pageInfo.setPage(page);
    	pageInfo.setRows(rows);
    	pageInfo.setSortOrder(sortOrder);
    	pageInfo.setTotal(messageInfoMapper.getSize(receiveUid));
    	if(pageInfo.getTotal() != 0) {
    		int start  = 0;
            if(page != 1) {
            	start = rows * (page - 1); 
            }
            List<MessageInfo> list = messageInfoMapper.getMessages(receiveUid, start, rows);
            pageInfo.setList(list);
    	}
        return pageInfo;
    }
    
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody
    public Map<String, Object> query(@PathVariable("id")Integer id) {
    	MessageInfo info = messageInfoMapper.selectByPrimaryKey(id);
    	Map<String, Object> map = new HashMap<String, Object>();
		map.put("messageInfo", info);
        return map;
    }
    
    @RequestMapping(value = "testmessage", method=RequestMethod.GET)
    public void getMessageListWithPage(Integer pageNum, Integer pageSize) {
    	Page<MessageInfo> page = PageHelper.startPage(pageNum, pageSize, true);
    	List<MessageInfo> selective = messageInfoMapper.getMessageBySelective(null);
    	System.out.println(page.getTotal());
    }
}
