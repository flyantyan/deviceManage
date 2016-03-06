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
  <title>实验室设备管理系统--设备申请编辑</title>
  <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=basePath%>css/styles.css" rel="stylesheet">
  <link rel="shortcut icon" href="<%=basePath%>images/device.ico" />
</head>
<body>
  <jsp:include page="/common/topNonUserSymbal.jsp"/>
  <input type="hidden" id="basePath" value="<%=basePath%>">
  <button type="submit" class="btn btn-primary" style="margin-left: 85%;" onclick="saveApply()">&nbsp;&nbsp;保存&nbsp;&nbsp;</button>
  <button type="submit" class="btn btn-primary" onclick="window.close();">&nbsp;&nbsp;关闭&nbsp;&nbsp;</button>
  <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div id="applyItem">
      <div class="row">
        <input type="hidden" id="devId1" name="devId">
        <div class="breadcrumb">申请设备1</div>
        <div style="margin-left: 50px;">
          <label>设备编号</label>
          <input id="devNo1" style="width: 200px;">
          <a href="javascript:findDevInfo(1)" >加载</a>
          <label style="margin-left: 150px;">设备名称</label>
          <input id="devName1" style="width: 200px;" readonly="true"><br>
        </div>
        <div style="margin-left: 50px;">
          <label>设备型号</label>
          <input id="modelNo1" style="width: 200px;" readonly="true">
          <label style="margin-left: 183px;">设备规格</label>
          <input id="standard1" style="width: 200px;" readonly="true"><br>
        </div>
        <div style="margin-left: 50px;">
          <label>设备类别</label>
          <input id="cate1" style="width: 200px;" readonly="true">
          <label style="margin-left: 183px;">设备国别</label>
          <input id="country1" style="width: 200px;" readonly="true"><br>
        </div>
        <div style="margin-left: 50px;">
          <label>设备来源</label>
          <input id="origin1" style="width: 200px;" readonly="true">
          <label style="margin-left: 183px;">使用方向</label>
          <input id="direct1" style="width: 200px;" readonly="true"><br>
        </div>
        <div style="margin-left: 50px;">
          <label>申请数量</label>
          <input id="applyNum1" style="width: 200px;"><br>
        </div>
      </div>
      <div class="row">
        <input type="hidden" id="devId2" name="devId">
        <div class="breadcrumb">申请设备2</div>
        <div style="margin-left: 50px;">
          <label>设备编号</label>
          <input id="devNo2" style="width: 200px;">
          <a href="javascript:findDevInfo(2)" >加载</a>
          <label style="margin-left: 150px;">设备名称</label>
          <input id="devName2" style="width: 200px;" readonly="true"><br>
        </div>

        <div style="margin-left: 50px;">
          <label>设备型号</label>
          <input id="modelNo2" style="width: 200px;" readonly="true">
          <label style="margin-left: 183px;">设备规格</label>
          <input id="standard2" style="width: 200px;" readonly="true"><br>
        </div>
        <div style="margin-left: 50px;">
          <label>设备类别</label>
          <input id="cate2" style="width: 200px;" readonly="true">
          <label style="margin-left: 183px;">设备国别</label>
          <input id="country2" style="width: 200px;" readonly="true"><br>
        </div>
        <div style="margin-left: 50px;">
          <label>设备来源</label>
          <input id="origin2" style="width: 200px;" readonly="true">
          <label style="margin-left: 183px;">使用方向</label>
          <input id="direct2" style="width: 200px;" readonly="true"><br>
        </div>
        <div style="margin-left: 50px;">
          <label>申请数量</label>
          <input id="applyNum2" style="width: 200px;"><br>
        </div>
      </div>
    </div>
    <div class="row">
      <span style="margin-left: 70%"><a href="javascript:addApplyItem()">增加>></a></span>
    </div>
    <div class="row">
      <div class="breadcrumb">设备申请信息填写</div>
      <div style="margin-left: 50px;">
        <label>申请理由</label><br>
        <textarea id="applyText" style="width: 600px; height: 100px;resize: none;"></textarea>
      </div>
      <div style="margin-left: 50px;">
        <label>备注</label><br>
        <textarea id="remark" style="width: 600px; height: 100px;resize: none;"></textarea>
      </div>
    </div>
  </div>
<script src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script src="<%=basePath%>js/bootstrap-table.js"></script>
<script src="<%=basePath%>js/apply.js"></script>
</body>
</html>