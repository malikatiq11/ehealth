<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/eHealthService/resources/css/bootstrap.css"
	rel="Stylesheet" />
<link href="/eHealthService/resources/css/bootstrap.min.css"
	rel="Stylesheet" />

<script src="/eHealthService/resources/js/bootstrap.js"></script>
<script src="/eHealthService/resources/js/bootstrap.min.js"></script>
<script src="/eHealthService/resources/js/admin.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient</title>
</head>
<body>
	<div class="row">
		<div class="panel panel-primary">
			<!-- Default panel contents -->
			<div class="panel-heading">Add New Department</div>
			<div class="panel-body">
				<form action="post"  data-ng-submit="submit()"
						data-ng-controller="FormSubmitController"></form>
			</div>
		</div>
	</div>
</body>
</html>