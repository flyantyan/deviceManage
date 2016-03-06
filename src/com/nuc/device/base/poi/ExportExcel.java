package com.nuc.device.base.poi;

import com.nuc.device.base.poi.bean.ExcelColumnBean;
import com.nuc.device.base.poi.util.PoiCommonUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/21
 * Time:22:33
 */
public class ExportExcel {
    private final static Logger logger=Logger.getLogger(ExportExcel.class);
    private List dataset;
    private List<ExcelColumnBean> columnList;
    private String fileName;
    private String path;
    public  ExportExcel(){}
    public  ExportExcel(List dataset,Class beanClass,String fileName,String path){
        this.dataset=dataset;
        this.columnList= PoiCommonUtils.getColumnBeanList(beanClass);
        this.fileName=fileName;
        this.path=path;
    }
    public void export(){
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet("sheet1");
        HSSFRow row=null;
        sheet.autoSizeColumn(1);
        HSSFCellStyle style1 = workbook.createCellStyle();
        style1.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        setTitleFont(workbook,style1);
        HSSFCellStyle style2 = workbook.createCellStyle();
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        HSSFCell cell = null;
        row=sheet.createRow(0);
        for(int i=0;i<columnList.size();i++){
            cell=row.createCell(i);
            cell.setCellValue(columnList.get(i).getColumnName());
            cell.setCellStyle(style1);
        }
        for(int i=0;i<dataset.size();i++){
            row=sheet.createRow(i+1);
            for(int j=0;j<columnList.size();j++){
                try {
                    cell=row.createCell(j);
                    Object value=columnList.get(j).getGetterMethod()
                            .invoke(dataset.get(i), null);
                    if(value==null){
                        cell.setCellValue("");
                    }else{
                        cell.setCellValue(value.toString());
                    }
                    cell.setCellStyle(style2);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            FileOutputStream fout = new FileOutputStream(path+fileName+".xls");
            workbook.write(fout);
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void setTitleFont(HSSFWorkbook wb,HSSFCellStyle style){
        HSSFFont font=wb.createFont();
        font.setFontHeightInPoints((short)12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        style.setFont(font);
    }
}
