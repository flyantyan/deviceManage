<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/11/28
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<input type="hidden" value="<%=basePath%>" id="basePath">
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="javascript:void(0);"><span>实验室</span>设备管理系统</a>
            <ul class="user-menu">
                <li class="dropdown pull-right">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span
                            class="glyphicon glyphicon-user"></span> 个人信息 <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="javascript:toUserDetail();"><span class="glyphicon glyphicon-user"></span> 基本信息</a></li>
                        <li><a href="javascript:toUpdatePwd();"><span class="glyphicon glyphicon-cog"></span> 修改密码</a></li>
                        <li><a href="<%=basePath%>common/logout.do"><span class="glyphicon glyphicon-log-out"></span> 退出</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!-- /.container-fluid -->
</nav>
<script>
    function toUserDetail(){
        var bathPath=$("#basePath").val();
        window.open(bathPath+"common/toUserDetail.do",
                'newwindow', 'width=500,height=400, top=50, left=50,toolbar=no, menubar=no, scrollbars=yes, ' +
                'resizable=yes, location=no, status=no,left=460px');
    }
    function toUpdatePwd(){
        var bathPath=$("#basePath").val();
        window.open(bathPath+"common/toUpdatePwd.do",
                'newwindow', 'width=500,height=250, top=50, left=50,toolbar=no, menubar=no, scrollbars=yes, ' +
                'resizable=yes, location=no, status=no,left=460px');
    }
</script>
