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
  <title>实验室设备管理系统--设备维修编辑</title>
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
  <input type="hidden" id="basePath" value="<%=basePath%>">
  <button type="submit" class="btn btn-primary" style="margin-left: 85%;" onclick="saveDevMaintain()">&nbsp;&nbsp;保存&nbsp;&nbsp;</button>
  <button type="submit" class="btn btn-primary" onclick="window.close();">&nbsp;&nbsp;关闭&nbsp;&nbsp;</button>
  <input type="hidden" id="devId" name="devId">
  <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <div class="breadcrumb">设备基本信息</div>
        <div style="margin-left: 50px;">
          <label>设备编号</label>
          <input id="devNo" style="width: 200px;">
          <a href="javascript:findDevInfo()" >加载</a>
          <label style="margin-left: 150px;">设备名称</label>
          <input id="devName" style="width: 200px;" readonly="true"><br>
        </div>
        <div style="margin-left: 50px;">
          <label>条形码</label>
          <input id="barCode" style="width: 200px;margin-left: 14px;" readonly="true">
          <label style="margin-left: 183px;">设备权限</label>
          <input id="devPower" style="width: 200px;" readonly="true"><br>
        </div>
      <div style="margin-left: 50px;">
        <label>设备型号</label>
        <input id="modelNo" style="width: 200px;" readonly="true">
        <label style="margin-left: 183px;">设备规格</label>
        <input id="standard" style="width: 200px;" readonly="true"><br>
      </div>
      <div style="margin-left: 50px;">
        <label>设备类别</label>
        <input id="cate" style="width: 200px;" readonly="true">
        <label style="margin-left: 183px;">设备国别</label>
        <input id="country" style="width: 200px;" readonly="true"><br>
      </div>
      <div style="margin-left: 50px;">
        <label>设备来源</label>
        <input id="origin" style="width: 200px;" readonly="true">
        <label style="margin-left: 183px;">使用方向</label>
        <input id="direct" style="width: 200px;" readonly="true"><br>
      </div>
      <div style="margin-left: 50px;">
        <label >存放地点</label>
        <input id="depo" style="width: 200px;" readonly="true">
        <label style="margin-left: 183px;">经费科目</label>
        <input id="found" style="width: 200px;" readonly="true"><br>
      </div>
      <div style="margin-left: 50px;">
        <label>生产厂商</label>
        <input id="firm" style="width: 200px;" readonly="true">
        <label style="margin-left: 183px;">出厂编号</label>
        <input id="outFirmNo" style="width: 200px;" readonly="true"><br>
      </div>
      <div style="margin-left: 50px;">
        <label>购买时间</label>
        <input id="purchaseTime" style="width: 200px;" readonly="true"><br>
      </div>
    </div>
    <div class="row">
      <div class="breadcrumb">设备维修情况</div>
      <div style="margin-left: 50px;">
        <label>维修数量</label>
        <input id="maintainNum" style="width: 200px;" >
        <label style="margin-left: 183px;">维修负责人</label>
        <input id="maintainEmp" style="width: 185px;"><br>
      </div>
      <div style="margin-left: 50px;">
        <label>备注</label><br>
        <textarea id="remark" style="width: 600px; height: 100px;resize: none;"></textarea>
      </div>
    </div>
  </div>
<script src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script src="<%=basePath%>js/bootstrap-datepicker.js"></script>
<script src="<%=basePath%>js/bootstrap-table.js"></script>
<script src="<%=basePath%>js/maintain.js"></script>
</body>
</html>