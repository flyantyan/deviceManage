package com.nuc.device.util;

import com.nuc.device.base.bean.*;
import com.nuc.device.listener.InitSystemListener;
import org.apache.poi.ss.formula.functions.Count;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/20
 * Time:19:51
 */
public class SystemParamUtils extends InitSystemListener{
    public static List<Category> getCategoryList(){
        return (List<Category>) application.getAttribute(CATEGORYLIST);
    }
    public static List<Country> getCountryList(){
        return (List<Country>) application.getAttribute(COUNTRYLIST);
    }
    public static List<Deposit> getDepositList(){
        return (List<Deposit>) application.getAttribute(DEPOSITLIST);
    }
    public static List<Direction> getDirectionList(){
        return (List<Direction>) application.getAttribute(DIRECTIONLIST);
    }
    public static List<FoundSub> getFoundSubList(){
        return (List<FoundSub>) application.getAttribute(FOUNDSBULIST);
    }
    public static List<Origin> getOriginList(){
        return (List<Origin>) application.getAttribute(ORIGINLIST);
    }
    public static void setOriginList(List<Origin> list){
        application.setAttribute(ORIGINLIST,list);
    }
    public static void setCategoryList(List<Category> list){
        application.setAttribute(CATEGORYLIST,list);
    }
    public static void setCountryList(List<Country> list){
        application.setAttribute(COUNTRYLIST,list);
    }
    public static void setDepositList(List<Deposit> list){
        application.setAttribute(DEPOSITLIST,list);
    }
    public static void setDirectionList(List<Direction> list){
        application.setAttribute(DIRECTIONLIST,list);
    }
    public static void setFoundSubList(List<FoundSub> list){
        application.setAttribute(FOUNDSBULIST,list);
    }
}
