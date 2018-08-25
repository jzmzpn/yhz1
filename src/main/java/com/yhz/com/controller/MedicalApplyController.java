package com.yhz.com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yhz.com.model.Medical;
import com.yhz.com.model.MedicalApply;
import com.yhz.com.service.MedicalApplyService;

/**
* Created by CodeGenerator on 2018/08/05.
*/
@Controller
@RequestMapping("/medicalApply")
public class MedicalApplyController {
	@Resource
    private MedicalApplyService medicalApplyService;
	
	/**
	 * 	喂药列表： 
		接口名称：medicalApplyList
		传入：喂药时间(上午，下午)    page
		涉及表：medical_apply   medical_info
		返回格式：record_list: [{
							  "apply_id": 1,
						      "stu_class": "小一班",
						      "stu_name": "张三",
						      "medicinal": [{"medical_name":"藿香正气水", "use_time":"上午", "detail":"一次50ml"}],
						      "apply_time": "2018-09-01 13:41:00"
						    }]				    		
	 * @param pageNum
	 * @param pageSize
	 */
	 @RequestMapping(value = "/medicalApplyList", method=RequestMethod.GET)
	 @ResponseBody
	 public Map<String, Object>  medicalApplyList(Integer pageNum, Integer pageSize,String useTime) {
			 pageNum=pageNum==null?1:pageNum;
			 pageSize=pageSize==null?10:pageSize;
	    	Page<MedicalApply> page = PageHelper.startPage(pageNum, pageSize, true);
	    	List<MedicalApply> selective = medicalApplyService.getMedicalApplyByUseTime(useTime);
	    	Map<String, Object> map = new HashMap<String, Object>();
			map.put("record_list", selective);
	        return map;
	    }
	 /**
	  * 喂药申请：  
	  
		接口名称：medicalApply
		传入：班级，姓名，[["药品名称","服用时间","服用方法","图片id"],["药品名称","服用时间","服用方法","图片id"]]
		涉及表：medical_apply   medical_info
		返回：success
	  */
	 @RequestMapping(value = "/medicalApply")
	 public String  addMedicalApply(String stuClass, String stuName,List<Medical> medicimal) {
		 medicalApplyService.saveMedicalApply(stuClass,stuName,medicimal);
	        return "seccuss";
	    }
	
	 
	 
    
}
