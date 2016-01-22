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
<jsp:include page="/common/top.jsp"/>
<jsp:include page="/common/menu.jsp"/>
<input type="hidden" value="<%=basePath%>" id="basePath">
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
  <div class="row">
    <ol class="breadcrumb">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span></a></li>
      <li class="active">用户列表</li>
    </ol>
  </div>
  <div class="row">
    <div class="col-lg-12" style="margin-left: 20px;">
      <label style="float: left;margin-top: 7px;">姓名</label>
      <input id="queryRealName" placeholder="真实姓名" style="float: left;margin-top: 5px;margin-left: 5px;">
      <label style="margin-left: 50px;margin-top: 5px;float: left;">用户角色&nbsp;</label>
      <select  id="queryRole" class="form-control" style="margin-left: 5px;width:200px;float: left;">
        <option value="0">-------请选择-------</option>
        <option value="1">学生</option>
        <option value="2">教师1</option>
        <option value="3">教师2</option>
        <option value="4">系统管理员</option>
      </select>
      <button onclick="queryUserList()" class="btn btn-primary" style="margin-left: 50px;float: left;">&nbsp;&nbsp;查询&nbsp;&nbsp;</button>
      <button onclick="downloadUser()" class="btn btn-primary" style="margin-left: 50px;float: left;">&nbsp;&nbsp;导出&nbsp;&nbsp;</button>
    </div>
  </div><!--/.row-->
  <div class="row">
    <div class="col-lg-12">
      <div class="panel panel-default">
        <div class="panel-heading">
          <input type="button" class="btn btn-default" value="新增" onclick="toCreateUser()"/>
          <input type="button" class="btn btn-default" value="删除" onclick="delUserById()"/>
          <input type="button" class="btn btn-default" value="重置密码" onclick="resetPwd()"/>
          <input type="button" class="btn btn-default" value="申请列表" onclick="queryApplyListByEmpId()"/>
        </div>
        <div class="panel-body">
          <table id="userTable" data-toggle="table" data-pagination="true">
            <thead>
            <tr>
              <th data-field="id">选择</th>
              <th data-field="userName">用户名</th>
              <th data-field="realName">真实姓名</th>
              <th data-field="sexDesc">性别</th>
              <th data-field="roleDesc">角色</th>
              <th data-field="userTel">电话</th>
              <th data-field="createEmpName">创建人</th>
              <th data-field="modifyEmpName">修改人</th>
              <th data-field="createTime">创建时间</th>
              <th data-field="modifyTime">修改时间</th>
            </tr>
            </thead>
          </table>
        </div>
      </div>
    </div>
  </div><!--/.row-->
</div>
<!--/.main-->
<input id="userId">
<script src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script src="<%=basePath%>js/chart.min.js"></script>
<script src="<%=basePath%>js/chart-data.js"></script>
<script src="<%=basePath%>js/easypiechart.js"></script>
<script src="<%=basePath%>js/easypiechart-data.js"></script>
<script src="<%=basePath%>js/bootstrap-datepicker.js"></script>
<script src="<%=basePath%>js/bootstrap-table.js"></script>
<script src="<%=basePath%>js/userEdit.js"></script>
<script>
  !function ($) {
    $(document).on("click","ul.nav li.parent > a > span.icon", function(){
      $(this).find('em:first').toggleClass("glyphicon-minus");
    });
    $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
  }(window.jQuery);

  $(window).on('resize', function () {
    if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
  })
  $(window).on('resize', function () {
    if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
  })
</script>
</body>

</html>
