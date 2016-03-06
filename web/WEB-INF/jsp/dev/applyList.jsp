<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>实验室设备管理系统--设备申请列表</title>
  <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=basePath%>css/datepicker3.css" rel="stylesheet">
  <link href="<%=basePath%>css/styles.css" rel="stylesheet">
  <link rel="shortcut icon" href="<%=basePath%>images/device.ico" />
</head>
<body>
<jsp:include page="/common/top.jsp"/>
<jsp:include page="/common/menu.jsp"/>
<input type="hidden" value="<%=basePath%>" id="basePath">
<input type="hidden" id="applyId">
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
  <div class="row">
    <ol class="breadcrumb">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span></a></li>
      <li class="active">设备申请列表</li>
    </ol>
  </div>
  <div class="row">
    <div class="col-lg-12">
      <div style="margin-left: 20px;">
        <label>申请编号</label>
        <input id="applyNo" placeholder="申请编号" style="width: 200px;">
        <label style="margin-left: 50px;">申请人</label>
        <input id="applyEmpName" placeholder="申请人" style="width: 200px;">
        <button onclick="queryApplyList()" class="btn btn-primary" style="margin-left: 50px;">&nbsp;&nbsp;&nbsp;&nbsp;查询&nbsp;&nbsp;&nbsp;&nbsp;</button>
      </div>
    </div>
  </div><!--/.row-->
  <div class="row">
    <div class="col-lg-12">
      <div class="panel panel-default">
        <div class="panel-heading">
          <input type="button" class="btn btn-default" value="详细信息" onclick="queryApplyDetail()"/>
          <input type="button" class="btn btn-default" value="新建" onclick="window.open('<%=basePath%>apply/toApplyCreate.do')"/>
          <input type="button" class="btn btn-default" value="审核" onclick="toApplyReview()"/>
          <input type="button" class="btn btn-default" value="借出" onclick="lend()"/>
          <input type="button" class="btn btn-default" value="归还" onclick="revert()"/>
        </div>
        <div class="panel-body">
          <table id="applyTable" data-toggle="table" data-pagination="true">
            <thead>
            <tr>
              <th data-field="id">选择</th>
              <th data-field="applyNo">申请编号</th>
              <th data-field="applyEmpName">申请人</th>
              <th data-field="dealEmpName">处理人</th>
              <th data-field="statusDesc">申请状态</th>
              <th data-field="applyTime">申请时间</th>
              <th data-field="dealTime">处理时间</th>
            </tr>
            </thead>
          </table>
        </div>
      </div>
    </div>
  </div><!--/.row-->
</div>
<!--/.main-->
<script src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script src="<%=basePath%>js/bootstrap-table.js"></script>
<script src="<%=basePath%>js/apply.js"></script>
</body>

</html>
