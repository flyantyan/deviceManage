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
  <title>实验室设备管理系统--个人基本信息</title>
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
<jsp:include page="/common/topNonUserSymbal.jsp"/>
<input type="hidden" value="<%=basePath%>" id="basePath">
  <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
      <div style="margin-left: 50px;">
        <label>用户名:&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.user.userName}</label>
      </div>
      <div style="margin-left: 50px;">
        <label>真实姓名:${sessionScope.user.realName}</label>
      </div>
      <div style="margin-left: 50px;">
        <label>性别:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.user.sexDesc}</label>
      </div>
      <div style="margin-left: 50px;">
        <label style="float: left;margin-top: 5px;">角色:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.user.roleDesc}</label>
      </div>
      <div style="clear: both;"></div>
      <div style="margin-left: 50px;">
        <label>电话:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.user.userTel}</label>
      </div>
      <div style="margin-left: 50px;">
        <label>备注</label><br>
        <textarea name="remark" readonly="true" style="width: 400px; height: 100px;resize: none;">${devInfo.remark}</textarea>
      </div>
    </div>
  </div>
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
