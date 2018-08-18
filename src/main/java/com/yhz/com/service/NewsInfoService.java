package com.yhz.com.service;

import java.util.List;

import com.yhz.com.model.NewsInfo;
import com.yhz.com.model.UserInfo;

public interface NewsInfoService {
	int getNewsSize(Integer newsType);
	
	List<NewsInfo> getNews(Integer newsType, Integer start, Integer rows);
	
	int insert(NewsInfo newsInfo);
}
