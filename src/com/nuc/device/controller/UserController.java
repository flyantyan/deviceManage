package com.nuc.device.controller;

import com.alibaba.fastjson.JSON;
import com.nuc.device.base.controller.JspageConstant;
import com.nuc.device.base.poi.ExportExcel;
import com.nuc.device.base.service.MenuService;
import com.nuc.device.bean.DevInfo;
import com.nuc.device.bean.User;
import com.nuc.device.service.UserService;
import com.nuc.device.util.CommonUtil;
import com.nuc.device.util.Page;
import com.nuc.device.util.PagerHelper;
import com.sun.deploy.net.HttpResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/29
 * Time:1:21
 */
@Controller
@RequestMapping("user/")
public class UserController implements JspageConstant {
    private final static Logger logger=Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;
    @RequestMapping("login.do")
    public String login(ModelMap modelMap,User user,
                        HttpSession session){
        if(user.getUserName()==null||user.getUserPwd()==null){
            modelMap.put("msg","用户名或密码不能为空！");
            return LOGIN;
        }
        List<User> list=userService.queryUserList(user);
        if(list.size()==0){
            modelMap.put("msg","提示：用户名不存在，请重新输入！");
            return LOGIN;
        }else{
            User newUser=list.get(0);
            if(!CommonUtil.toMD5String(user.getUserPwd()).equals(newUser.getUserPwd())){
                modelMap.put("msg","提示：密码不正确，请重新输入！");
                return LOGIN;
            }
            session.setAttribute("user",newUser);
            session.setAttribute("userMenu",menuService.getMenu(newUser.getUserMenu()));
            return INDEX;
        }
    }
    @RequestMapping("userList.do")
    public void userList(User user, HttpServletResponse response){
        try {
            List<User> list=userService.queryUserList(user);
            response.setContentType("text/html; charset=gb2312");
            response.getWriter().write(JSON.toJSONString(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("resetPwd.do")
    public void resetPwd(HttpServletResponse response,User param,HttpSession session){
        try {
            long empId=((User)session.getAttribute("user")).getId();
            User user=userService.queryUserById(param.getId());
            user.setModifyEmpId(empId);
            userService.resetPwd(user);
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("createUser.do")
    public void createUser(User user,HttpServletResponse response,
                           HttpSession session){
        try {
            long empId=((User)session.getAttribute("user")).getId();
            user.setModifyEmpId(empId);
            user.setCreateEmpId(empId);
            userService.saveUser(user);
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("delUserById.do")
    public void delUserById(User user,HttpSession session,
                            HttpServletResponse response){
        try {
            long empId=((User)session.getAttribute("user")).getId();
            user.setModifyEmpId(empId);
            userService.delUser(user);
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("toUserEdit.do")
    public String toUserEdit(ModelMap modelMap){
        return USEREDIT;
    }
    @RequestMapping("downLoadUser.do")
    public void downLoadUser(User user, HttpServletResponse response,HttpServletRequest request){
        try {
            List<User> list=userService.queryUserList(user);
            String fileName=String.valueOf(System.currentTimeMillis());
            String path=request.getSession().getServletContext().getRealPath("temp")+"/";
            ExportExcel exportExcel=new ExportExcel(list,User.class,fileName,path);
            exportExcel.export();
            response.getWriter().write(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("updatePwd.do")
    public void updatePwd(String pwd,HttpSession session,HttpServletResponse response){
        try {
            User user=(User)session.getAttribute("user");
            user.setUserPwd(CommonUtil.toMD5String(pwd));
            user.setModifyEmpId(user.getId());
            userService.updateUser(user);
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("toUserList.do")
    public String toUserList(ModelMap modelMap,HttpServletRequest request){
        List<User> list=userService.queryUserList(new User());
        modelMap.put("userList",list);
        modelMap.put("menuId",request.getParameter("menuId"));
        return "userList01";
    }
}
