package com.nuc.device.controller;

import com.alibaba.fastjson.JSON;
import com.nuc.device.base.controller.JspageConstant;
import com.nuc.device.bean.DevInfo;
import com.nuc.device.bean.DevMaintain;
import com.nuc.device.bean.User;
import com.nuc.device.service.DevInfoService;
import com.nuc.device.service.DevMaintainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/20
 * Time:17:04
 */
@Controller
@RequestMapping("maintain/")
public class DevMaintainController implements JspageConstant {
    private static final Logger logger= LoggerFactory.getLogger(DevInfoController.class);
    @Autowired
    private DevMaintainService maintainService;
    @Autowired
    private DevInfoService devInfoService;
    @RequestMapping("queryMaintainList.do")
    public void queryMaintainList(HttpServletResponse response,DevMaintain maintain){
        try {
            List<DevMaintain> list=maintainService.queryMaintainList(maintain);
            response.setContentType("text/html; charset=gb2312");
            response.getWriter().write(JSON.toJSONString(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("toMaintainEdit.do")
    public String toMaintainEdit(){
        return "dev/maintainEdit";
    }
    @RequestMapping("createMaintain.do")
    public void createMaintain(HttpServletResponse response,DevMaintain maintain,
                               HttpSession session){
        try {
            long empId=((User)session.getAttribute("user")).getId();
            maintain.setModifyEmpId(empId);
            maintain.setCreateEmpId(empId);
            maintainService.createMaintain(maintain);
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("updateMaintainStatus.do")
    public void updateMaintainStatus(HttpServletResponse response,DevMaintain maintain,
                                     HttpSession session){
        try {
            long empId=((User)session.getAttribute("user")).getId();
            maintain.setModifyEmpId(empId);
            maintainService.updateMaintainStatus(maintain);
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("queryMaintainById.do")
    public String queryMaintainById(ModelMap modelMap,Long maintainId){
        DevMaintain maintain=maintainService.queryMaintainById(maintainId);
        DevInfo devInfo=devInfoService.queryDevInfoById(maintain.getDevId());
        modelMap.put("maintain",maintain);
        modelMap.put("devInfo",devInfo);
        return "dev/maintainDetail";
    }
    @RequestMapping("queryMaintainStatusById.do")
    public void queryMaintainStatusById(HttpServletResponse response,Long maintainId){
        try {
            DevMaintain maintain=maintainService.queryMaintainById(maintainId);
            response.getWriter().write(String.valueOf(maintain.getStatus()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
