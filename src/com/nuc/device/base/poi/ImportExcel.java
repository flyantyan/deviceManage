package com.nuc.device.base.poi;

import com.nuc.device.base.poi.bean.ExcelColumnBean;
import com.nuc.device.base.poi.util.PoiCommonUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2016/3/6
 * Time:5:46
 */
public class ImportExcel<T> {
    private HSSFWorkbook workbook;
    private List<ExcelColumnBean> list;
    private Class beanClass;
    public  ImportExcel(){}
    public  ImportExcel(InputStream inputStream,Class beanClass){
        try {
            this.workbook=new HSSFWorkbook(new POIFSFileSystem(inputStream));
            this.list= PoiCommonUtils.getColumnBeanList(beanClass);
            this.beanClass=beanClass;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String checkExcel(){
        String result="success";
        if(workbook==null){
            return "上传文件为空!";
        }
        HSSFSheet sheet=workbook.getSheetAt(0);
        HSSFRow row=sheet.getRow(0);
        for(int i=0;i<list.size();i++){
            if(!row.getCell(i).getStringCellValue().equals(list.get(i).getColumnName())){
                return "sheet中列名与要求不匹配!";
            }
        }
        return  result;
    }
    public  List<T> excelToList(){
        List reList=new ArrayList();
        try {
            HSSFSheet sheet=workbook.getSheetAt(0);
            HSSFRow row;
            int count=1;
            boolean flag=sheet.getRow(count)==null?false:true;
            while (flag){
                Object obj=beanClass.newInstance();
                row=sheet.getRow(count);
                if(row!=null){
                    for(int i=0;i<list.size();i++){
                        ExcelColumnBean columnBean=list.get(i);
                        Object value=PoiCommonUtils.parseType(columnBean.getColumnField().getType(), row.getCell(i).getStringCellValue());
                        columnBean.getSetterMethod().invoke(obj, value);
                    }
                    reList.add(obj);
                    count++;
                }else {
                    flag=false;
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return reList;
    }
}
