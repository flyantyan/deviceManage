<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/11/29
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
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
  <title>实验室设备管理系统--用户列表</title>
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
<button type="submit" class="btn btn-primary" style="margin-left: 75%;" onclick="save()">&nbsp;&nbsp;保存&nbsp;&nbsp;</button>
<button type="submit" class="btn btn-primary" onclick="window.close();">&nbsp;&nbsp;关闭&nbsp;&nbsp;</button>
<input type="hidden" value="<%=basePath%>" id="basePath">
<input type="hidden" id="userId">
<input type="hidden" id="menuId" value="${menuId}">
  <div class="row">
    <div class="col-lg-12">
      <div class="panel panel-default">
        <div class="panel-body">
          <table id="userTable" data-toggle="table" data-pagination="true">
            <thead>
            <tr>
              <th data-field="id">编号</th>
              <th data-field="userName">用户名</th>
              <th data-field="realName">真实姓名</th>
              <th data-field="sexDesc">性别</th>
              <th data-field="roleDesc">角色</th>
              <th data-field="userTel">电话</th>
            </tr>
            </thead>
            <c:forEach items="${userList}" var="user">
              <tr>
                <td><input type="radio" name="userId" value="${user.id}" onclick="document.getElementById('userId').value=this.value;"></td>
                <td>${user.id}</td>
                <td>${user.realName}</td>
                <td>${user.sexDesc}</td>
                <td>${user.roleDesc}</td>
                <td>${user.userTel}</td>
              </tr>
            </c:forEach>
          </table>
        </div>
      </div>
    </div>
  </div><!--/.row-->
<!--/.main-->
<input type="hidden" id="userId">
<script src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script src="<%=basePath%>js/chart.min.js"></script>
<script src="<%=basePath%>js/chart-data.js"></script>
<script src="<%=basePath%>js/easypiechart.js"></script>
<script src="<%=basePath%>js/easypiechart-data.js"></script>
<script src="<%=basePath%>js/bootstrap-datepicker.js"></script>
<script src="<%=basePath%>js/bootstrap-table.js"></script>
<script>
    function save(){
        var basePath=$("#basePath").val();
        var userId=$("#userId").val();
        var menuId=$("#menuId").val();
        if(userId==""){
            alert("请选择要分配的用户!")
            return;
        }
      $.ajax({
        type:"POST",
        url:basePath+"system/allotMenu.do",
        data:{userId:userId,menuId:menuId},
        async:false,
        error:function(){
          alert("菜单权限分配失败，服务器内部错误");
        },
        success:function(data){
          if(data=="1"){
            alert("菜单权限分配成功!");
            window.close();
          }else{
            alert("菜单权限分配失败，请稍后再试");
          }
        }
      })
    }
</script>
</body>

</html>
