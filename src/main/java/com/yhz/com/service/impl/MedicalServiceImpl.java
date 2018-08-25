package com.yhz.com.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yhz.com.dao.MedicalApplyMapper;
import com.yhz.com.dao.MedicalMapper;
import com.yhz.com.service.MedicalService;


@Service("medicalService")
@Transactional
public class MedicalServiceImpl implements MedicalService {
    @Resource
    private MedicalApplyMapper medicalApplyMapper;
    @Resource
    private MedicalMapper medicalMapper;

    


}