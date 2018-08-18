package com.yhz.com.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yhz.com.service.KAdminService;

/**
* Created by CodeGenerator on 2018/08/02.
*/
@RestController
@RequestMapping("/k/admin")
public class KAdminController {
    @Resource(name="kAdminService")
    private KAdminService kAdminService;

    
}
