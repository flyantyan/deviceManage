package com.nuc.device.util;

import com.nuc.device.intercepter.PageInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/26
 * Time:1:31
 */
public class PagerHelper {
    private final static Logger logger= LoggerFactory.getLogger(PagerHelper.class);
    public static Map<String,Object> doPage(int pageNum,int pageSize,Object target,
                                      String memthodName,Object param){
        Map<String,Object> map=new HashMap<String, Object>();
        try {
            PageInterceptor.startPage(pageNum,pageSize);
            Method method=target.getClass().getDeclaredMethod(memthodName,param.getClass());
            method.invoke(target,param);
            Page page=PageInterceptor.endPage();
            map.put("list",page.getResult());
            map.put("page",page);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return map;
    }
}
