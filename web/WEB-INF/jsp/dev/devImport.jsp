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
  <title>实验室设备管理系统--设备批量导入</title>
  <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=basePath%>css/styles.css" rel="stylesheet">
  <link rel="shortcut icon" href="<%=basePath%>images/device.ico" />
</head>
<body>
  <jsp:include page="/common/topNonUserSymbal.jsp"/>
  <input type="hidden" id="basePath" value="<%=basePath%>">

  <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div id="applyItem">
      <div class="row">
        <div class="breadcrumb">请选择要导入的文件</div>
        <form id="importDevForm" method="post" action="<%=basePath%>devInfo/importDevInfo.do"
              enctype="multipart/form-data" target="_iframe">
          <input type="file" name="devInfoFile">
        </form>
        <button type="submit" class="btn btn-primary" style="margin-left: 70%;" onclick="toSubmit()">&nbsp;&nbsp;导入&nbsp;&nbsp;</button>
      </div>
      <iframe name="_iframe" id="_iframe" width="0" height="0">
      </iframe>
    </div>
  </div>
<script src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script src="<%=basePath%>js/bootstrap-table.js"></script>
  <script>
    function toSubmit(){
      $("#importDevForm").submit();
    }
    function callBack(msg){
      if(msg=="success"){
        alert("批量设备信息已成功导入");
        window.close();
      }else{
        alert("导入失败，"+msg);
      }
    }
  </script>
</body>
</html>