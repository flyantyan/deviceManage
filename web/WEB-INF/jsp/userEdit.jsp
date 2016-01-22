<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/11/29
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>实验室设备管理系统--用户信息编辑</title>
  <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=basePath%>css/datepicker3.css" rel="stylesheet">
  <link href="<%=basePath%>css/styles.css" rel="stylesheet">
  <link rel="shortcut icon" href="<%=basePath%>images/device.ico" />

  <!--[if lt IE 9]>
  <script src="<%=basePath%>js/html5shiv.js"></script>
  <script src="<%=basePath%>js/respond.min.js"></script>
  <![endif]-->
</head>
<body>
    <jsp:include page="/common/topNonUserSymbal01.jsp"/>
    <input type="hidden" value="<%=basePath%>" id="basePath">
    <button type="submit" class="btn btn-primary" style="margin-left: 350px;" onclick="saveUser()">&nbsp;&nbsp;保存&nbsp;&nbsp;</button>
    <button type="submit" class="btn btn-primary" onclick="closePage()">&nbsp;&nbsp;关闭&nbsp;&nbsp;</button>
    <form id="userForm" name="userForm" method="post">
    <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
        <div class="row">
            <div style="margin-left: 50px;">
                <label>用户名:</label>
                <input name="userName" style="width: 200px;margin-left: 14px;">
            </div>
            <div style="margin-left: 50px;">
                <label>真实姓名:</label>
                <input name="realName" style="width: 200px;">
            </div>
            <div style="margin-left: 50px;">
                <label>性别:</label>
                <input name="userSex" style="margin-left: 26px;" type="radio" value="1" checked/>男
                <input name="userSex" style="margin-left: 15px;" type="radio" value="2"/>女<br>
            </div>
            <div style="margin-left: 50px;">
                <label style="float: left;margin-top: 5px;">角色:</label>
                <select name="userRole" class="form-control"style="width: 200px;float: left;margin-left: 26px;">
                    <option value="1">学生</option>
                    <option value="2">教师1</option>
                    <option value="3">教师2</option>
                    <option value="4">管理员</option>
                </select>
            </div>
            <div style="clear: both;"></div>
            <div style="margin-left: 50px;">
                <label>电话:</label>
                <input name="userTel" style="width: 200px;margin-left: 23px;">
            </div>
            <div style="margin-left: 50px;">
                <label>备注</label><br>
                <textarea name="remark"  style="width: 400px; height: 100px;resize: none;">${devInfo.remark}</textarea>
            </div>
        </div>
    </div>
    </form>
    <script src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
    <script src="<%=basePath%>js/bootstrap.min.js"></script>
    <script src="<%=basePath%>js/chart.min.js"></script>
    <script src="<%=basePath%>js/chart-data.js"></script>
    <script src="<%=basePath%>js/easypiechart.js"></script>
    <script src="<%=basePath%>js/easypiechart-data.js"></script>
    <script src="<%=basePath%>js/bootstrap-datepicker.js"></script>
    <script src="<%=basePath%>js/bootstrap-table.js"></script>
    <script src="<%=basePath%>js/userEdit.js"></script>
</body>
</html>
