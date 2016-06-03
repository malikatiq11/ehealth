<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="AdminApp">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>eHealthService</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
	
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">




<link href="/eHealthService/resources/css/bootstrap.css"
	rel="Stylesheet" />
<link href="/eHealthService/resources/css/bootstrap.min.css"
	rel="Stylesheet" />

<link href="/eHealthService/resources/css/admindesign.css"
	rel="Stylesheet" />
<link href="/eHealthService/resources/css/_all-skins.min.css"
	rel="Stylesheet" />


<script src="/eHealthService/resources/js/bootstrap.js"></script>
<script src="/eHealthService/resources/js/bootstrap.min.js"></script>



<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular.min.js"></script>
	
	<script type="text/javascript" src="/eHealthService/resources/js/controller.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
	

	//	var response = $http.post('http://localhost:8080/eHealthService/GetDepartmentbyId/?id=16',$routeParams.id);
	//	response.success(function(data, status,
	//			headers, config) {
	//	
	//		alert(data.DepartmentName);

	//	});
	//	response.error(function(data, status,
	//			headers, config) {
	//		alert("Exception details: "
	//				+ JSON.stringify({
	//					data : data
	//				}));
	//	});
	//	$http.get("http://localhost:8080/eHealthService/GetDepartmentbyId/?id="+$routeParams.id).then(function(response) {
	//		alert(response);
	//	$scope.Editdata = response;
	//	});

	//	});
</script>

</head>
<!-- ADD THE CLASS fixed TO GET A FIXED HEADER AND SIDEBAR LAYOUT -->
<!-- the fixed layout is not compatible with sidebar-mini -->
<body class="hold-transition skin-blue fixed sidebar-mini">
	<!-- Site wrapper -->
	<div class="wrapper">

		<header class="main-header">  <a
			href="index2.html" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
			
			<span class="logo-lg"><b>eHealth</b>Service</span>
		</a> <!-- Header Navbar: style can be found in header.less --> <nav
			class="navbar navbar-static-top" role="navigation"> <!-- Sidebar toggle button-->

		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<li class="dropdown user user-menu"><a href="#"> <img
						src="dist/img/user2-160x160.jpg" class="user-image"
						alt="User Image"> <span class="hidden-xs">Admin</span>
				</a></li>
			</ul>
		</div>
		</nav> </header>

		<!-- =============================================== -->

		<!-- Left side column. contains the sidebar -->
		<aside class="main-sidebar"> <!-- sidebar: style can be found in sidebar.less -->
		<section class="sidebar"> <!-- Sidebar user panel -->
		
		<!-- search form -->
		<form action="#" method="get" class="sidebar-form">
			<div class="input-group">
				<input type="text" name="q" class="form-control"
					placeholder="Search..."> <span class="input-group-btn">
					<button type="submit" name="search" id="search-btn"
						class="btn btn-flat">
						<i class="fa fa-search"></i>
					</button>
				</span>
			</div>
		</form>
		<!-- /.search form --> <!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">MAIN NAVIGATION</li>
			<li class="treeview"><a href="#"> 
					<span>Department</span>
			</a></li>
			<li class="treeview"><a href="#"> 
					<span>Doctor</span> 
			</a></li>
			<li class="treeview"><a href="#"> <span>Patient</span>
			
			</a></li>
			<li class="treeview"><a href="#"> 
					<span>Staff</span>
			</a></li>
			<li class="treeview"><a href="#"> 
					<span>UI Elements</span> 
			</a></li>
		
		</ul>
		</section> <!-- /.sidebar --> </aside>

		<!-- =============================================== -->

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<br>
			<br>
			<div data-ng-view></div>

		</div>
		<!-- /.content-wrapper -->

		<footer class="main-footer">
		
		<strong>Copyright &copy; 2016 <a
			href="#">eHealthSerivce</a>.
		</strong> All rights reserved. </footer>

</div>

</body>
</html>
