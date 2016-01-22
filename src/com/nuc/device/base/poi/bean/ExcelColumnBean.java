package com.nuc.device.base.poi.bean;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Excel导入与导出封装实体类属性的bean
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/21
 * Time:22:16
 */
public class ExcelColumnBean {
    private String columnName;
    private Field columnField;
    private Method getterMethod;
    private Method setterMethod;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Field getColumnField() {
        return columnField;
    }

    public void setColumnField(Field columnField) {
        this.columnField = columnField;
    }

    public Method getGetterMethod() {
        return getterMethod;
    }

    public void setGetterMethod(Method getterMethod) {
        this.getterMethod = getterMethod;
    }

    public Method getSetterMethod() {
        return setterMethod;
    }

    public void setSetterMethod(Method setterMethod) {
        this.setterMethod = setterMethod;
    }
}
