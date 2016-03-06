<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/12/20
  Time: 22:48
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
  <title>实验室设备管理系统--设备申请详情</title>
  <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=basePath%>css/styles.css" rel="stylesheet">
  <link rel="shortcut icon" href="<%=basePath%>images/device.ico" />
</head>
<body>
  <jsp:include page="/common/topNonUserSymbal.jsp"/>
  <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <c:forEach var="item" items="${itemList}" varStatus="status">
        <div class="row">
        <div class="breadcrumb">申请设备${status.index+1}</div>
        <div style="margin-left: 50px;">
          <label>设备编号</label>
          <input style="width: 200px;" value="${item.devNo}" readonly="true">
          <label style="margin-left: 183px;">设备名称</label>
          <input  style="width: 200px;" value="${item.devName}" readonly="true"><br>
        </div>
        <div style="margin-left: 50px;">
          <label>设备型号</label>
          <input style="width: 200px;" value="${item.modelNo}" readonly="true">
          <label style="margin-left: 183px;">设备规格</label>
          <input style="width: 200px;" value="${item.standard}" readonly="true"><br>
        </div>
        <div style="margin-left: 50px;">
          <label>设备类别</label>
          <input style="width: 200px;" value="${item.cateName}" readonly="true">
          <label style="margin-left: 183px;">设备国别</label>
          <input style="width: 200px;" value="${item.countryName}" readonly="true"><br>
        </div>
        <div style="margin-left: 50px;">
          <label>设备来源</label>
          <input style="width: 200px;" value="${item.originName}" readonly="true">
          <label style="margin-left: 183px;">使用方向</label>
          <input id="direct1" style="width: 200px;" value="${item.direcName}" readonly="true"><br>
        </div>
        <div style="margin-left: 50px;">
          <label>申请数量</label>
          <input  style="width: 200px;" value="${item.devNum}" readonly="true"><br>
        </div>
      </div>
    </c:forEach>
    <div class="row">
      <div class="breadcrumb">设备申请信息</div>
      <div style="margin-left: 50px;">
        <label>申请理由</label><br>
        <textarea id="applyText" readonly="true" style="width: 600px; height: 100px;resize: none;">${apply.applyText}</textarea>
      </div>
      <div style="margin-left: 50px;">
        <label>审核意见</label><br>
        <textarea id="dealText" readonly="true" style="width: 600px; height: 100px;resize: none;">${apply.dealText}</textarea>
      </div>
      <div style="margin-left: 50px;">
        <label>备注</label><br>
        <textarea id="remark" readonly="true" style="width: 600px; height: 100px;resize: none;">${apply.remark}</textarea>
      </div>
    </div>
  </div>
<script src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script src="<%=basePath%>js/bootstrap-table.js"></script>
<script src="<%=basePath%>js/apply.js"></script>
</body>
</html>