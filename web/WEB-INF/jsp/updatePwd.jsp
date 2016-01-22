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
  <title>实验室设备管理系统--修改密码</title>
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
<button type="submit" class="btn btn-primary" style="margin-left: 350px;" onclick="updatePwd()">&nbsp;&nbsp;保存&nbsp;&nbsp;</button>
<button type="submit" class="btn btn-primary" onclick="window.close();">&nbsp;&nbsp;关闭&nbsp;&nbsp;</button>
  <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
      <div style="margin-left: 50px;">
        <label>旧密码:</label>
        <input id="oldPwd01" type="password" style="width: 200px;">
      </div>
      <div style="margin-left: 50px;">
        <label>新密码:</label>
        <input id="newPwd01" type="password" style="width: 200px;">
      </div>
      <div style="margin-left: 50px;">
        <label>新密码:</label>
        <input id="newPwd02" type="password" style="width: 200px;">
      </div>
    </div>
  </div>
<input id="oldPwd" type="hidden" value="${sessionScope.user.userPwd}">
<input type="hidden" value="<%=basePath%>" id="basePath">
<script src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script src="<%=basePath%>js/chart.min.js"></script>
<script src="<%=basePath%>js/chart-data.js"></script>
<script src="<%=basePath%>js/easypiechart.js"></script>
<script src="<%=basePath%>js/easypiechart-data.js"></script>
<script src="<%=basePath%>js/bootstrap-datepicker.js"></script>
<script src="<%=basePath%>js/bootstrap-table.js"></script>
<script src="<%=basePath%>js/JQuery.md5.js"></script>
<script>
  function updatePwd(){
    var basePath=$("#basePath").val();
    var oldPwd=$("#oldPwd").val();
    var oldPwd01=$("#oldPwd01").val();
    var newPwd01=$("#newPwd01").val();
    var newPwd02=$("#newPwd02").val();
    if(oldPwd01==""){
        alert("旧密码不能为空!")
        return;
    }
    if(oldPwd!= b64_md5(oldPwd01)+"=="){
        alert("旧密码不正确,请重新输入!");
        return;
    }
    if(newPwd01==""||newPwd02==""){
        alert("新密码不能为空!");
        return;
    }
    if(newPwd01!=newPwd02){
       alert("两次输入的新密码不一致，请重新输入!");
       return;
    }
    if(!confirm("确认要修改密码吗?")){
        return;
    }
    $.ajax({
      type:"POST",
      url:basePath+"user/updatePwd.do",
      data:{pwd:newPwd02},
      async:false,
      error:function(){
        alert("系统内部错误，请稍后再试");
      },
      success:function(data){
        if(data=="1"){
          alert("密码修改成功!")
          window.close();
        }else{
          alert("密码修改失败，请稍后再试!");
          window.close();
        }
      }
    })
  }
</script>
</body>
</html>
