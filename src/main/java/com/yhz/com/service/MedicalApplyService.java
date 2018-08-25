package com.yhz.com.service;

import java.util.List;

import com.yhz.com.model.Medical;
import com.yhz.com.model.MedicalApply;



public interface MedicalApplyService {

	List<MedicalApply> getMedicalApplyByUseTime(String useTime);

	void saveMedicalApply(String stuClass, String stuName,
			List<Medical> medicimal);
	
  
}
