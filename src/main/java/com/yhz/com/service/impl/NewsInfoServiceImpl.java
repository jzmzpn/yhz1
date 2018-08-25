package com.yhz.com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yhz.com.dao.NewsInfoMapper;
import com.yhz.com.dao.UserInfoMapper;
import com.yhz.com.model.NewsInfo;
import com.yhz.com.model.UserInfo;
import com.yhz.com.service.NewsInfoService;
import com.yhz.com.service.UserInfoService;


/**
 * Created by CodeGenerator on 2018/08/05.
 */
@Service("newsInfoService")
@Transactional
public class NewsInfoServiceImpl implements NewsInfoService {
    @Resource
    private NewsInfoMapper newsInfoMapper;
    
    public List<NewsInfo> getNews(Integer newsType, Integer start, Integer rows) {
    	return newsInfoMapper.getNews(newsType, start, rows);
    }

	public int getNewsSize(Integer newsType) {
		// TODO Auto-generated method stub
		return newsInfoMapper.getNewsSize(newsType);
	}

	public int insert(NewsInfo newsInfo) {
		return newsInfoMapper.insert(newsInfo);
	}
}