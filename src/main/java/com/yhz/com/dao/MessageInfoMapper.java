package com.yhz.com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yhz.com.model.MessageInfo;

public interface MessageInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MessageInfo record);

    int insertSelective(MessageInfo record);

    MessageInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MessageInfo record);

    int updateByPrimaryKey(MessageInfo record);
    
    int getSize(@Param("receiveUid") Integer receiveUid);
    
    List<MessageInfo> getMessages(@Param("receiveUid") Integer receiveUid, @Param("start") Integer start, @Param("rows") Integer rows);
}