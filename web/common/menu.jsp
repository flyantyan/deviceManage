<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/11/28
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
    <ul class="nav menu">
        <li><a href="<%=basePath%>common/toIndex.do"><span class="glyphicon glyphicon-home"></span>首页</a></li>
        <c:if test="${sessionScope.user.userRole!=4}">
            <c:forEach items="${userMenu}" var="menu">
                <li>
                    <a class="" href="<%=basePath%>${menu.menuUrl}">
                        <span class="glyphicon glyphicon-share-alt"></span> ${menu.menuName}
                    </a>
                </li>
            </c:forEach>
        </c:if>
        <c:if test="${sessionScope.user.userRole==4}">
        <li class="parent ">
            <a href="#">
                <span class="glyphicon glyphicon-list-alt"></span> 设备管理
                <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right">
                    <em class="glyphicon glyphicon-s glyphicon-plus"></em></span>
            </a>
            <ul class="children collapse" id="sub-item-1">
                <li>
                    <a class="" href="<%=basePath%>common/toDevInfoList.do">
                        <span class="glyphicon glyphicon-share-alt"></span> 设备基本信息列表
                    </a>
                </li>
                <li>
                    <a class="" href="<%=basePath%>common/toApplyList.do">
                        <span class="glyphicon glyphicon-share-alt"></span> 设备申请列表
                    </a>
                </li>
                <li>
                    <a class="" href="<%=basePath%>common/toMaintainList.do">
                        <span class="glyphicon glyphicon-share-alt"></span> 设备维修列表
                    </a>
                </li>
                <li>
                    <a class="" href="<%=basePath%>common/toDumpList.do">
                        <span class="glyphicon glyphicon-share-alt"></span> 设备报废列表
                    </a>
                </li>
            </ul>
        </li>
        <li><a href="<%=basePath%>common/toUserList.do"><span class="glyphicon glyphicon-user"></span> 用户列表</a></li>
        <li class="parent">
            <a href="javasjavascript:void(0);">
                <span class="glyphicon glyphicon-list"></span> 系统管理
                <span data-toggle="collapse" href="#sub-item-2" class="icon pull-right">
                    <em class="glyphicon glyphicon-s glyphicon-plus"></em></span>
            </a>
            <ul class="children collapse" id="sub-item-2">
                <li>
                    <a class="" href="<%=basePath%>common/toMenuList.do">
                        <span class="glyphicon glyphicon-share-alt"></span> 菜单管理
                    </a>
                </li>
                <li>
                    <a class="" href="<%=basePath%>common/toDevOrigin.do">
                        <span class="glyphicon glyphicon-share-alt"></span> 设备来源管理
                    </a>
                </li>
                <li>
                    <a class="" href="<%=basePath%>common/toDevCategory.do">
                        <span class="glyphicon glyphicon-share-alt"></span> 设备类别管理
                    </a>
                </li>
                <li>
                    <a class="" href="<%=basePath%>common/toDevCountry.do">
                        <span class="glyphicon glyphicon-share-alt"></span> 设备国别管理
                    </a>
                </li>
                <li>
                    <a class="" href="<%=basePath%>common/toDevDeposit.do">
                        <span class="glyphicon glyphicon-share-alt"></span> 设备存放地管理
                    </a>
                </li>
                <li>
                    <a class="" href="<%=basePath%>common/toFoundSub.do">
                        <span class="glyphicon glyphicon-share-alt"></span> 设备经费科目管理
                    </a>
                </li>
                <li>
                    <a class="" href="<%=basePath%>common/toDirection.do">
                        <span class="glyphicon glyphicon-share-alt"></span> 设备使用方向管理
                    </a>
                </li>
            </ul>
        </li>
        <li class="parent ">
            <a href="#">
                <span class="glyphicon glyphicon-lock"></span> 系统维护
                <span data-toggle="collapse" href="#sub-item-3" class="icon pull-right">
                    <em class="glyphicon glyphicon-s glyphicon-plus"></em>
                </span>
            </a>
            <ul class="children collapse" id="sub-item-3">
                <li>
                    <a class="" href="#">
                        <span class="glyphicon glyphicon-share-alt"></span> 设备现状
                    </a>
                </li>
                <li>
                    <a class="" href="#">
                        <span class="glyphicon glyphicon-share-alt"></span> 数据库备份
                    </a>
                </li>
                <li>
                    <a class="" href="<%=basePath%>druid/index.html" target="_blank">
                        <span class="glyphicon glyphicon-share-alt"></span> 系统监控
                    </a>
                </li>
            </ul>
        </li>
        </c:if>
    </ul>
</div>
<!--/.sidebar-->