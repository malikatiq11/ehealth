<!DOCTYPE html>
<html ng-app="myApp">
<link href="/eHealthService/resources/css/bootstrap.css"
	rel="Stylesheet" />
<link href="/eHealthService/resources/css/bootstrap.min.css"
	rel="Stylesheet" />

<script src="/eHealthService/resources/js/bootstrap.js"></script>
<script src="/eHealthService/resources/js/bootstrap.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script>
	var app = angular.module('myApp', []);
	app.controller('DepartmentCntrl', function($scope, $http) {
		$http.get("GetAllDepartment").then(function(response) {
			alert("Adadad");
			$scope.myData = response.data;
			$scope.data = response.data;
		});
	});
</script>
<body>
	<div class="row">
		<div class="container">

			<div ng-controller="DepartmentCntrl">
			{{data}}
				<div class="panel panel-primary">
					<!-- Default panel contents -->
					<div class="panel-heading">Department List</div>
					<div class="panel-body">

					<a href="InsertDept">Add New Department</a>
					</div>
						<table class="table table-striped table-hover">
							<thead>
								<th>Department Name</th>
								<th>Department Description</th>
							</thead>
							<tbody>
								<tr ng-repeat="x in data">
									<td>{{ x.DepartmentName }}</td>
									<td>{{ x.DepartmentDescription }}</td>
									<td>{{ x.DepartmentId }}</td>
									<td><a href="EditDept?id={{x.DepartmentId}}"> Edit </a></td>
									<td><a href="DeleteDept?id={{x.DepartmentId}}"> Delete
									</a></td>
								</tr>
							</tbody>
						</table>
					
				</div>
			</div>

		</div>
	</div>
	

</body>
</html>
