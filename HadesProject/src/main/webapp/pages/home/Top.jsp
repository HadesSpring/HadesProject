<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Top.jsp' starting page</title>
    
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
    <div class="navbar navbar-inverse" role="navigation">
		<div class="navbar-header">
			<div class="logo">
				<h1>Project name</h1>
			</div>
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<!-- 顶部导航条开始 -->
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a>
				</li>
				<li><a href="#about">About</a>
				</li>
				<li><a href="#contact">Contact</a>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Dropdown <span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a>
						</li>
						<li><a href="#">Another action</a>
						</li>
						<li><a href="#">Something else here</a>
						</li>
						<li role="separator" class="divider"></li>
						<li class="dropdown-header">Nav header</li>
						<li><a href="#">Separated link</a>
						</li>
						<li><a href="#">One more separated link</a>
						</li>
					</ul></li>
			</ul>
		</div>
		<!-- 顶部导航条结束 -->
	</div>
  </body>
  <script src="./resource/js/jquery/jquery-2.1.4.min.js"></script>
<script src="./resource/js/bootstrap.min.js"></script>
<script src="./resource/js/templatemo_script.js"></script>
</html>
