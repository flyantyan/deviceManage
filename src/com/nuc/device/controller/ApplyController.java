package com.nuc.device.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nuc.device.base.controller.JspageConstant;
import com.nuc.device.bean.Apply;
import com.nuc.device.bean.ApplyItem;
import com.nuc.device.bean.User;
import com.nuc.device.service.ApplyService;
import com.nuc.device.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/20
 * Time:17:03
 */
@Controller
@RequestMapping("apply/")
public class ApplyController implements JspageConstant{
    private static final Logger logger= LoggerFactory.getLogger(ApplyController.class);
    private final String applyListOther="dev/applyListOther";
    private final String myApplyList="dev/myApplyList";
    @Autowired
    private ApplyService applyService;
    @RequestMapping("queryApplyList.do")
    public void queryApplyList(HttpServletResponse response,Apply apply){
        try {
            List<Apply> list=applyService.queryApplyList(apply);
            response.setContentType("text/html; charset=gb2312");
            response.getWriter().write(JSON.toJSONString(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("queryApplyListByEmpId.do")
    public String queryApplyListByEmpId(ModelMap modelMap,Apply apply){
        modelMap.put("applyList",applyService.queryApplyList(apply));
        return applyListOther;
    }
    @RequestMapping("queryMyApplyList.do")
    public String queryMyApplyList(ModelMap modelMap,Apply apply,HttpSession session){
        long empId=((User)session.getAttribute("user")).getId();
        apply.setApplyEmpId(empId);
        modelMap.put("applyList",applyService.queryApplyList(apply));
        return myApplyList;
    }
    @RequestMapping("createApply.do")
    public void createApply(HttpServletResponse response,HttpSession session,
                            String applyJson,String appliItemListJson){
        try {
            long empId=((User)session.getAttribute("user")).getId();
            Apply apply=JSON.parseObject(applyJson,Apply.class);
            apply.setApplyEmpId(empId);
            apply.setModifyEmpId(empId);
            apply.setCreateEmpId(empId);
            List<ApplyItem> applyItemList=new ArrayList<ApplyItem>();
            List<JSONObject> applyJsonList=JSON.parseObject(appliItemListJson,List.class);
            for(JSONObject object:applyJsonList){
                ApplyItem applyItem=JSON.toJavaObject(object,ApplyItem.class);
                applyItem.setCreateEmpId(empId);
                applyItem.setModifyEmpId(empId);
                applyItemList.add(applyItem);
            }
            applyService.createApply(apply,applyItemList);
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("toApplyCreate.do")
    public String toApplyCreate(){
        return "dev/applyEdit";
    }
    @RequestMapping("toApplyDetail.do")
    public String toApplyDetail(ModelMap modelMap,Long applyId){
        Apply apply=applyService.queryApplyById(applyId);
        List<ApplyItem> applyItemList=applyService.queryApplyItemByApplyId(applyId);
        modelMap.put("apply",apply);
        modelMap.put("itemList",applyItemList);
        return "dev/applyDetail";
    }
    @RequestMapping("toApplyReview.do")
    public String toApplyReview(ModelMap modelMap,Long applyId){
        Apply apply=applyService.queryApplyById(applyId);
        List<ApplyItem> applyItemList=applyService.queryApplyItemByApplyId(applyId);
        modelMap.put("apply",apply);
        modelMap.put("itemList",applyItemList);
        return "dev/applyEditReview";
    }
    @RequestMapping("updateApply.do")
    public void updateApply(HttpSession session,Apply apply,
                            HttpServletResponse response){
        try {
            long empId=((User)session.getAttribute("user")).getId();
            apply.setModifyEmpId(empId);
            applyService.updateApply(apply);
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("updateApplyToPass.do")
    public void updateApplyToPass(HttpSession session,Apply apply,
                                  HttpServletResponse response){
        try {
            long empId=((User)session.getAttribute("user")).getId();
            apply.setDealEmpId(empId);
            apply.setModifyEmpId(empId);
            apply.setDealTime(new Date());
            applyService.updateApply(apply);
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("queryApplyStatus.do")
    public void queryApplyStatus(HttpServletResponse response,Long applyId){
        try {
            Apply apply=applyService.queryApplyById(applyId);
            response.getWriter().write(String.valueOf(apply.getStatus()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
