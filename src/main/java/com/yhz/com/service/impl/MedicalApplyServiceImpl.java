package com.yhz.com.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yhz.com.dao.MedicalApplyMapper;
import com.yhz.com.dao.MedicalMapper;
import com.yhz.com.model.Medical;
import com.yhz.com.model.MedicalApply;
import com.yhz.com.service.MedicalApplyService;


@Service("medicalApplyService")
@Transactional
public class MedicalApplyServiceImpl implements MedicalApplyService {
    @Resource
    private MedicalApplyMapper medicalApplyMapper;
    @Resource
    private MedicalMapper medicalMapper;

    
	@Override
	public List<MedicalApply> getMedicalApplyByUseTime(String useTime) {
		// TODO Auto-generated method stub
		List<MedicalApply> medicalApplyByUseTime = medicalApplyMapper.getMedicalApplyByUseTime(useTime);
		for (int i = 0; i < medicalApplyByUseTime.size(); i++) {
			MedicalApply medicalApply = medicalApplyByUseTime.get(i);
			String medical = medicalApply.getMedical();
			medicalApply.setMedicalList(medicalMapper.getMedicalByIds(medical));
		}
		
		return medicalApplyByUseTime;
	}


	@Override
	public void saveMedicalApply(String stuClass, String stuName,List<Medical> medicimal) {
		// TODO Auto-generated method stub
		String medicimalIds="";
		for (int i = 0; i < medicimal.size(); i++) {
			 Medical record = medicimal.get(i);
			 medicalMapper.insertSelective(record);
			 medicimalIds += record.getId();
			 if (medicimal.size()!=i-1) {
				 medicimalIds += ",";
			 }
		}
		MedicalApply medicalApply=new MedicalApply();
		medicalApply.setStuName(stuName);
		medicalApply.setClassName(stuClass);
		medicalApply.setMedical(medicimalIds);
		medicalApply.setApplyDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		medicalApplyMapper.insertSelective(medicalApply);
	}
    
    

}