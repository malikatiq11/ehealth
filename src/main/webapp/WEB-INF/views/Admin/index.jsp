
<!DOCTYPE html >
<html ng-app="AdminApp" data-ng-controller="MainController">

<title>eHealthService</title>

<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
	
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">


	<script src="/eHealthService/resources/js/bootstrap.js"></script>
<script src="/eHealthService/resources/js/bootstrap.min.js"></script>
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
	<link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css"  rel="stylesheet">
	
	<script type="text/javascript"  src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.js"></script>
	<script type="text/javascript"  src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>
	
	<script type="text/javascript" src="https://cdn.jsdelivr.net/ngstorage/0.3.6/ngStorage.min.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-animate.js"></script>
	<script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-1.3.2.js"></script>

 -->



  
<!-- Template Css -->
<link href="/eHealthService/resources/css/admindesign.css" rel="Stylesheet" />
<link href="/eHealthService/resources/css/_all-skins.min.css" rel="Stylesheet" />


	
<!-- Bootstrap CSS/Script Files -->
<link href="/eHealthService/resources/css/bootstrap.css" rel="Stylesheet" />
<link href="/eHealthService/resources/css/bootstrap.min.css"  rel="Stylesheet" />
<script type="text/javascript" src="/eHealthService/resources/js/bootstrap/bootstrap.js"></script>
<script type="text/javascript" src="/eHealthService/resources/js/bootstrap/bootstrap.min.js"></script>


<!-- Material Design Files -->
 <link href="/eHealthService/resources/Material_Design/mui.css"  rel="Stylesheet" />  
 <script type="text/javascript" src="/eHealthService/resources/Material_Design/mui.js"></script> 

 

	
	
<!-- Custom Css -->

	

<!-- Angular jS files -->
<script type="text/javascript" src="/eHealthService/resources/js/angular/1.4.8-angular.js"></script>
<script type="text/javascript" src="/eHealthService/resources/js/angular/1.4.8-angular-route.js"></script>
<script type="text/javascript" src="/eHealthService/resources/js/angular/angular-resource.min.js"></script>

<!-- materail design for angular -->
<script type="text/javascript" src="/eHealthService/resources/Material_Design/mui-angular.js"></script> 

<!-- localstorage file -->
<script type="text/javascript" src="/eHealthService/resources/js/0.3.6-ngStorage.min.js"></script>

<!-- angular UI bootstrap files -->
<script type="text/javascript" src="/eHealthService/resources/js/1.4.8-angular-animate.js"></script>
<script type="text/javascript" src="/eHealthService/resources/js/ui-bootstrap-tpls-1.3.2.js"></script>

	
	
<!-- angular controller -->
<script type="text/javascript" src="/eHealthService/resources/js/controller/AdminController.js"></script>
<script type="text/javascript" src="/eHealthService/resources/js/controller/DepartmentController.js"></script>
<script type="text/javascript" src="/eHealthService/resources/js/controller/DoctorController.js"></script>
<script type="text/javascript" src="/eHealthService/resources/js/controller/StaffController.js"></script>
<script type="text/javascript" src="/eHealthService/resources/js/controller/PatientController.js"></script>




<script type="text/javascript" src="/eHealthService/resources/js/dirPagination.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>

</script>
<style>

select#soflow, select#soflow-color {
   -webkit-appearance: button;
   -webkit-border-radius: 2px;
   -webkit-box-shadow: 0px 1px 3px rgba(0, 0, 0, 0.1);
   -webkit-padding-end: 20px;
   -webkit-padding-start: 2px;
   -webkit-user-select: none;
   background-image: url(http://i62.tinypic.com/15xvbd5.png), -webkit-linear-gradient(#FAFAFA, #F4F4F4 40%, #E5E5E5);
   background-position: 97% center;
   background-repeat: no-repeat;
   border: 1px solid #AAA;
   color: #555;
   font-size: inherit;
   overflow: hidden;
   padding: 5px 10px;
   text-overflow: ellipsis;
   white-space: nowrap;
   width: 320px;
}


</style>
</head>
<!-- ADD THE CLASS fixed TO GET A FIXED HEADER AND SIDEBAR LAYOUT -->
<!-- the fixed layout is not compatible with sidebar-mini -->
<body class="hold-transition skin-blue fixed sidebar-mini">
	<!-- Site wrapper -->
	<div class="wrapper">
	
<header class="main-header"> <a href="index2.html"
			class="logo"> <!-- mini logo for sidebar mini 50x50 pixels --> <span
			class="logo-lg"><b>eHealth</b>Service</span>
		</a> <!-- Header Navbar: style can be found in header.less --> <nav
			class="navbar navbar-static-top" role="navigation"> <!-- Sidebar toggle button-->

		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<li class="dropdown user user-menu"><a ng-style="changevisibilty" href="#" ng-click="logout()"> Logout</a></li>
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
			<li class="treeview"><a href="http://localhost:8080/eHealthService/admin/#/GetDepartments"> 
					<span>Department</span>
			</a></li>
			<li class="treeview"><a href="http://localhost:8080/eHealthService/admin/#/GetDoctor"> 
					<span>Doctor</span> 
			</a></li>
			<li class="treeview"><a href="http://localhost:8080/eHealthService/admin/#/GetPatient"> <span>Patient</span>
			
			</a></li>
			<li class="treeview"><a href="http://localhost:8080/eHealthService/admin/#/GetStaff"> 
					<span>Staff</span>
			</a></li>
			<li class="treeview"><a href="http://localhost:8080/eHealthService/admin/#/StaffAccount"> 
					<span>Account Management</span> 
			</a></li>
			<li class="treeview"><a href="http://localhost:8080/eHealthService/admin/#/PatientHistory"> 
					<span>Patient History</span> 
			</a></li>
		
		</ul>
		</section> <!-- /.sidebar --> </aside>

		<!-- =============================================== -->

		<!-- Content Wrapper. Contains page content -->
	
		<div class="content-wrapper" style="padding-bottom:300px; background:#fafafa">
	
			<br>
			<br>
			<div data-ng-view></div>
			</div>
		
		<!-- /.content-wrapper -->
	
		<footer class="main-footer" >
		
		<strong>Copyright &copy; 2016 <a
			href="#">eHealthSerivce</a>.
		</strong> All rights reserved. </footer>

</div>

</body>
</html>
