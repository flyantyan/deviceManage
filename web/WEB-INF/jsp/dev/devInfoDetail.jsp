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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>实验室设备管理系统--设备详情</title>
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
  <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <div class="breadcrumb">设备基本信息</div>
        <div style="margin-left: 50px;">
          <label>设备编号</label>
          <input id="devNo" style="width: 200px;" value="${devInfo.devNo}" readonly="true">
          <label style="margin-left: 100px;">设备名称</label>
          <input id="devName" style="width: 200px;" value="${devInfo.devName}" readonly="true"><br>
        </div>
        <div style="margin-left: 50px;">
          <label>条形码</label>
          <input id="barCode" style="width: 200px;margin-left: 14px;" value="${devInfo.barCode}" readonly="true">
          <label style="margin-left: 100px;">设备权限</label>
          <input id="devPower" style="width: 200px;" value="${devInfo.devPower}" readonly="true"><br>
        </div>
      <div style="margin-left: 50px;">
        <label>设备型号</label>
        <input id="modelNo" style="width: 200px;" value="${devInfo.modelNo}" readonly="true">
        <label style="margin-left: 100px;">设备规格</label>
        <input id="standard" style="width: 200px;" value="${devInfo.standard}" readonly="true"><br>
      </div>
      <div style="margin-left: 50px;">
        <label style="float: left;margin-top: 5px;">设备类别&nbsp;</label>
        <select id="cateId" class="form-control"style="width: 200px;float: left;">
          <option value="${devInfo.cateId}">${devInfo.cateName}</option>
        </select>
        <label style="margin-left: 102px;float: left;margin-top: 5px;">设备国别&nbsp;</label>
        <select  id="countryId" class="form-control" style="width:200px;float: left;">
          <option value="${devInfo.countryId}">${devInfo.countryName}</option>
        </select>
      </div>
      <div style="margin-left: 50px;">
        <label style="float: left;margin-top: 5px;">设备来源&nbsp;</label>
        <select id="originId" class="form-control"style="width: 200px;float: left;">
          <option value="${devInfo.originId}">${devInfo.originName}</option>
        </select>
        <label style="margin-left: 102px;float: left;margin-top: 5px;">使用方向&nbsp;</label>
        <select  id="direcId" class="form-control" style="width:200px;float: left;">
          <option value="${devInfo.direcId}">${devInfo.direcName}</option>
        </select>
      </div>
      <div style="margin-left: 50px;">
        <label style="float: left;margin-top: 5px;">存放地点&nbsp;</label>
        <select id="depositId" class="form-control"style="width: 200px;float: left;">
          <option value="${devInfo.depositId}">${devInfo.depositName}</option>
        </select>
        <label style="margin-left: 102px;float: left;margin-top: 5px;">经费科目&nbsp;</label>
        <select  id="subId" class="form-control" style="width:200px;float: left;">
          <option value="${devInfo.foundId}">${devInfo.foundName}</option>
        </select>
      </div>
      <div style="margin-left: 50px;">
        <label>生产厂商</label>
        <input id="firm" style="width: 200px;" value="${devInfo.firm}" readonly="true">
        <label style="margin-left: 100px;">出厂编号</label>
        <input id="outFirmNo" style="width: 200px;" value="${devInfo.outFirmNo}" readonly="true"><br>
      </div>
      <div style="margin-left: 50px;">
        <label>购买时间</label>
        <fmt:formatDate value="${devInfo.purchaseTime}" pattern="yyyy-MM-dd HH:mm"/>
      </div>
    </div>
    <div class="row">
      <div class="breadcrumb">设备使用情况</div>
      <div style="margin-left: 50px;">
        <label>设备总量</label>
        <input id="devNum" style="width: 200px;" value="${devInfo.devSum}" readonly="true">
        <label style="margin-left: 100px;">借出数量</label>
        <input id="devApplyNum" style="width: 200px;" value="${devInfo.lendNum}" readonly="true"><br>
      </div>
      <div style="margin-left: 50px;">
        <label>维修数量</label>
        <input id="maintainNum" style="width: 200px;" value="${devInfo.maintainNum}" readonly="true">
        <label style="margin-left: 100px;">报废数量</label>
        <input id="dumpNum" style="width: 200px;" value="${devInfo.dumpNum}" readonly="true"><br>
      </div>
    </div>
    <div class="row">
        <div class="breadcrumb">其它信息</div>
      <div style="margin-left: 50px;" >
        <label>入库时间</label>
        <fmt:formatDate value="${devInfo.createTime}" pattern="yyyy-MM-dd HH:mm"/>
        <label style="margin-left: 185px;">修改时间</label>
        <fmt:formatDate value="${devInfo.modifyTime}" pattern="yyyy-MM-dd HH:mm"/>
      </div>
      <div style="margin-left: 50px;">
        <label>入库人</label>
        <input id="createEmpName" style="width: 200px;margin-left: 14px;" value="${devInfo.createEmpName}" readonly="true">
        <label style="margin-left: 100px;"> 修改人</label>
        <input id="modifyEmpName" style="width: 200px;margin-left: 14px;" value="${devInfo.modifyEmpName}" readonly="true"><br>
      </div>
      <div style="margin-left: 50px;">
        <label>备注</label><br>
        <textarea id="remark" readonly="true" style="width: 600px; height: 100px;resize: none;">${devInfo.remark}</textarea>
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