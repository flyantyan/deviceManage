package com.nuc.device.controller;

import com.alibaba.fastjson.JSON;
import com.nuc.device.base.controller.JspageConstant;
import com.nuc.device.bean.DevMaintain;
import com.nuc.device.service.DevMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
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
    @Autowired
    private DevMaintainService maintainService;
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
}
