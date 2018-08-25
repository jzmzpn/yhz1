package com.yhz.com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.yhz.com.model.Student;


public class ExcelUtils {
    private static final String FULL_DATA_FORMAT = "yyyy/MM/dd  HH:mm:ss";
    private static final String SHORT_DATA_FORMAT = "yyyy/MM/dd";
    private static HashMap<String, Integer> nameTOIdMap = new HashMap<String, Integer>();
    

	public static HashMap<String, Integer> getNameTOIdMap() {
		return nameTOIdMap;
	}

	public static void setNameTOIdMap(HashMap<String, Integer> nameTOIdMap) {
		ExcelUtils.nameTOIdMap = nameTOIdMap;
	}

	/**
     * Excel表头对应Entity属性 解析封装javabean
     *
     * @param classzz    类
     * @param in         excel流
     * @param fileName   文件名
     * @param excelHeads excel表头与entity属性对应关系
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> List<T> readExcelToEntity(Class<T> classzz, InputStream in, String fileName, List<ExcelHead> excelHeads) throws Exception {
        checkFile(fileName);    //是否EXCEL文件
        Workbook workbook = getWorkBoot(in, fileName); //兼容新老版本
        List<T> excelForBeans = readExcel(classzz, workbook, excelHeads);  //解析Excel
        return excelForBeans;
    }
 
    /**
     * 解析Excel转换为Entity
     *
     * @param classzz  类
     * @param in       excel流
     * @param fileName 文件名
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> List<T> readExcelToEntity(Class<T> classzz, InputStream in, String fileName) throws Exception {
        return readExcelToEntity(classzz, in, fileName,null);
    }
 
    /**
     * 校验是否是Excel文件
     *
     * @param fileName
     * @throws Exception
     */
    public static void checkFile(String fileName) throws Exception {
        if (!StringUtils.isEmpty(fileName) && !(fileName.endsWith(".xlsx") || fileName.endsWith(".xls"))) {
            throw new Exception("不是Excel文件！");
        }
    }
 
    /**
     * 兼容新老版Excel
     *
     * @param in
     * @param fileName
     * @return
     * @throws IOException
     */
    private static Workbook getWorkBoot(InputStream in, String fileName) throws IOException {
        if (fileName.endsWith(".xlsx")) {
            return new XSSFWorkbook(in);
        } else {
            return new HSSFWorkbook(in);
        }
    }
 
