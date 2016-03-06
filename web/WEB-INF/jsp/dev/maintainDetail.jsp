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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>实验室设备管理系统--设备维修详情</title>
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
  <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <div class="breadcrumb">设备基本信息</div>
        <div style="margin-left: 50px;">
          <label>设备编号</label>
          <input style="width: 200px;" value="${devInfo.devNo}" readonly="true">
          <label style="margin-left: 100px;">设备名称</label>
          <input style="width: 200px;" value="${devInfo.devName}" readonly="true"><br>
        </div>
        <div style="margin-left: 50px;">
          <label>条形码</label>
          <input style="width: 200px;margin-left: 14px;" value="${devInfo.barCode}" readonly="true">
          <label style="margin-left: 100px;">设备权限</label>
          <input style="width: 200px;" value="${devInfo.devPower}" readonly="true"><br>
        </div>
      <div style="margin-left: 50px;">
        <label>设备型号</label>
        <input style="width: 200px;" value="${devInfo.modelNo}" readonly="true">
        <label style="margin-left: 100px;">设备规格</label>
        <input style="width: 200px;" value="${devInfo.standard}" readonly="true"><br>
      </div>
      <div style="margin-left: 50px;">
        <label style="float: left;margin-top: 5px;">设备类别&nbsp;</label>
        <select class="form-control"style="width: 200px;float: left;">
          <option value="${devInfo.cateId}">${devInfo.cateName}</option>
        </select>
        <label style="margin-left: 102px;float: left;margin-top: 5px;">设备国别&nbsp;</label>
        <select  class="form-control" style="width:200px;float: left;">
          <option value="${devInfo.countryId}">${devInfo.countryName}</option>
        </select><br>
      </div>
      <div style="margin-left: 50px;">
        <label style="float: left;margin-top: 5px;">设备来源&nbsp;</label>
        <select class="form-control"style="width: 200px;float: left;">
          <option value="${devInfo.originId}">${devInfo.originName}</option>
        </select>
        <label style="margin-left: 102px;float: left;margin-top: 5px;">使用方向&nbsp;</label>
        <select  class="form-control" style="width:200px;float: left;">
          <option value="${devInfo.direcId}">${devInfo.direcName}</option>
        </select><br>
      </div>
      <div style="margin-left: 50px;">
        <label style="float: left;margin-top: 5px;">存放地点&nbsp;</label>
        <select class="form-control"style="width: 200px;float: left;">
          <option value="${devInfo.depositId}">${devInfo.depositName}</option>
        </select>
        <label style="margin-left: 102px;float: left;margin-top: 5px;">经费科目&nbsp;</label>
        <select  class="form-control" style="width:200px;float: left;">
          <option value="${devInfo.foundId}">${devInfo.foundName}</option>
        </select><br>
      </div>
      <div style="margin-left: 50px;">
        <label>生产厂商</label>
        <input style="width: 200px;" value="${devInfo.firm}" readonly="true">
        <label style="margin-left: 100px;">出厂编号</label>
        <input style="width: 200px;" value="${devInfo.outFirmNo}" readonly="true"><br>
      </div>
      <div style="margin-left: 50px;">
        <label>购买时间</label>
        <fmt:formatDate value="${devInfo.purchaseTime}" pattern="yyyy-MM-dd HH:mm"/>
      </div>
    </div>
    <div class="row">
      <div class="breadcrumb">设备维修情况</div>
      <div style="margin-left: 50px;">
        <label>维修数量</label>
        <input style="width: 200px;" value="${maintain.maintainNum}" readonly="true">
        <label style="margin-left: 100px;">维修负责人</label>
        <input style="width: 200px;" value="${maintain.maintainEmp}" readonly="true"><br>
      </div>
      <div style="margin-left: 50px;">
        <label>维修状态</label>
        <input style="width: 200px;" value="${maintain.statusDesc}" readonly="true">
      </div>
    </div>
    <div class="row">
        <div class="breadcrumb">其它信息</div>
      <div style="margin-left: 50px;" >
        <label>创建时间</label>
        <fmt:formatDate value="${maintain.createTime}" pattern="yyyy-MM-dd HH:mm"/>
        <label style="margin-left: 185px;">修改时间</label>
        <fmt:formatDate value="${maintain.modifyTime}" pattern="yyyy-MM-dd HH:mm"/>
      </div>
      <div style="margin-left: 50px;">
        <label>创建人</label>
        <input style="width: 200px;margin-left: 14px;" value="${maintain.createEmpName}" readonly="true">
        <label style="margin-left: 100px;"> 修改人</label>
        <input style="width: 200px;margin-left: 14px;" value="${maintain.modifyEmpName}" readonly="true"><br>
      </div>
      <div style="margin-left: 50px;">
        <label>备注</label><br>
        <textarea readonly="true" style="width: 600px; height: 100px;resize: none;">${maintain.remark}</textarea>
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
</body>
</html>