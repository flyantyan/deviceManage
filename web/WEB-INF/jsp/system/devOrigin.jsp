<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/12/16
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>实验室设备管理系统--设备来源列表</title>
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
<input type="hidden" id="originId">
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
  <div class="row">
    <ol class="breadcrumb">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span></a></li>
      <li class="active">设备来源列表</li>
    </ol>
  </div>
  <div class="row">
    <div class="col-lg-12">
      <div class="panel panel-default">
        <div class="panel-heading">
          <input type="button" class="btn btn-default" value="新增" onclick="toAddOrigin()"/>
          <input type="button" class="btn btn-default" value="删除" onclick="delOrigin()"/>
          <input type="button" class="btn btn-default" value="刷新" onclick="window.location.reload()"/>
        </div>
        <div class="panel-body">
          <table id="priginTable" data-toggle="table" data-pagination="true">
            <thead>
              <tr>
                <th>选择</th>
                <th>编号</th>
                <th>来源名称</th>
                <th>创建人</th>
                <th>修改人</th>
                <th>创建时间</th>
                <th>修改时间</th>
              </tr>
            </thead>
            <c:forEach items="${applicationScope.originList}" var="origin">
              <tr>
                  <td><input type="radio" name="originId" value="${origin.id}" onclick="document.getElementById('originId').value=this.value;"></td>
                  <td>${origin.originNo}</td>
                  <td>${origin.originName}</td>
                  <td>${origin.createEmpName}</td>
                  <td>${origin.modifyEmpName}</td>
                  <td><fmt:formatDate value="${origin.createTime}" pattern="yyyy-MM-dd HH:mm"/></td>
                  <td><fmt:formatDate value="${origin.modifyTime}" pattern="yyyy-MM-dd HH:mm"/></td>
              </tr>
            </c:forEach>
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
<script>
  function toAddOrigin(){
    var bathPath=$("#basePath").val();
    window.open(bathPath+"common/toAddSystemParam.do?toUrl=system/addOrigin.do&systemParamName=设备来源",
            'newwindow', 'width=500,height=500, top=50, left=50,toolbar=no, menubar=no, scrollbars=yes, ' +
            'resizable=yes, location=no, status=no,left=460px');
  }
  function delOrigin(){
    var basePath=$("#basePath").val();
    var originId=$("#originId").val();
    if(originId==""){
      alert("请选择要操作行！");
      return;
    }
    if(!confirm("确定要删除该行吗？")){
       return;
    }
    $.ajax({
      type:"POST",
      url:basePath+"system/delOrigin.do",
      data:{originId:originId},
      async:false,
      error:function(){
        alert("删除失败，服务器内部错误");
      },
      success:function(data){
        if(data=="1"){
          alert("删除成功");
          window.location.reload();
        }else{
          alert("删除失败，请稍后再试");
        }
      }
    })
  }
</script>
</body>

</html>