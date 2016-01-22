package com.nuc.device.controller;

import com.alibaba.fastjson.JSON;
import com.nuc.device.base.poi.ExportExcel;
import com.nuc.device.bean.DevInfo;
import com.nuc.device.bean.User;
import com.nuc.device.service.DevInfoService;
import com.sun.deploy.net.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/20
 * Time:14:28
 */
@Controller
@RequestMapping("devInfo/")
public class DevInfoController{
    private final static Logger logger= LoggerFactory.getLogger(DevInfoController.class);
    private final static String devInfoList="dev/devInfoList";
    private final static String devInfoDetail="dev/devInfoDetail";
    private final static String devInfoUpdate="dev/devInfoEdit";
    private final static String devInfoCreate="dev/devInfoCreate";
    @Autowired
    private DevInfoService devInfoService;
    @RequestMapping("queryDevInfo.do")
    public void queryDevInfo(HttpServletResponse response,DevInfo devInfo){
        try {
            List<DevInfo> list=devInfoService.queryDevInfo(devInfo);
            response.setContentType("text/html; charset=gb2312");
            response.getWriter().write(JSON.toJSONString(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("toDevInfoDetail.do")
    public String toDevInfoDetail(ModelMap modelMap,Long devId){
        modelMap.put("devInfo",devInfoService.queryDevInfoById(devId));
        return devInfoDetail;
    }
    @RequestMapping("downLoadDevInfo.do")
    public void downLoadDevInfo(HttpServletResponse response,HttpServletRequest request,
                                DevInfo devInfo){
        try {
            List<DevInfo> list=devInfoService.queryDevInfo(devInfo);
            String fileName=String.valueOf(System.currentTimeMillis());
            String path=request.getSession().getServletContext().getRealPath("temp")+"/";
            ExportExcel exportExcel=new ExportExcel(list,DevInfo.class,fileName,path);
            exportExcel.export();
            response.getWriter().write(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("importDevInfo.do")
    public void importDevInfo(HttpServletResponse response,HttpServletRequest request){

    }
    @RequestMapping("toDevInfoUpdate.do")
    public String toDevInfoUpdate(ModelMap modelMap,Long devId){
        modelMap.put("devInfo",devInfoService.queryDevInfoById(devId));
        return  devInfoUpdate;
    }
    @RequestMapping("updateDevInfo.do")
    public void updateDevInfo(DevInfo dev,HttpServletResponse response,
                              HttpSession session){
        try {
            long empId=((User)session.getAttribute("user")).getId();
            dev.setModifyEmpId(empId);
            devInfoService.updateDevInfo(dev);
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("toDevInfoCreate.do")
    public String toDevInfoCreate(ModelMap modelMap){
        return devInfoCreate;
    }
    @RequestMapping("createDevInfo.do")
    public void createDevInfo(DevInfo devInfo,HttpServletResponse response,
                              HttpSession session){
        try {
            long empId=((User)session.getAttribute("user")).getId();
            devInfo.setCreateEmpId(empId);
            devInfo.setModifyEmpId(empId);
            devInfoService.createDevInfo(devInfo);
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("findDevInfoByNo.do")
    public void findDevInfoByNo(String devNo,HttpServletResponse response){
        try {
            DevInfo devInfo=devInfoService.queryDevInfoByNo(devNo);
            response.setContentType("text/html; charset=gb2312");
            response.getWriter().write(JSON.toJSONString(devInfo));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
