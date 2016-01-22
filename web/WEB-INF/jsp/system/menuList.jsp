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
  <title>实验室设备管理系统--菜单列表</title>
  <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=basePath%>css/datepicker3.css" rel="stylesheet">
  <link href="<%=basePath%>css/styles.css" rel="stylesheet">
  <link rel="shortcut icon" href="<%=basePath%>images/device.ico" />

  <!--[if lt IE 9]>
  <script src="<%=basePath%>js/html5shiv.js"></script>
  <script src="<%=basePath%>js/respond.min.js"></script>
  <![endif]-->
  <script>
    function showUl(obj){
      if($("#ul"+obj).is(":hidden")){
        $("#ul"+obj).show();
      }else{
        $("#ul"+obj).hide();
      }
    }
    function clickMenu(obj){
      $("#menuId").val(obj.value);
    }
  </script>
</head>
<body>
  <jsp:include page="/common/top.jsp"/>
  <jsp:include page="/common/menu.jsp"/>
  <input type="hidden" value="<%=basePath%>" id="basePath">
  <input type="hidden" id="menuId">
  <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
      <ol class="breadcrumb">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span></a></li>
        <li class="active">系统菜单列表</li>
      </ol>
    </div>
    <div class="row">
      <div class="col-lg-12">
        <div class="panel panel-default">
          <div class="panel-heading">
            <input type="button" value="分配" class="btn btn-default" onclick="allot()"/>
            <input type="button" value="删除" class="btn btn-default" onclick="delMenu()"/>
          </div>
          <ul style="list-style-type:none;">
            <c:forEach items="${menu}" var="m">
              <c:if test="${m.value!=null}">
                  <li onclick="showUl(${m.key.menuId})"><input type="radio" name="menu" value="${m.key.menuId}" onclick="clickMenu(this)"/>${m.key.menuName}</li>
              </c:if>
              <c:if test="${m.value!=null}">
                 <ul id="ul${m.key.menuId}" style="list-style-type:none;">
                    <c:forEach items="${m.value}" var="m1">
                      <li><input type="radio" name="menu" value="${m1.menuId}" onclick="clickMenu(this)"/>${m1.menuName}</li>
                    </c:forEach>
                 </ul>
              </c:if>
            </c:forEach>
          </ul>
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
  <script>
      function allot(){
          var menuId=$("#menuId").val();
          var basePath=$("#basePath").val();
          if(menuId==""){
            alert("请选择要操作的菜单");
            return;
          }
      }
      function delMenu(){
          var menuId=$("#menuId").val();
          if(menuId==""){
            alert("请选择要操作的菜单");
            return;
          }
          alert("系统暂不支持删除菜单，请联系管理员!")
      }
  </script>
</body>
</html>
