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

<title>My JSP 'MainCenter.jsp' starting page</title>

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
	<div class="template-page-wrapper">
		<!-- 中间左侧导航区域 -->
		<div class="navbar-collapse collapse templatemo-sidebar">
			<jsp:include page="LeftMenu.jsp"></jsp:include>
		</div>
		<!-- 中间左侧导航区域结束 -->
		<!-- 内容显示区域开始 -->
		<div class="templatemo-content-wrapper">
			<jsp:include page="content.jsp"></jsp:include>
		</div>
		<!-- 内容显示区域结束-->
		<!-- 遮罩层-->
		<div class="modal fade" id="confirmModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Are you sure you
							want to sign out?</h4>
					</div>
					<div class="modal-footer">
						<a href="login.jsp" class="btn btn-primary">Yes</a>
						<button type="button" class="btn btn-default" data-dismiss="modal">No</button>
					</div>
				</div>
			</div>
		</div>
</body>
<script src="./resource/js/jquery/jquery-2.1.4.min.js"></script>
<script src="./resource/js/bootstrap.min.js"></script>
<script src="./resource/js/templatemo_script.js"></script>
</html>
