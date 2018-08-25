package com.yhz.com.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yhz.com.dao.ClassInfoMapper;
import com.yhz.com.dao.StudentMapper;
import com.yhz.com.model.Attendance;
import com.yhz.com.model.ClassInfo;
import com.yhz.com.model.Student;
import com.yhz.com.service.AttendanceService;
import com.yhz.com.service.ClassInfoService;

@Controller
@RequestMapping("class")
public class ClassController {
	
	@Resource
	private ClassInfoMapper classInfoMapper;
	
	@Resource
	private StudentMapper studentMapper;
	
	@Resource
	private AttendanceService attendanceService;
	
	@Resource
	private ClassInfoService classInfoService;

	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> query(@PathVariable(value="id")@Required Integer id) {
		ClassInfo info = classInfoMapper.selectByPrimaryKey(id);
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(info == null) {
			return map;
		}
		if(info.getStudentNum() == null || info.getStudentNum() == 0) {
			info.setMaleNum(0);
			info.setFemaleNum(0);
			return map;
		}
		int mNum = studentMapper.getMaleNum(id);
		
		int fNum = info.getStudentNum() - mNum;
		info.setMaleNum(mNum);
		info.setFemaleNum(fNum);
		map.put("classInfo", info);
		return map;
	}
	
	@RequestMapping(value="/static/{classId}", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> staticWithClass(@PathVariable(value="classId")@Required Integer classId, @RequestParam(value = "date", required = false)String dateStr) {
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		if(dateStr == null) {
			dateStr = df.format(new Date());
		} 
		return attendanceService.countAttendance(classId, dateStr);
	}
	
	@RequestMapping(value="/static/{classId}/details", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> staticWithClassDetails(@PathVariable(value="classId")@Required Integer classId, @RequestParam(value = "date", required=false) String dateStr) {
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		if(dateStr == null) {
			dateStr = df.format(new Date());
		} 
		return attendanceService.classDetail(classId, dateStr);
	}
	
	@RequestMapping(value="/classList", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> classList(Integer kindergartenId, String date) {
		List<Map<String,Object>> list = classInfoMapper.selectClassByDate(kindergartenId, date);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("class_list", list);
		return map;
	}
	
	@RequestMapping(value="/classStuInfo", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> classStuInfo(Integer classId, Integer teacherId) {
		List<ClassInfo> infos = classInfoMapper.selectByClassOrTeacher(classId, teacherId);
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(infos == null || infos.size() == 0) {
			return map;
		}
		ClassInfo info = infos.get(0);
		if(info.getStudentNum() == null || info.getStudentNum() == 0) {
			info.setMaleNum(0);
			info.setFemaleNum(0);
			return map;
		}
		classId = info.getId();
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("class_name", info.getClassName());
		data.put("total", info.getStudentNum());
		
		int mNum = studentMapper.getMaleNum(classId);
		
		int fNum = info.getStudentNum() - mNum;
		data.put("boy", mNum);
		data.put("girl", fNum);
		map.put("classInfo", data);
		return map;
	}
	
	@RequestMapping(value="/studentManageList", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> studentManageList(Integer classId, Integer teacherId) {
		if(classId == null && teacherId != null) {
			ClassInfo info = classInfoMapper.selectByTeacherId(teacherId);
			if(info != null)
				classId = info.getId();
			else 
				return null;
		}
		List<Map<String, Object>> list = studentMapper.selectByClassOrTeacher(classId);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("listData", list);
		return data;
	}
	
	@RequestMapping(value="/changeClass", method=RequestMethod.GET)
	@ResponseBody
	public String changeClass(Integer studentId, Integer classId, Integer targetClassId) {
		return classInfoService.changeClass(studentId, classId, targetClassId);
	}
	
	@RequestMapping(value="/deleteStudent", method=RequestMethod.POST)
	@ResponseBody
	public String deleteStudent(Integer studentId, Integer classId) {
		return classInfoService.deleteStudent(studentId, classId);
	}
	
	@RequestMapping(value="/studentCallAtt", method=RequestMethod.POST)
	@ResponseBody
	public String studentCallAtt( Attendance attendance) {
		if(attendanceService.addAttend(attendance) == 1) {
			return "success";
		}
		return "fail";
	}
	
}
