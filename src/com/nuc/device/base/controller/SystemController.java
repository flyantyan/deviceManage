package com.nuc.device.base.controller;

import com.nuc.device.base.bean.*;
import com.nuc.device.base.dao.*;
import com.nuc.device.bean.User;
import com.nuc.device.service.UserService;
import com.nuc.device.util.BuildSerialNumber;
import com.nuc.device.util.SystemParamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
 * Time:17:01
 */
@Controller
@RequestMapping("system/")
public class SystemController implements JspageConstant{
    @Autowired
    private DevCountryDao countryDao;
    @Autowired
    private DevDepositDao devDepositDao;
    @Autowired
    private DevOriginDao originDao;
    @Autowired
    private DirectionDao directionDao;
    @Autowired
    private FoundSubDao foundSubDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private UserService userService;
    /**
     * 删除设备来源
     * @param response
     * @param session
     * @param originId
     */
    @RequestMapping("delOrigin.do")
    public void delOrigin(HttpServletResponse response,HttpSession session,
                          Long originId){
        try {
            User user=(User)session.getAttribute("user");
            Origin origin=new Origin();
            origin.setId(originId);
            origin.setModifyEmpId(user.getId());
            List<Origin> originList=SystemParamUtils.getOriginList();
            for (Origin ori:originList){
                if(ori.getId()==originId){
                    originList.remove(ori);
                    break;
                }
            }
            originDao.delOrigin(origin);
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加经费科目
     * @param response
     * @param session
     * @param systemParamName
     */
    @RequestMapping("addFoundSub.do")
    public void addFoundSub(HttpServletResponse response,HttpSession session,
                          String systemParamName){
        try {
            User user=(User)session.getAttribute("user");
            FoundSub foundSub=new FoundSub();
            foundSub.setFoundNo("FS" + BuildSerialNumber.getSimpleNo(18));
            foundSub.setFoundName(systemParamName);
            foundSub.setCreateEmpId(user.getId());
            foundSub.setModifyEmpId(user.getId());
            foundSubDao.insertFoundSub(foundSub);
            SystemParamUtils.setFoundSubList(foundSubDao.queryFoundSubList());
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除经费科目
     * @param response
     * @param session
     * @param foundId
     */
    @RequestMapping("delFoundSub.do")
    public void delFoundSub(HttpServletResponse response,HttpSession session,
                          Long foundId){
        try {
            User user=(User)session.getAttribute("user");
            FoundSub foundSub=new FoundSub();
            foundSub.setId(foundId);
            foundSub.setModifyEmpId(user.getId());
            List<FoundSub> foundList=SystemParamUtils.getFoundSubList();
            for (FoundSub found:foundList){
                if(found.getId()==foundId){
                    foundList.remove(found);
                    break;
                }
            }
            foundSubDao.delFoundSub(foundSub);
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加设备来源
     * @param response
     * @param session
     * @param systemParamName
     */
    @RequestMapping("addOrigin.do")
    public void addOrigin(HttpServletResponse response,HttpSession session,
                          String systemParamName){
        try {
            User user=(User)session.getAttribute("user");
            Origin origin=new Origin();
            origin.setOriginNo("ON" + BuildSerialNumber.getSimpleNo(18));
            origin.setOriginName(systemParamName);
            origin.setCreateEmpId(user.getId());
            origin.setModifyEmpId(user.getId());
            originDao.insertOrigin(origin);
            SystemParamUtils.setOriginList(originDao.queryOriginList());
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 删除使用方向
     * @param response
     * @param session
     * @param directionId
     */
    @RequestMapping("delDirection.do")
    public void delDirection(HttpServletResponse response,HttpSession session,
                            Long directionId){
        try {
            User user=(User)session.getAttribute("user");
            Direction direction=new Direction();
            direction.setId(directionId);
            direction.setModifyEmpId(user.getId());
            List<Direction> directionList=SystemParamUtils.getDirectionList();
            for (Direction direc:directionList){
                if(direc.getId()==directionId){
                    directionList.remove(direc);
                    break;
                }
            }
            directionDao.delDirection(direction);
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加使用方向
     * @param response
     * @param session
     * @param systemParamName
     */
    @RequestMapping("addDirection.do")
    public void addDirection(HttpServletResponse response,HttpSession session,
                          String systemParamName){
        try {
            User user=(User)session.getAttribute("user");
            Direction direction=new Direction();
            direction.setDirecNo("DI"+BuildSerialNumber.getSimpleNo(18));
            direction.setDirecName(systemParamName);
            direction.setCreateEmpId(user.getId());
            direction.setModifyEmpId(user.getId());
            directionDao.insertDirection(direction);
            SystemParamUtils.setDirectionList(directionDao.queryDirectionList());
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 添加设备存放地
     * @param response
     * @param session
     * @param systemParamName
     */
    @RequestMapping("addDeposit.do")
    public void addDeposit(HttpServletResponse response,HttpSession session,
                             String systemParamName){
        try {
            User user=(User)session.getAttribute("user");
            Deposit deposit=new Deposit();
            deposit.setDepositNo("DO"+BuildSerialNumber.getSimpleNo(18));
            deposit.setDepositName(systemParamName);
            deposit.setCreateEmpId(user.getId());
            deposit.setModifyEmpId(user.getId());
            devDepositDao.insertDeposit(deposit);
            SystemParamUtils.setDepositList(devDepositDao.queryDepositList());
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 删除设备存放地
     * @param response
     * @param session
     * @param depositId
     */
    @RequestMapping("delDeposit.do")
    public void delDeposit(HttpServletResponse response,HttpSession session,
                             Long depositId){
        try {
            User user=(User)session.getAttribute("user");
            Deposit deposit=new Deposit();
            deposit.setId(depositId);
            deposit.setModifyEmpId(user.getId());
            List<Deposit> depositList=SystemParamUtils.getDepositList();
            for (Deposit depo:depositList){
                if(depo.getId()==depositId){
                    depositList.remove(depo);
                    break;
                }
            }
            devDepositDao.delDeposit(deposit);
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 删除设备国别
     * @param response
     * @param session
     * @param countryId
     */
    @RequestMapping("delCountry.do")
    public void delCountry(HttpServletResponse response,HttpSession session,
                           Long countryId){
        try {
            User user=(User)session.getAttribute("user");
            Country country=new Country();
            country.setId(countryId);
            country.setModifyEmpId(user.getId());
            List<Country> countryList=SystemParamUtils.getCountryList();
            for (Country coun:countryList){
                if(coun.getId()==countryId){
                    countryList.remove(coun);
                    break;
                }
            }
            countryDao.delCountry(country);
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 添加设备国别
     * @param response
     * @param session
     * @param systemParamName
     */
    @RequestMapping("addCountry.do")
    public void addCountry(HttpServletResponse response,HttpSession session,
                           String systemParamName){
        try {
            User user=(User)session.getAttribute("user");
            Country country=new Country();
            country.setCountryNo("CO" + BuildSerialNumber.getSimpleNo(18));
            country.setCountryName(systemParamName);
            country.setCreateEmpId(user.getId());
            country.setModifyEmpId(user.getId());
            countryDao.insertCountry(country);
            SystemParamUtils.setCountryList(countryDao.queryCountryList());
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 添加设备类别
     * @param response
     * @param session
     * @param systemParamName
     */
    @RequestMapping("addCategory.do")
    public void addCategory(HttpServletResponse response,HttpSession session,
                           String systemParamName){
        try {
            User user=(User)session.getAttribute("user");
            Category category=new Category();
            category.setCateNo("CG"+BuildSerialNumber.getSimpleNo(18));
            category.setCateName(systemParamName);
            category.setCreateEmpId(user.getId());
            category.setModifyEmpId(user.getId());
            categoryDao.insertCategory(category);
            SystemParamUtils.setCategoryList(categoryDao.queryCategoryList());
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 删除设备国别
     * @param response
     * @param session
     * @param cateId
     */
    @RequestMapping("delCategory.do")
    public void delCategory(HttpServletResponse response,HttpSession session,
                           Long cateId){
        try {
            User user=(User)session.getAttribute("user");
            Category category=new Category();
            category.setId(cateId);
            category.setModifyEmpId(user.getId());
            List<Category> categoryList=SystemParamUtils.getCategoryList();
            for (Category cate:categoryList){
                if(cate.getId()==cateId){
                    categoryList.remove(cate);
                    break;
                }
            }
            categoryDao.delCategory(category);
            response.getWriter().write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("allotMenu.do")
    public void allotMenu(HttpServletResponse response,HttpServletRequest request){
        try{
            Long userId=Long.valueOf(request.getParameter("userId"));
            String menuId=request.getParameter("menuId");
            userService.allotMenu(userId,menuId);
            response.getWriter().write("1");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @RequestMapping("deviceStatus.do")
    public String deviceStatus(){
        return "system/deviceStatus";
    }
}
