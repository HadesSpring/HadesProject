<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'content.jsp' starting page</title>

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
	<div class="templatemo-content">
		<ol class="breadcrumb">
			<li><a href="index.jsp">ToolBar 1</a>
			</li>
			<li><a href="#">ToolBar 2</a>
			</li>
			<li class="active">ToolBar 3</li>
			<li><a href="login.jsp">ToolBar 4</a>
			</li>
		</ol>
		<div class="templatemo-panels">内容显示区域</div>
	</div>
</body>
</html>
