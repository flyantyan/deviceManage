package com.nuc.device.controller;

import com.alibaba.fastjson.JSON;
import com.nuc.device.base.controller.JspageConstant;
import com.nuc.device.bean.DevDump;
import com.nuc.device.bean.DevInfo;
import com.nuc.device.bean.User;
import com.nuc.device.dao.DevInfoDao;
import com.nuc.device.service.DevDumpService;
import com.nuc.device.service.DevInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/20
 * Time:17:05
 */
@Controller
@RequestMapping("dump/")
public class DevDumpController implements JspageConstant {
    @Autowired
    private DevDumpService dumpService;
    @Autowired
    private DevInfoService devInfoService;
    @RequestMapping("queryDumpList.do")
    public void queryDumpList(HttpServletResponse response,DevDump dump){
        try {
            List<DevDump> list=dumpService.queryDumpList(dump);
            response.setContentType("text/html; charset=gb2312");
            response.getWriter().write(JSON.toJSONString(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("queryDumpById.do")
    public String queryDumpById(ModelMap modelMap,Long dumpId){
        DevDump dump=dumpService.queryDumpById(dumpId);
        DevInfo devInfo=devInfoService.queryDevInfoById(dump.getDevId());
        modelMap.put("dump",dump);
        modelMap.put("devInfo",devInfo);
        return "dev/dumpDetail";
    }
    @RequestMapping("toDumpEdit.do")
    public String toDumpEdit(){
        return "dev/dumpEdit";
    }
    @RequestMapping("createDevDump.do")
    public void createDevDump(HttpServletResponse response,HttpSession session,
                                DevDump dump){
        try {
            long empId=((User)session.getAttribute("user")).getId();
            dump.setDumpTime(new Date());
            dump.setModifyEmpId(empId);
            dump.setCreateEmpId(empId);
            dumpService.createDump(dump);
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
