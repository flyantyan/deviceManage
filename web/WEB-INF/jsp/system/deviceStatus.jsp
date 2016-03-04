<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/12/10
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>实验室设备管理系统--设备现状</title>
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
  <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
      <ol class="breadcrumb">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span></a></li>
        <li class="active">设备现状</li>
      </ol>
    </div>
    <div class="row">
      <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="col-md-6" style="width: 80%">
                <div class="panel panel-default">
                    <div class="panel-heading">设备现状百分比图</div>
                    <div class="panel-body">
                        <div class="canvas-wrapper">
                            <canvas class="chart" id="doughnut-chart"></canvas>
                        </div>
                        <div style="margin-top: 50px;margin-left: 140px;">
                            <span style="background-color: #30a5ff;height: 20px;">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </span>&nbsp;&nbsp;&nbsp;借出设备
                            <span style="background-color: #ffb53e;height: 20px;">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </span>&nbsp;&nbsp;&nbsp;报废设备
                            <span style="background-color: #1ebfae;height: 20px;">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </span>&nbsp;&nbsp;&nbsp;维修设备
                            <span style="background-color: #f9243f;height: 20px;">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </span>&nbsp;&nbsp;&nbsp;库存设备
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6" style="width: 20%;height: auto;">
                <div class="panel panel-default">
                    <div class="panel-heading">设备使用情况</div>
                    <div class="panel-body">
                        <div class="canvas-wrapper">
                            设备总数量：${devStatus.devNum}<br>
                            设备库存量：${devStatus.devNum-devStatus.applyNum-devStatus.maintainNum-devStatus.dumpNum}<br>
                            设备借出量：${devStatus.applyNum}<br>
                            设备维修量：${devStatus.maintainNum}<br>
                            设备报废量：${devStatus.dumpNum}<br>
                        </div>
                    </div>
                </div>
            </div>
        </div>
      </div>
    </div>
  </div>
  <input type="hidden" id="applyNum" value="${devStatus.applyNum}">
  <input type="hidden" id="maintainNum" value="${devStatus.maintainNum}">
  <input type="hidden" id="dumpNum" value="${devStatus.dumpNum}">
  <input type="hidden" id="residueNum" value="${devStatus.devNum-devStatus.applyNum-devStatus.maintainNum-devStatus.dumpNum}">
  <script src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
  <script src="<%=basePath%>js/bootstrap.min.js"></script>
  <script src="<%=basePath%>js/chart.min.js"></script>
  <script src="<%=basePath%>js/chart-data.js"></script>
  <script src="<%=basePath%>js/easypiechart.js"></script>
  <script src="<%=basePath%>js/easypiechart-data.js"></script>
  <script src="<%=basePath%>js/bootstrap-datepicker.js"></script>
</body>
</html>
