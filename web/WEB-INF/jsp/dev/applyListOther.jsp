<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/12/24
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>实验室设备管理系统--设备申请列表</title>
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
  <div class="row">
    <div class="col-lg-12">
      <div class="panel panel-default">
        <div class="panel-body">
          <table id="applyTable" data-toggle="table" data-pagination="false">
            <thead>
            <tr>
              <th>申请编号</th>
              <th>申请人</th>
              <th>处理人</th>
              <th>申请状态</th>
              <th>申请时间</th>
              <th>处理时间</th>
            </tr>
            </thead>
            <c:forEach items="${applyList}" var="apply">
              <tr>
                <td>${apply.applyNo}</td>
                <td>${apply.applyEmpName}</td>
                <td>${apply.dealEmpName}</td>
                <td>${apply.statusDesc}</td>
                <td><fmt:formatDate value="${apply.applyTime}" pattern="yyyy-MM-dd HH:mm"/></td>
                <td><fmt:formatDate value="${apply.dealTime}" pattern="yyyy-MM-dd HH:mm"/></td>
              </tr>
            </c:forEach>

          </table>
        </div>
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
