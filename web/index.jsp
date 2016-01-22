<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/11/24
  Time: 0:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
  <head>
    <title></title>
  </head>
  <body>
      <% response.sendRedirect(basePath+"common/toLogin.do");%>
  </body>
</html>
