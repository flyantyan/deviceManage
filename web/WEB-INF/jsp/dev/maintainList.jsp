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
  <title>实验室设备管理系统--设备维修列表</title>
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
<jsp:include page="/common/top.jsp"/>
<jsp:include page="/common/menu.jsp"/>
<input type="hidden" value="<%=basePath%>" id="basePath">
<input type="hidden" id="maintainId">
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
  <div class="row">
    <ol class="breadcrumb">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span></a></li>
      <li class="active">设备维修列表</li>
    </ol>
  </div>
  <div class="row">
    <div class="col-lg-12">
      <div style="margin-left: 20px;">
        <label>维修编号</label>
        <input id="maintainNo" placeholder="维修编号" style="width: 200px;">
        <label style="margin-left: 50px;">负责人</label>
        <input id="maintainEmp" placeholder="负责人" style="width: 200px;">
        <button onclick="queryMaintainList()" class="btn btn-primary" style="margin-left: 50px;">&nbsp;&nbsp;&nbsp;&nbsp;查询&nbsp;&nbsp;&nbsp;&nbsp;</button>
        <button onclick="" class="btn btn-primary" style="margin-left: 50px;">&nbsp;&nbsp;&nbsp;&nbsp;导出&nbsp;&nbsp;&nbsp;&nbsp;</button>
      </div>
    </div>
  </div><!--/.row-->
  <div class="row">
    <div class="col-lg-12">
      <div class="panel panel-default">
        <div class="panel-heading">
          <input type="button" class="btn btn-default" value="新建" onclick="window.open('<%=basePath%>maintain/toMaintainEdit.do')"/>
          <input type="button" class="btn btn-default" value="详细信息" onclick="showDetail()"/>
          <input type="button" class="btn btn-default" value="允许维修" onclick="updateToMaintain()"/>
          <input type="button" class="btn btn-default" value="维修完成" onclick="updateToMaintainFinish()"/>
          <input type="button" class="btn btn-default" value="刷新" onclick="window.location.reload()"/>
        </div>
        <div class="panel-body">
          <table id="maintainTable" data-toggle="table" data-pagination="true">
            <thead>
            <tr>
              <th data-field="id">选择</th>
              <th data-field="maintainNo">维修编号</th>
              <th data-field="devName">设备名称</th>
              <th data-field="maintainNum">设备数量</th>
              <th data-field="statusDesc">维修状态</th>
              <th data-field="maintainEmp">负责人</th>
              <th data-field="createEmpName">创建人</th>
              <th data-field="createTime">创建时间</th>
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
<script src="<%=basePath%>js/bootstrap-datepicker.js"></script>
<script src="<%=basePath%>js/bootstrap-table.js"></script>
<script src="<%=basePath%>js/maintain.js"></script>
</body>

</html>
