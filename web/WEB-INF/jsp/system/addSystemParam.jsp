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
  <title>实验室设备管理系统--系统参数编辑</title>
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
<jsp:include page="/common/topNonUserSymbal01.jsp"/>
<input type="hidden" value="<%=basePath%>" id="basePath">
<input type="hidden" value="${toUrl}" id="toUrl">
<button type="submit" class="btn btn-primary" style="margin-left: 350px;" onclick="addSystemParam()">&nbsp;&nbsp;保存&nbsp;&nbsp;</button>
<button type="submit" class="btn btn-primary" onclick="window.close()">&nbsp;&nbsp;关闭&nbsp;&nbsp;</button>
  <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
      <div style="margin-left: 60px;margin-top: 30px;">
        <label>请输入${systemParamName}名字:</label>
        <input name="systemParamName" id="systemParamName" style="width: 200px;margin-left: 14px;">
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
<script>
  function addSystemParam(){
    var basePath=$("#basePath").val();
    var toUrl=$("#toUrl").val();
    var sysName=$("#systemParamName").val();
    if(sysName==""){
        alert("输入信息不能为空!");
        return;
    }
    $.ajax({
      type:"POST",
      url:basePath+toUrl,
      data:{systemParamName:sysName},
      async:false,
      error:function(){
        alert("添加失败，服务器内部错误");
      },
      success:function(data){
        if(data=="1"){
          alert("添加成功");
          window.close();
        }else{
          alert("添加失败，请稍后再试");
        }
      }
    })
  }
</script>
</body>
</html>