    /**
     * 解析Excel
     *
     * @param classzz    类
     * @param workbook   工作簿对象
     * @param excelHeads excel与entity对应关系实体
     * @param <T>
     * @return
     * @throws Exception
     */
    private static <T> List<T> readExcel(Class<T> classzz, Workbook workbook, List<ExcelHead> excelHeads) throws Exception {
        List<T> beans = new ArrayList<T>();
        int sheetNum = workbook.getNumberOfSheets();
        for (int sheetIndex = 0; sheetIndex < sheetNum; sheetIndex++) {
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            String sheetName=sheet.getSheetName();
            int firstRowNum = sheet.getFirstRowNum();
            int lastRowNum = sheet.getLastRowNum();
            Row head = sheet.getRow(firstRowNum);
            if (head == null)
                continue;
            short firstCellNum = head.getFirstCellNum();
            short lastCellNum = head.getLastCellNum();
            Field[] fields = classzz.getDeclaredFields();
            for (int rowIndex = firstRowNum + 1; rowIndex <= lastRowNum; rowIndex++) {
                Row dataRow = sheet.getRow(rowIndex);
                if (dataRow == null)
                    continue;
                T instance = classzz.newInstance();
                if(CollectionUtils.isEmpty(excelHeads)){  //非头部映射方式，默认不校验是否为空，提高效率
                    firstCellNum=dataRow.getFirstCellNum();
                    lastCellNum=dataRow.getLastCellNum();
                }
                for (int cellIndex = firstCellNum; cellIndex < lastCellNum; cellIndex++) {
                    Cell headCell = head.getCell(cellIndex);
                    if (headCell == null)
                        continue;
                    Cell cell = dataRow.getCell(cellIndex);
                    headCell.setCellType(Cell.CELL_TYPE_STRING);
                    String headName = headCell.getStringCellValue().trim();
                    if (StringUtils.isEmpty(headName)) {
                        continue;
                    }
                    ExcelHead eHead = null;
                    if (!CollectionUtils.isEmpty(excelHeads)) {
                        for (ExcelHead excelHead : excelHeads) {
                            if (headName.equals(excelHead.getExcelName())) {
                                eHead = excelHead;
                                headName = eHead.getEntityName();
                                break;
                            }
                        }
                    }
                    for (Field field : fields) {
                        if (headName.equalsIgnoreCase(field.getName())) {
                            String methodName = MethodUtils.setMethodName(field.getName());
                            Method method = classzz.getMethod(methodName, field.getType());
                            if (isDateFied(field)) {
                                Date date=null;
                                if(cell!=null){
                                    date=cell.getDateCellValue();
                                }
                                if (date == null) {
                                    volidateValueRequired(eHead,sheetName,rowIndex);
                                    break;
                                }
                                method.invoke(instance, cell.getDateCellValue());
                            } else {
                                String value = null;
                                if(cell!=null){
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                    value=cell.getStringCellValue();
                                }
                                if (StringUtils.isEmpty(value)) {
                                    volidateValueRequired(eHead,sheetName,rowIndex);
                                    break;
                                }
                                //name转ID
                                if("classId".equalsIgnoreCase(field.getName()) || "teacherId".equalsIgnoreCase(field.getName()) || "position".equalsIgnoreCase(field.getName())){
                                	if(nameTOIdMap.get(value.trim())==null){
                                		//教师信息不存在或者职位信息不存在
                                		volidateValueRequired(eHead,sheetName,rowIndex);
                                        break;
                                	}
                                	method.invoke(instance, convertType(field.getType(), nameTOIdMap.get(value.trim())+""));
                                }else{
                                	method.invoke(instance, convertType(field.getType(), value.trim()));
                                }
                                	
                                
                            }
                            break;
                        }
                    }
                }
                beans.add(instance);
            }
        }
        return beans;
    }
    /**
     * 是否日期字段
     *
     * @param field
     * @return
     */
    private static boolean isDateFied(Field field) {
        return (Date.class == field.getType());
    }
    /**
     * 空值校验
     *
     * @param excelHead
     * @throws Exception
     */
    private static void volidateValueRequired(ExcelHead excelHead,String sheetName,int rowIndex) throws Exception {
        if (excelHead != null && excelHead.isRequired()) {
            throw new Exception("《"+sheetName+"》第"+(rowIndex+1)+"行:\""+excelHead.getExcelName() + "\"不能为空！");
        }
    }
    /**
     * 类型转换
     *
     * @param classzz
     * @param value
     * @return
     */
    private static Object convertType(Class classzz, String value) {
        if (Integer.class == classzz || int.class == classzz) {
            return Integer.valueOf(value);
        }
        if (Short.class == classzz || short.class == classzz) {
            return Short.valueOf(value);
        }
        if (Byte.class == classzz || byte.class == classzz) {
            return Byte.valueOf(value);
        }
        if (Character.class == classzz || char.class == classzz) {
            return value.charAt(0);
        }
        if (Long.class == classzz || long.class == classzz) {
            return Long.valueOf(value);
        }
        if (Float.class == classzz || float.class == classzz) {
            return Float.valueOf(value);
        }
        if (Double.class == classzz || double.class == classzz) {
            return Double.valueOf(value);
        }
        if (Boolean.class == classzz || boolean.class == classzz) {
            return Boolean.valueOf(value.toLowerCase());
        }
        if (BigDecimal.class == classzz) {
            return new BigDecimal(value);
        }
       /* if (Date.class == classzz) {
            SimpleDateFormat formatter = new SimpleDateFormat(FULL_DATA_FORMAT);
            ParsePosition pos = new ParsePosition(0);
            Date date = formatter.parse(value, pos);
            return date;
        }*/
        return value;
    }
    /**
     * 获取properties的set和get方法
     */
    static class MethodUtils {
        private static final String SET_PREFIX = "set";
        private static final String GET_PREFIX = "get";
        private static String capitalize(String name) {
            if (name == null || name.length() == 0) {
                return name;
            }
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }
        public static String setMethodName(String propertyName) {
            return SET_PREFIX + capitalize(propertyName);
        }
        public static String getMethodName(String propertyName) {
            return GET_PREFIX + capitalize(propertyName);
        }
    }
    
    public static void main(String[] args) {
    	File file = new File("/Users/mac/Desktop/student.xlsx");
    	try {
			FileInputStream in = new FileInputStream(file);
			try {
				List<ExcelHead> heads = new ArrayList<>();
				ExcelHead head = new ExcelHead();
				head.setExcelName("学号");
				head.setEntityName("sid");
				
				ExcelHead head1 = new ExcelHead();
				head1.setExcelName("姓名");
				head1.setEntityName("name");
				
				ExcelHead head2 = new ExcelHead();
				head2.setExcelName("小名");
				head2.setEntityName("littleName");
				
				
				ExcelHead head3 = new ExcelHead();
				head3.setExcelName("班级");
				head3.setEntityName("classId");
				
				ExcelHead head4 = new ExcelHead();
				head4.setExcelName("出生年月");
				head4.setEntityName("birthday");
				
				ExcelHead head5 = new ExcelHead();
				head5.setExcelName("家庭住址");
				head5.setEntityName("address");
				
				ExcelHead head6 = new ExcelHead();
				head6.setExcelName("入学时间");
				head6.setEntityName("enterDate");
//				sid	name	little_name	sex	class_id(导入时需关联class_info表获取班级id插入此列)	birthday	address	enter_date	out_date	guardian_num	remark
//				学号	姓名	小名	性别	班级	出生年月	家庭住址	入学时间	毕业时间	监护人数	备注
				ExcelHead head7 = new ExcelHead();
				head7.setExcelName("毕业时间");
				head7.setEntityName("outDate");
				
				ExcelHead head9 = new ExcelHead();
				head9.setEntityName("remark");
				head9.setExcelName("备注");
				heads.add(head9);
				
				ExcelHead head8 = new ExcelHead();
				head8.setExcelName("监护人数");
				head8.setEntityName("guardianNum");
				heads.add(head8);
				heads.add(head7);
				heads.add(head6);
				heads.add(head5);
				heads.add(head4);
				heads.add(head3);
				heads.add(head2);
				heads.add(head);
				
				
				List<Student> list = ExcelUtils.readExcelToEntity(Student.class, in, "/Users/mac/Desktop/student.xlsx", heads);
				Student student = list.get(0);
				System.out.println(student.getAddress());
				System.out.println(list.size());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
}


