<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/11/28
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>实验室设备管理系统--登陆</title>

  <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=basePath%>css/datepicker3.css" rel="stylesheet">
  <link href="<%=basePath%>css/styles.css" rel="stylesheet">
  <link rel="shortcut icon" href="<%=basePath%>images/device.ico" />
  <script src="<%=basePath%>js/html5shiv.js"></script>
  <script src="<%=basePath%>js/respond.min.js"></script>
  <script style="javascript" charset="utf-8">
    function doLogin(){
        if($("#userName").val()==""||$("#userPwd").val()==""){
            document.getElementById("tip1").style.display="block";
            return;
        }
        document.loginForm.submit();
    }
    function removeTip(){
      document.getElementById("tip1").style.display="none";
      document.getElementById("tip2").style.display="none";
    }
  </script>
</head>

<body>

<div class="row">
  <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
    <div class="login-panel panel panel-default">
      <div class="panel-heading">实验室设备管理系统--欢迎使用</div>
      <div class="panel-body">
        <form role="form" name="loginForm" method="post" action="<%=basePath%>user/login.do">
          <fieldset>
            <div class="form-group">
              <input id="userName" class="form-control" placeholder="用户名" name="userName"
                     onfocus="removeTip()">
            </div>
            <div class="form-group">
              <input id="userPwd" class="form-control" placeholder="密码" name="userPwd" type="password"
                     onfocus="removeTip()">
            </div>
            <a href="javascript:doLogin();" class="btn btn-primary" style="float: left;">登陆</a>
            <div id="tip1" style="color: red;float: left;margin: 8px 30px;display: none;">提示:用户名或密码不能为空！</div>
            <div id="tip2" style="color: red;float: left;margin: 8px 30px;">${msg}</div>
            <div style="clear: both;"></div>
          </fieldset>
        </form>
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
