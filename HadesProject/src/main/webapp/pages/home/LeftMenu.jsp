<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'LeftMenu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="./resource/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
	<link href="./resource/css/templatemo_main.css" rel="stylesheet">

  </head>
  
  <body>
   <ul class="templatemo-sidebar-menu">
          <li><a href="#"><i class="fa fa-home"></i>菜单一</a></li>
          <li class="sub">
            <a href="javascript:;">
              <i class="fa fa-database"></i>菜单二 <div class="pull-right"><span class="caret"></span></div>
            </a>
            <ul class="templatemo-submenu">
              <li><a href="#">子菜单二</a></li>
              <li><a href="#">子菜单二</a></li>
              <li><a href="#">子菜单二</a></li>             
              <li><a href="#">子菜单二</a></li>
              <li><a href="#">子菜单二</a></li>
            </ul>
          </li>
          <li><a href="#"><i class="fa fa-cubes"></i><span class="badge pull-right">9</span>菜单</a></li>
          <li><a href="#"><i class="fa fa-map-marker"></i><span class="badge pull-right">42</span>菜单</a></li>
          <li><a href="./pages/home/tables.jsp" target="MainContent"><i class="fa fa-users"></i><span class="badge pull-right">NEW</span>表格</a></li>
          <li><a href="#"><i class="fa fa-cog"></i>菜单</a></li>
          <li><a href="javascript:;" data-toggle="modal" data-target="#confirmModal"><i class="fa fa-sign-out"></i>退出</a></li>
   </ul>
  </body>
</html>
