package com.yhz.com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yhz.com.model.MedicalApply;

public interface MedicalApplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MedicalApply record);

    int insertSelective(MedicalApply record);

    MedicalApply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MedicalApply record);

    int updateByPrimaryKey(MedicalApply record);

	List<MedicalApply> getMedicalApplyByUseTime(@Param("useTime")String useTime);
}