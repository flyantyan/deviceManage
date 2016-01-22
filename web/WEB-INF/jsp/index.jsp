<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/11/28
  Time: 21:34
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
    <title>实验室设备管理系统--首页</title>
    <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>css/datepicker3.css" rel="stylesheet">
    <link href="<%=basePath%>css/styles.css" rel="stylesheet">
    <link rel="shortcut icon" href="<%=basePath%>images/device.ico"/>

    <!--[if lt IE 9]>
    <script src="<%=basePath%>js/html5shiv.js"></script>
    <script src="<%=basePath%>js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<jsp:include page="/common/top.jsp"/>
<jsp:include page="/common/menu.jsp"/>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="javascript:void(0);"><span class="glyphicon glyphicon-home"></span></a></li>
            <li class="active">首页</li>
        </ol>
    </div>
    <div class="col-md-4" style="margin-left: 710px;">
        <div class="panel panel-red">
            <div class="panel-heading dark-overlay">
                <span class="glyphicon glyphicon-calendar"></span>日历
            </div>
            <div class="panel-body">
                <div id="calendar"></div>
            </div>
        </div>
    </div>
</div>
<!--/.main-->

<script src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script src="<%=basePath%>js/chart.min.js"></script>
<script src="<%=basePath%>js/chart-data.js"></script>
<script src="<%=basePath%>js/easypiechart.js"></script>
<script src="<%=basePath%>js/easypiechart-data.js"></script>
<script src="<%=basePath%>js/bootstrap-datepicker.js"></script>
<script>
    $('#calendar').datepicker({});

    !function ($) {
        $(document).on("click", "ul.nav li.parent > a > span.icon", function () {
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

