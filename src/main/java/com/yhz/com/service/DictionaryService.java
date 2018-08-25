package com.yhz.com.service;

import java.util.List;

import com.yhz.com.model.Dictionary;


public interface DictionaryService {
	
    public List<Dictionary> getDictionary(String name, Integer start, Integer rows) ;

	public int getDictionarySize(String name);

	public Dictionary selectByPrimaryKey(Integer id);

	public void saveDictionary(String value,String remark);

	public void updateDictionary(Integer id, String value,String remark);

	public void deleteDictionary(Integer id);
}
