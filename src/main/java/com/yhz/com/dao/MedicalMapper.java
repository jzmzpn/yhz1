package com.yhz.com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yhz.com.model.Medical;

public interface MedicalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Medical record);

    int insertSelective(Medical record);

    Medical selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Medical record);

    int updateByPrimaryKey(Medical record);

	List<Medical> getMedicalByIds(@Param("ids")String medical);
}