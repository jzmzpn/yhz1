package com.yhz.com.dao;

import com.yhz.com.model.Kindergarten;

public interface KindergartenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Kindergarten record);

    int insertSelective(Kindergarten record);

    Kindergarten selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Kindergarten record);

    int updateByPrimaryKeyWithBLOBs(Kindergarten record);

    int updateByPrimaryKey(Kindergarten record);
}