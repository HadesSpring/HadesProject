<!DOCTYPE html>
<head>
<meta charset="utf-8">
<!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
<title>Dashboard Tables, Free Admin Template</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width">
<link href="./resource/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="./resource/css/templatemo_main.css" rel="stylesheet">
</head>
<body>
	<div class="template-page-wrapper">
		<div class="navbar-collapse collapse templatemo-sidebar">
			<jsp:include page="LeftMenu.jsp"></jsp:include>
		</div>
		<div class="templatemo-content-wrapper">
			<div class="templatemo-content">
				<ol class="breadcrumb">
					<li><a href="index.jsp">Admin Panel</a>
					</li>
					<li><a href="#">Manage Users</a>
					</li>
					<li class="active">Tables</li>
				</ol>
				<h1>Manage Users</h1>
				<p>Here goes tables and users.</p>

				<div class="row margin-bottom-30">
					<div class="col-md-12">
						<ul class="nav nav-pills">
							<li class="active"><a href="#">New Users <span
									class="badge">42</span> </a>
							</li>
							<li><a href="#">Active Users <span class="badge">107</span>
							</a>
							</li>
							<li><a href="#">Expired Users <span class="badge">3</span>
							</a>
							</li>
						</ul>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="btn-group pull-right" id="templatemo_sort_btn">
							<button type="button" class="btn btn-default">Sort by</button>
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown">
								<span class="caret"></span> <span class="sr-only">Toggle
									Dropdown</span>
							</button>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">First Name</a>
								</li>
								<li><a href="#">Last Name</a>
								</li>
								<li><a href="#">Username</a>
								</li>
							</ul>
						</div>
						<div class="table-responsive">
							<h4 class="margin-bottom-15">New Users Table</h4>
							<table class="table table-striped table-hover table-bordered">
								<thead>
									<tr>
										<th>#</th>
										<th>First Name</th>
										<th>Last Name</th>
										<th>Username</th>
										<th>Email</th>
										<th>Edit</th>
										<th>Action</th>
										<th>Delete</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td>
										<td>John</td>
										<td>Smith</td>
										<td>@js</td>
										<td>a@company.com</td>
										<td><a href="#" class="btn btn-default">Edit</a>
										</td>
										<td>
											<!-- Split button -->
											<div class="btn-group">
												<button type="button" class="btn btn-info">Action</button>
												<button type="button" class="btn btn-info dropdown-toggle"
													data-toggle="dropdown">
													<span class="caret"></span> <span class="sr-only">Toggle
														Dropdown</span>
												</button>
												<ul class="dropdown-menu" role="menu">
													<li><a href="#">Bootstrap</a>
													</li>
													<li><a href="#">Font Awesome</a>
													</li>
													<li><a href="#">jQuery</a>
													</li>
												</ul>
											</div></td>
										<td><a href="#" class="btn btn-link">Delete</a>
										</td>
									</tr>
									<tr class="success">
										<td>2</td>
										<td>Bill</td>
										<td>Digital</td>
										<td>@bd</td>
										<td>bd@company.com</td>
										<td><a href="#" class="btn btn-default">Edit</a>
										</td>
										<td>
											<!-- Split button -->
											<div class="btn-group">
												<button type="button" class="btn btn-info">Action</button>
												<button type="button" class="btn btn-info dropdown-toggle"
													data-toggle="dropdown">
													<span class="caret"></span> <span class="sr-only">Toggle
														Dropdown</span>
												</button>
												<ul class="dropdown-menu" role="menu">
													<li><a href="#">Bootstrap</a>
													</li>
													<li><a href="#">Font Awesome</a>
													</li>
													<li><a href="#">jQuery</a>
													</li>
												</ul>
											</div></td>
										<td><a href="#" class="btn btn-link">Delete</a>
										</td>
									</tr>
									<tr>
										<td>3</td>
										<td>Marry</td>
										<td>James</td>
										<td>@mj</td>
										<td>mj@company.com</td>
										<td><a href="#" class="btn btn-default">Edit</a>
										</td>
										<td>
											<!-- Split button -->
											<div class="btn-group">
												<button type="button" class="btn btn-info">Action</button>
												<button type="button" class="btn btn-info dropdown-toggle"
													data-toggle="dropdown">
													<span class="caret"></span> <span class="sr-only">Toggle
														Dropdown</span>
												</button>
												<ul class="dropdown-menu" role="menu">
													<li><a href="#">Bootstrap</a>
													</li>
													<li><a href="#">Font Awesome</a>
													</li>
													<li><a href="#">jQuery</a>
													</li>
												</ul>
											</div></td>
										<td><a href="#" class="btn btn-link">Delete</a>
										</td>
									</tr>
									<tr>
										<td>4</td>
										<td>Carry</td>
										<td>Land</td>
										<td>@cl</td>
										<td>cl@company.com</td>
										<td><a href="#" class="btn btn-default">Edit</a>
										</td>
										<td>
											<!-- Split button -->
											<div class="btn-group">
												<button type="button" class="btn btn-info">Action</button>
												<button type="button" class="btn btn-info dropdown-toggle"
													data-toggle="dropdown">
													<span class="caret"></span> <span class="sr-only">Toggle
														Dropdown</span>
												</button>
												<ul class="dropdown-menu" role="menu">
													<li><a href="#">Bootstrap</a>
													</li>
													<li><a href="#">Font Awesome</a>
													</li>
													<li><a href="#">jQuery</a>
													</li>
												</ul>
											</div></td>
										<td><a href="#" class="btn btn-link">Delete</a>
										</td>
									</tr>
									<tr class="success">
										<td>5</td>
										<td>New</td>
										<td>Caroline</td>
										<td>@nc</td>
										<td>nc@company.com</td>
										<td><a href="#" class="btn btn-default">Edit</a>
										</td>
										<td>
											<!-- Split button -->
											<div class="btn-group">
												<button type="button" class="btn btn-info">Action</button>
												<button type="button" class="btn btn-info dropdown-toggle"
													data-toggle="dropdown">
													<span class="caret"></span> <span class="sr-only">Toggle
														Dropdown</span>
												</button>
												<ul class="dropdown-menu" role="menu">
													<li><a href="#">Bootstrap</a>
													</li>
													<li><a href="#">Font Awesome</a>
													</li>
													<li><a href="#">jQuery</a>
													</li>
												</ul>
											</div></td>
										<td><a href="#" class="btn btn-link">Delete</a>
										</td>
									</tr>
									<tr class="danger">
										<td>6</td>
										<td>Martin</td>
										<td>East</td>
										<td>@me</td>
										<td>me@company.com</td>
										<td><a href="#" class="btn btn-default">Edit</a>
										</td>
										<td>
											<!-- Split button -->
											<div class="btn-group">
												<button type="button" class="btn btn-info">Action</button>
												<button type="button" class="btn btn-info dropdown-toggle"
													data-toggle="dropdown">
													<span class="caret"></span> <span class="sr-only">Toggle
														Dropdown</span>
												</button>
												<ul class="dropdown-menu" role="menu">
													<li><a href="#">Bootstrap</a>
													</li>
													<li><a href="#">Font Awesome</a>
													</li>
													<li><a href="#">jQuery</a>
													</li>
												</ul>
											</div></td>
										<td><a href="#" class="btn btn-link">Delete</a>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="table-responsive">
							<h4 class="margin-bottom-15">Another Table of Existing Users</h4>
							<table class="table table-striped table-hover table-bordered">
								<thead>
									<tr>
										<th>#</th>
										<th>First Name</th>
										<th>Last Name</th>
										<th>Username</th>
										<th>Email</th>
										<th>Edit</th>
										<th>Action</th>
										<th>Delete</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td>
										<td>John</td>
										<td>Henry</td>
										<td>@jh</td>
										<td>a@company.com</td>
										<td><a href="#" class="btn btn-default">Edit</a>
										</td>
										<td>
											<!-- Split button -->
											<div class="btn-group">
												<button type="button" class="btn btn-info">Action</button>
												<button type="button" class="btn btn-info dropdown-toggle"
													data-toggle="dropdown">
													<span class="caret"></span> <span class="sr-only">Toggle
														Dropdown</span>
												</button>
												<ul class="dropdown-menu" role="menu">
													<li><a href="#">Bootstrap</a>
													</li>
													<li><a href="#">Font Awesome</a>
													</li>
													<li><a href="#">jQuery</a>
													</li>
												</ul>
											</div></td>
										<td><a href="#" class="btn btn-link">Delete</a>
										</td>
									</tr>
									<tr>
										<td>2</td>
										<td>Bill</td>
										<td>Goods</td>
										<td>@bg</td>
										<td>bg@company.com</td>
										<td><a href="#" class="btn btn-default">Edit</a>
										</td>
										<td>
											<div class="btn-group">
												<button type="button" class="btn btn-info">Action</button>
												<button type="button" class="btn btn-info dropdown-toggle"
													data-toggle="dropdown">
													<span class="caret"></span> <span class="sr-only">Toggle
														Dropdown</span>
												</button>
												<ul class="dropdown-menu" role="menu">
													<li><a href="#">Bootstrap</a>
													</li>
													<li><a href="#">Font Awesome</a>
													</li>
													<li><a href="#">jQuery</a>
													</li>
												</ul>
											</div></td>
										<td><a href="#" class="btn btn-link">Delete</a>
										</td>
									</tr>
									<tr>
										<td>3</td>
										<td>Authen</td>
										<td>Jobs</td>
										<td>@aj</td>
										<td>aj@company.com</td>
										<td><a href="#" class="btn btn-default">Edit</a>
										</td>
										<td>
											<!-- Split button -->
											<div class="btn-group">
												<button type="button" class="btn btn-info">Action</button>
												<button type="button" class="btn btn-info dropdown-toggle"
													data-toggle="dropdown">
													<span class="caret"></span> <span class="sr-only">Toggle
														Dropdown</span>
												</button>
												<ul class="dropdown-menu" role="menu">
													<li><a href="#">Bootstrap</a>
													</li>
													<li><a href="#">Font Awesome</a>
													</li>
													<li><a href="#">jQuery</a>
													</li>
												</ul>
											</div></td>
										<td><a href="#" class="btn btn-link">Delete</a>
										</td>
									</tr>
									<tr>
										<td>4</td>
										<td>Jesica</td>
										<td>High</td>
										<td>@jh</td>
										<td>jh@company.com</td>
										<td><a href="#" class="btn btn-default">Edit</a>
										</td>
										<td>
											<!-- Split button -->
											<div class="btn-group">
												<button type="button" class="btn btn-info">Action</button>
												<button type="button" class="btn btn-info dropdown-toggle"
													data-toggle="dropdown">
													<span class="caret"></span> <span class="sr-only">Toggle
														Dropdown</span>
												</button>
												<ul class="dropdown-menu" role="menu">
													<li><a href="#">Bootstrap</a>
													</li>
													<li><a href="#">Font Awesome</a>
													</li>
													<li><a href="#">jQuery</a>
													</li>
												</ul>
											</div></td>
										<td><a href="#" class="btn btn-link">Delete</a>
										</td>
									</tr>
									<tr>
										<td>5</td>
										<td>Tom</td>
										<td>Grace</td>
										<td>@tg</td>
										<td>tg@company.com</td>
										<td><a href="#" class="btn btn-default">Edit</a>
										</td>
										<td>
											<!-- Split button -->
											<div class="btn-group">
												<button type="button" class="btn btn-info">Action</button>
												<button type="button" class="btn btn-info dropdown-toggle"
													data-toggle="dropdown">
													<span class="caret"></span> <span class="sr-only">Toggle
														Dropdown</span>
												</button>
												<ul class="dropdown-menu" role="menu">
													<li><a href="#">Bootstrap</a>
													</li>
													<li><a href="#">Font Awesome</a>
													</li>
													<li><a href="#">jQuery</a>
													</li>
												</ul>
											</div></td>
										<td><a href="#" class="btn btn-link">Delete</a>
										</td>
									</tr>
									<tr>
										<td>6</td>
										<td>Book</td>
										<td>Rocker</td>
										<td>@br</td>
										<td>br@company.com</td>
										<td><a href="#" class="btn btn-default">Edit</a>
										</td>
										<td>
											<!-- Split button -->
											<div class="btn-group">
												<button type="button" class="btn btn-info">Action</button>
												<button type="button" class="btn btn-info dropdown-toggle"
													data-toggle="dropdown">
													<span class="caret"></span> <span class="sr-only">Toggle
														Dropdown</span>
												</button>
												<ul class="dropdown-menu" role="menu">
													<li><a href="#">Bootstrap</a>
													</li>
													<li><a href="#">Font Awesome</a>
													</li>
													<li><a href="#">jQuery</a>
													</li>
												</ul>
											</div></td>
										<td><a href="#" class="btn btn-link">Delete</a>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<ul class="pagination pull-right">
							<li class="disabled"><a href="#">&laquo;</a>
							</li>
							<li class="active"><a href="#">1 <span class="sr-only">(current)</span>
							</a>
							</li>
							<li><a href="#">2 <span class="sr-only">(current)</span>
							</a>
							</li>
							<li><a href="#">3 <span class="sr-only">(current)</span>
							</a>
							</li>
							<li><a href="#">4 <span class="sr-only">(current)</span>
							</a>
							</li>
							<li><a href="#">5 <span class="sr-only">(current)</span>
							</a>
							</li>
							<li><a href="#">&raquo;</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="./resource/js/jquery/jquery-2.1.4.min.js"></script>
	<script src="./resource/js/bootstrap.min.js"></script>
	<script src="./resource/js/templatemo_script.js"></script>
</body>
</html>