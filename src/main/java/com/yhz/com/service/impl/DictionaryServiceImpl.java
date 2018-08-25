package com.yhz.com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yhz.com.dao.DictionaryMapper;
import com.yhz.com.model.Dictionary;
import com.yhz.com.model.UserInfo;
import com.yhz.com.service.DictionaryService;


@Service("dictionaryService")
@Transactional
public class DictionaryServiceImpl implements DictionaryService {
    @Resource
    private DictionaryMapper dictionaryMapper;
    
    public List<Dictionary> getDictionary(String name, Integer start, Integer rows) {
    	return dictionaryMapper.getDictionarys(name, start, rows);
    }

	@Override
	public int getDictionarySize(String name) {
		// TODO Auto-generated method stub
		return dictionaryMapper.getDictionarySize(name);
	}

	@Override
	public Dictionary selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dictionaryMapper.selectByPrimaryKey(id);
	}

	@Override
	public void saveDictionary(String value,String remark) {
		// TODO Auto-generated method stub
		Dictionary dictionary=new Dictionary();
		dictionary.setValue(value);
		dictionary.setRemark(remark);
		dictionary.setCode(dictionaryMapper.getMaxCode());//获取5开头的最大值code
		dictionaryMapper.insertSelective(dictionary);
	}

	@Override
	public void updateDictionary(Integer id, String value,String remark) {
		// TODO Auto-generated method stub
		Dictionary dictionary=dictionaryMapper.selectByPrimaryKey(id);
		dictionary.setValue(value);
		dictionary.setRemark(remark);
		dictionaryMapper.updateByPrimaryKey(dictionary);
		
	}

	@Override
	public void deleteDictionary(Integer id) {
		// TODO Auto-generated method stub
		dictionaryMapper.deleteByPrimaryKey(id);
	}
    

}