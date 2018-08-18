package com.yhz.com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yhz.com.core.PageInfo;
import com.yhz.com.model.NewsInfo;
import com.yhz.com.service.NewsInfoService;

@Controller
@RequestMapping("newInfos")
public class NewsInfoController {
	
	@Resource
    private NewsInfoService newsInfoService;
	
	@RequestMapping("article-list")
	public String articles() {
		return "/article/article-list";
	}
	
	@RequestMapping("toAddArticle")
	public String toAddArticle() {
		return "/article/article-add";
	}

	@RequestMapping(value = "query", method= RequestMethod.POST)
	@ResponseBody
	public PageInfo query(PageInfo pageInfo) {
		System.out.println(pageInfo);
		Integer newsType = pageInfo.getSearch() == null || "".equals(pageInfo.getSearch()) ? 
				null : Integer.parseInt(pageInfo.getSearch());
		int total = newsInfoService.getNewsSize(newsType);
    	pageInfo.setTotal(total);
    	if(total != 0) {
    		int start  = 0;
    		int page = pageInfo.getPage() == null ? 1 : pageInfo.getPage();
    		int rows = pageInfo.getRows() == null ? 10 : pageInfo.getRows();
            if(page != 1) {
            	start = rows * (page - 1); 
            }
            List<NewsInfo> list = newsInfoService.getNews(newsType, start, rows);
            pageInfo.setList(list);
    	}
        return pageInfo;
	}
	
	@RequestMapping(value = "add", method= RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addArticle(NewsInfo newsInfo) {
		Map<String, String> map = new HashMap<String, String>();
		if(newsInfo.getNews() != null) {
			int insert = newsInfoService.insert(newsInfo);
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
	
}
