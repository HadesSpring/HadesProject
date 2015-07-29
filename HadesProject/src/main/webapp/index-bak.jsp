<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<head>
<meta charset="utf-8">
<!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
<title>XXX进销存管理系统</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width">
<link href="./resource/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="./resource/css/templatemo_main.css" rel="stylesheet">
</head>
<body>
<%
	String contentUrl = "./pages/home/content.jsp";
 %>

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
	<div class="template-page-wrapper">
		<!-- 中间左侧导航区域 -->
		<div class="navbar-collapse collapse templatemo-sidebar">
			<jsp:include page="./pages/home/LeftMenu.jsp"></jsp:include>
		</div>
		<!-- 中间左侧导航区域结束 -->
		<!-- 内容显示区域开始 -->
		<%-- <div class="templatemo-content-wrapper">
			<jsp:include page="content.jsp"></jsp:include>
		</div> --%>
		<jsp:include page="<%=contentUrl %>"></jsp:include>
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
		<!-- 底部 -->
		<footer class="templatemo-footer">
			<div class="templatemo-copyright">
				<p>Copyright &copy; 2015 Your Company Name</p>
			</div>
		</footer>
	</div>

	<script src="./resource/js/jquery/jquery-2.1.4.min.js"></script>
	<script src="./resource/js/bootstrap.min.js"></script>
	<script src="./resource/js/Chart.min.js"></script>
	<script src="./resource/js/templatemo_script.js"></script>
	<script type="text/javascript">
		
	</script>
</body>
</html>
