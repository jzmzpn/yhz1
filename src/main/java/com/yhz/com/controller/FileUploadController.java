package com.yhz.com.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.yhz.com.dao.ImageInfoMapper;
import com.yhz.com.model.ImageInfo;


@Controller
public class FileUploadController {
	
	@Autowired
	private ImageInfoMapper imageInfoMapper;

	@RequestMapping(value="image/upload", method=RequestMethod.POST)
	@ResponseBody
	public Integer upload(HttpServletRequest request) throws IllegalStateException, IOException
    {
        long  startTime=System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
       CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
               request.getSession().getServletContext());
       //检查form中是否有enctype="multipart/form-data"
       if(multipartResolver.isMultipart(request))
       {
           //将request变成多部分request
           MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
          //获取multiRequest 中所有的文件名
           Iterator iter=multiRequest.getFileNames();
            
          try {
        	  while(iter.hasNext())
              {
                  //一次遍历所有文件
                  MultipartFile file=multiRequest.getFile(iter.next().toString());
                  if(file!=null)
                  {
                      String path="images/"+file.getOriginalFilename();
                      //上传
                      file.transferTo(new File("/root/apache-tomcat-7.0.77/webapps/"+path));
                      ImageInfo imageInfo = new ImageInfo();
                      imageInfo.setImagePath(path);
                      imageInfoMapper.insertSelective(imageInfo);
                      return imageInfo.getId();
                      
                  }
              }
          } catch(Exception e) {
        	  e.printStackTrace();
        	  return 0;
          }	
          
       }
       long  endTime=System.currentTimeMillis();
       System.out.println("方法三的运行时间："+String.valueOf(endTime-startTime)+"ms");
       return 0; 
   }
	
	@RequestMapping(value = "image/{imageId}", method=RequestMethod.GET)
	@ResponseBody
	public String getImageById(@PathVariable("imageId")Integer imageId) {
		try {
			ImageInfo info = imageInfoMapper.selectByPrimaryKey(imageId);
			if(info != null) {
				return info.getImagePath();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	
}
