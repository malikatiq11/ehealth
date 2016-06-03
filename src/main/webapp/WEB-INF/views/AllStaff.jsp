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
		$http.get("GetAllStaff").then(function(response) {
			$scope.myData = response.data;
			$scope.data = response.data;
		});
	});
</script>
<body>
	<div class="row">
		<div class="container">

			<div ng-controller="DepartmentCntrl">
				<div class="panel panel-primary">
					<!-- Default panel contents -->
					<div class="panel-heading">Staff List</div>
					<div class="panel-body">

					<a href="InsertStaff">Add New Staff</a>
					</div>
						<table class="table table-striped table-hover">
							<thead>
								<th> Picture</th>
								<th>Name</th>
								<th>Email</th>
								<th>MobileNo</th>
							</thead>
							<tbody>
								<tr ng-repeat="x in data">
								<td><img width="50" height="50" ng-src="data:image/JPEG;base64,{{ x.Content }}"></td>
									<td>{{ x.Name }}</td>
									<td>{{ x.Email }}</td>
									<td>{{ x.MobileNo }}</td>
									<td><a href="EditStaff?id={{x.Id}}"> Edit </a></td>
									<td><a href="DeleteStaff?id={{x.Id}}"> Delete
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
