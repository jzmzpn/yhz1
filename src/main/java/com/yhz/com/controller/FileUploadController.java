package com.yhz.com.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletInputStream;
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

import com.alibaba.druid.util.StringUtils;
import com.yhz.com.dao.ImageInfoMapper;
import com.yhz.com.dao.StudentMapper;
import com.yhz.com.model.ImageInfo;
import com.yhz.com.model.Student;
import com.yhz.com.util.ExcelHead;
import com.yhz.com.util.ExcelUtils;


@Controller
public class FileUploadController {
	
	@Autowired
	private ImageInfoMapper imageInfoMapper;
	
	@Autowired
	private StudentMapper studentMapper;

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
	
	@RequestMapping(value="xls/upload/stu", method=RequestMethod.POST)
	@ResponseBody
	public Integer uploadXls(HttpServletRequest request) {
		List<ExcelHead> heads = new ArrayList<ExcelHead>();
		ExcelHead head = new ExcelHead();
		head.setExcelName("学号");
		head.setEntityName("sid");
		
		ExcelHead head1 = new ExcelHead();
		head1.setExcelName("姓名");
		head1.setEntityName("name");
		
		ExcelHead head2 = new ExcelHead();
		head2.setExcelName("小名");
		head2.setEntityName("littleName");
		
		
		ExcelHead head3 = new ExcelHead();
		head3.setExcelName("班级");
		head3.setEntityName("classId");
		
		ExcelHead head4 = new ExcelHead();
		head4.setExcelName("出生年月");
		head4.setEntityName("birthday");
		
		ExcelHead head5 = new ExcelHead();
		head5.setExcelName("家庭住址");
		head5.setEntityName("address");
		
		ExcelHead head6 = new ExcelHead();
		head6.setExcelName("入学时间");
		head6.setEntityName("enterDate");
//		sid	name	little_name	sex	class_id(导入时需关联class_info表获取班级id插入此列)	birthday	address	enter_date	out_date	guardian_num	remark
//		学号	姓名	小名	性别	班级	出生年月	家庭住址	入学时间	毕业时间	监护人数	备注
		ExcelHead head7 = new ExcelHead();
		head7.setExcelName("毕业时间");
		head7.setEntityName("outDate");
		
		ExcelHead head9 = new ExcelHead();
		head9.setEntityName("remark");
		head9.setExcelName("备注");
		
		ExcelHead head8 = new ExcelHead();
		head8.setExcelName("监护人数");
		head8.setEntityName("guardianNum");
		
		ExcelHead head10 = new ExcelHead();
		head10.setExcelName("性別");
		head10.setEntityName("sex");
		
		heads.add(head10);
		heads.add(head9);
		heads.add(head8);
		heads.add(head7);
		heads.add(head6);
		heads.add(head5);
		heads.add(head4);
		heads.add(head3);
		heads.add(head2);
		heads.add(head1);
		heads.add(head);
		
		
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
	               request.getSession().getServletContext());
	       //检查form中是否有enctype="multipart/form-data"
	       if(multipartResolver.isMultipart(request))
	       {
	           //将request变成多部分request
	    	   MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
	 	       InputStream in = null;
	 	       
	           
	          //获取multiRequest 中所有的文件名
	           Iterator<String> iter = multiRequest.getFileNames();
	           
	           try {
	        	   
	        	   while(iter.hasNext())
	               {
	                   //一次遍历所有文件
	                   MultipartFile file=multiRequest.getFile(iter.next().toString());
	                   if(file!=null)
	                   {
	                       String path = file.getOriginalFilename();
	                       
	                       in = file.getInputStream(); 
	                       //上传
	                       List<Student> list = ExcelUtils.readExcelToEntity(Student.class, in, path, heads);
//	     	 	           list.forEach(stu -> {
//	     	 	        	  if(!StringUtils.isEmpty(stu.getName())) {
//	     	 	        		  if(StringUtils.isEmpty(stu.getSex())) {
//	     	 	        			  stu.setSex("S");
//	     	 	        		  }
//	     	 	        		studentMapper.insertSelective(stu);
//	     	 	        	  }
//	     	 	           });
	                       return list.size();
	                       
	                   }
	               }
	        	   
	 	          
	           } catch(Exception e) {
	        	   e.printStackTrace();
	           } finally {
	        	   if(in != null) {
	        		   try {
						in.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	   }
	           }
	          
	       }
	       return 0; 
		
       
   }
	
	
}
