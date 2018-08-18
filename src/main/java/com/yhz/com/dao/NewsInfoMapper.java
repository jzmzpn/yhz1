package com.yhz.com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yhz.com.model.NewsInfo;

public interface NewsInfoMapper {
	
	
	int getNewsSize(@Param("newsType") Integer newsType);
	
	List<NewsInfo> getNews(@Param("newsType") Integer newsType, @Param("start") Integer start, @Param("rows") Integer rows);
	
	int insert(NewsInfo newsInfo);
}