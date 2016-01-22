package com.nuc.device.base.poi.util;

import com.nuc.device.base.poi.annotation.ExcelColumnName;
import com.nuc.device.base.poi.bean.ExcelColumnBean;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/21
 * Time:22:18
 */
public class PoiCommonUtils {
    /**
     * 获取实体类中属性的集合
     * @param clazz
     * @return
     */
    public static List<ExcelColumnBean> getColumnBeanList(Class clazz){
        if(clazz==null){
            return null;
        }
        List<ExcelColumnBean> list=new ArrayList<ExcelColumnBean>();
        Field[] fields=clazz.getDeclaredFields();
        for(Field field:fields){
            try {
                ExcelColumnName anno=field.getAnnotation(ExcelColumnName.class);
                if(anno!=null&&anno.value()!=null){
                    ExcelColumnBean bean=new ExcelColumnBean();
                    bean.setColumnName(anno.value());
                    bean.setColumnField(field);
                    bean.setGetterMethod(clazz.getMethod(getMethodName("get",field)));
                    bean.setSetterMethod(clazz.getMethod(getMethodName("set",field),field.getType()));
                    list.add(bean);
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 获取类中属性的get和set方法名
     * @param prefix
     * @param field
     * @return
     */
    private static String getMethodName(String prefix,Field field){
        return prefix + field.getName().substring(0,1).toUpperCase()+
                field.getName().substring(1);
    }

    /**
     * 校验导入的excel
     * @param is
     * @param beanClass
     * @return
     */
    public static String checkExcel(InputStream is,Class beanClass){
        String result="success";
        if(is==null){
            return "上传文件为空!";
        }
        List<ExcelColumnBean> list=getColumnBeanList(beanClass);
        try {
            HSSFWorkbook workbook=new HSSFWorkbook(new POIFSFileSystem(is));
            HSSFSheet sheet=workbook.getSheetAt(0);
            if(sheet.getTopRow()<=1){
                return "sheet中行数不足!";
            }
            if(list.size()!=sheet.getFirstRowNum()){
                return "标题列数与要求不匹配!";
            }
            HSSFRow row=sheet.getRow(0);
            for(int i=0;i<list.size();i++){
                if(!row.getCell(i).getStringCellValue().equals(list.get(i).getColumnName())){
                    return "sheet中列名与要求不匹配!";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  result;
    }
}
