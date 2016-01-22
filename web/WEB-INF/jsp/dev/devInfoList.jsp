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
  <title>实验室设备管理系统--设备基本信息列表</title>
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
<input type="hidden" id="devInfoId">
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
  <div class="row">
    <ol class="breadcrumb">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span></a></li>
      <li class="active">设备基本信息列表</li>
    </ol>
  </div>
  <div class="row">
    <div class="col-lg-12">
      <div style="margin-left: 50px;">
        <label>设备编号</label>
        <input id="devNo" placeholder="设备编号" style="width: 200px;">
        <label style="margin-left: 300px;">设备名称</label>
        <input id="devName" placeholder="设备名称" style="width: 200px;"><br>
      </div>
      <div style="margin-left: 50px;">
        <label style="float: left;margin-top: 5px;">设备类别&nbsp;</label>
        <select id="cateId" class="form-control" style="width: 200px;float: left;">
          <option value="0">-------请选择-------</option>
          <c:forEach items="${applicationScope.categoryList}" var="cate">
            <option value="${cate.id}">${cate.cateName}</option>
          </c:forEach>
        </select>
        <label style="margin-left: 305px;float: left;margin-top: 5px;">设备国别&nbsp;</label>
        <select  id="countryId" class="form-control" style="width:200px;float: left;">
          <option value="0">-------请选择-------</option>
          <c:forEach items="${applicationScope.countryList}" var="country">
            <option value="${country.id}">${country.countryName}</option>
          </c:forEach>
        </select>
        <div style="clear: both;"/>
      </div>
      <div>
        <label style="float: left;margin-top: 5px;">设备来源&nbsp;</label>
        <select id="originId" class="form-control" style="width: 200px;float: left;">
          <option value="0">-------请选择-------</option>
          <c:forEach items="${applicationScope.originList}" var="origin">
            <option value="${origin.id}">${origin.originName}</option>
          </c:forEach>
        </select>
        <label style="margin-left: 305px;float: left;margin-top: 5px;">设备存放地&nbsp;</label>
        <select  id="depositId" class="form-control" style="width:187px;float: left;">
          <option value="0">-------请选择-------</option>
          <c:forEach items="${applicationScope.depositList}" var="deposit">
            <option value="${deposit.id}">${deposit.depositName}</option>
          </c:forEach>
        </select>
        <div style="clear: both;"/>
      </div>
      <div style="margin-left: 280px;">
        <button onclick="queryDevInfoList()" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;查询&nbsp;&nbsp;&nbsp;&nbsp;</button>
        <button onclick="downloadDevInfo()" class="btn btn-primary" style="margin-left: 100px;">&nbsp;&nbsp;&nbsp;&nbsp;导出&nbsp;&nbsp;&nbsp;&nbsp;</button>
      </div>
    </div>
  </div><!--/.row-->
  <div class="row">
    <div class="col-lg-12">
      <div class="panel panel-default">
        <div class="panel-heading">
          <input type="button" class="btn btn-default" value="详细信息" onclick="devInfoDetail()"/>
          <input type="button" class="btn btn-default" value="修改" onclick="toDevInfoUpdate()"/>
          <input type="button" class="btn btn-default" value="设备入库" onclick="toDevInfoCreate()"/>
          <input type="button" class="btn btn-default" value="批量导入"/>
        </div>
        <div class="panel-body">
          <table id="devInfoTable" data-toggle="table" data-pagination="true">
            <thead>
            <tr>
              <th data-field="id">选择</th>
              <th data-field="devNo">设备编号</th>
              <th data-field="barCode">设备条形码</th>
              <th data-field="devName">设备名称</th>
              <th data-field="modelNo">设备型号</th>
              <th data-field="standard">设备规格</th>
              <th data-field="cateName">类别</th>
              <th data-field="countryName">国别</th>
              <th data-field="originName">来源</th>
              <th data-field="depositName">存放地</th>
              <th data-field="devSum">总数量</th>
            </tr>
            </thead>
          </table>
        </div>
      </div>
    </div>
  </div><!--/.row-->
</div>
<!--/.main-->
<script src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script src="<%=basePath%>js/chart.min.js"></script>
<script src="<%=basePath%>js/chart-data.js"></script>
<script src="<%=basePath%>js/easypiechart.js"></script>
<script src="<%=basePath%>js/easypiechart-data.js"></script>
<script src="<%=basePath%>js/bootstrap-datepicker.js"></script>
<script src="<%=basePath%>js/bootstrap-table.js"></script>
<script src="<%=basePath%>js/devInfo.js"></script>
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
