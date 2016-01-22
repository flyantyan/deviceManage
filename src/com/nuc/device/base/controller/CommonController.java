package com.nuc.device.base.controller;

import com.nuc.device.base.dao.*;
import com.nuc.device.base.service.MenuService;
import com.nuc.device.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.rmi.MarshalledObject;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/28
 * Time:21:44
 */
@Controller
@RequestMapping("common/")
public class CommonController implements JspageConstant{
    private final static Logger logger= LoggerFactory.getLogger(CommonController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;
    @RequestMapping("toIndex.do")
    public String toIndex(){
        return INDEX;
    }
    @RequestMapping("toLogin.do")
    public String toLogin(){
        return LOGIN;
    }
    @RequestMapping("logout.do")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        session.removeAttribute("userMenu");
        return LOGIN;
    }
    @RequestMapping("toUserList.do")
    public String toUserList(){
        return USERLIST;
    }
    @RequestMapping("toMenuList.do")
    public String toMenuList(ModelMap modelMap){
        modelMap.put("menu",menuService.getAllMenu());
        return MENULIST;
    }
    @RequestMapping("toDevOrigin.do")
    public String toDevOrigin(ModelMap modelMap){
        return DEVORIGIN;
    }
    @RequestMapping("toDevCategory.do")
    public String toDevCategory(ModelMap modelMap){
        return DEVCATEGORY;
    }
    @RequestMapping("toDevCountry.do")
    public String toDevCountry(ModelMap modelMap){
        return DEVCOUNTRY;
    }
    @RequestMapping("toDevDeposit.do")
    public String toDevDeposit(ModelMap modelMap){
        return DEVDEPOSIT;
    }
    @RequestMapping("toDirection.do")
    public String toDirection(ModelMap modelMap){
        return DEVDIRECTION;
    }
    @RequestMapping("toFoundSub.do")
    public String toFoundSub(ModelMap modelMap){
        return DEVFOUNDSUB;
    }
    @RequestMapping("toDevInfoList.do")
    public String toDevInfoList(ModelMap modelMap){
        return DEVINFOLIST;
    }
    @RequestMapping("toApplyList.do")
    public String toApplyList(ModelMap modelMap){
        return APPLYLIST;
    }
    @RequestMapping("toMaintainList.do")
    public String toMaintainList(ModelMap modelMap){
        return MAINTAINLIST;
    }
    @RequestMapping("toDumpList.do")
    public String toDumpList(ModelMap modelMap){
        return DUMPLIST;
    }
    @RequestMapping("toUserDetail.do")
    public String toUserDetail(ModelMap modelMap){
        return USERDETAIL;
    }
    @RequestMapping("toUpdatePwd.do")
    public String toUpdatePwd(ModelMap modelMap){
        return UPDATEPWD;
    }
    @RequestMapping("toAddSystemParam.do")
    public String toAddSystemParam(ModelMap modelMap,HttpServletRequest request){
        modelMap.put("toUrl", request.getParameter("toUrl"));
        modelMap.put("systemParamName",request.getParameter("systemParamName"));
        return ADDSYSTEMPARAM;
    }
}
