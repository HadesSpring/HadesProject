<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Bottom.jsp' starting page</title>
    
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
    <!-- 底部 -->
		<footer class="templatemo-footer">
			<div class="templatemo-copyright">
				<p>Copyright &copy; 2015 Your Company Name</p>
			</div>
		</footer>
  </body>
  <script src="./resource/js/jquery/jquery-2.1.4.min.js"></script>
<script src="./resource/js/bootstrap.min.js"></script>
<script src="./resource/js/templatemo_script.js"></script>
</html>
