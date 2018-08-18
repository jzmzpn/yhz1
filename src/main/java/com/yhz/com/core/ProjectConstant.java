package com.yhz.com.core;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目常量
 */
public final class ProjectConstant {
	public static final String SESSION_KEY = "kAdmin";
	
    public static final String BASE_PACKAGE = "com.yhz.com";//项目基础包名称，根据自己公司的项目修改

    public static final Map<String, String> TABLE_DESCS = new HashMap<String, String>();

    static {
        TABLE_DESCS.put("k_admin" ,"后台信息");
    }

    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".model";//Model所在包
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".dao";//Mapper所在包
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";//Service所在包
    public static final String SWAGGER_PACKAGE = BASE_PACKAGE + ".swagger";//Swagger所在包
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";//ServiceImpl所在包
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".controller";//Controller所在包

    public static final String MAPPER_INTERFACE_REFERENCE = "com.yhz.com.core.Mapper";//Mapper插件基础接口的完全限定名

}