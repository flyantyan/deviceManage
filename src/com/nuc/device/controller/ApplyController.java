package com.nuc.device.controller;

import com.alibaba.fastjson.JSON;
import com.nuc.device.base.controller.JspageConstant;
import com.nuc.device.bean.Apply;
import com.nuc.device.bean.ApplyItem;
import com.nuc.device.bean.User;
import com.nuc.device.service.ApplyService;
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
 * Time:17:03
 */
@Controller
@RequestMapping("apply/")
public class ApplyController implements JspageConstant{
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
    public void createApply(HttpServletResponse response,HttpSession session,
                            String applyJson,String appliItemListJson){
        long empId=((User)session.getAttribute("user")).getId();
        Apply apply=JSON.parseObject(applyJson,Apply.class);
        apply.setApplyEmpId(empId);
        apply.setModifyEmpId(empId);
        apply.setCreateEmpId(empId);
        List<ApplyItem> applyItemList=JSON.parseObject(appliItemListJson,List.class);
        for(ApplyItem applyItem:applyItemList){
            applyItem.setCreateEmpId(empId);
            applyItem.setModifyEmpId(empId);
        }

    }
}
