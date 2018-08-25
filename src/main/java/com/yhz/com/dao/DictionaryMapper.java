package com.yhz.com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yhz.com.model.Dictionary;

public interface DictionaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    Dictionary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);

	int getDictionarySize(@Param("name")String name);

	List<Dictionary> getDictionarys(@Param("name") String name, @Param("start") Integer start, @Param("rows") Integer rows);

	/**
	 * 获取500开头的最大code
	 * @return
	 */
	Integer getMaxCode();

}