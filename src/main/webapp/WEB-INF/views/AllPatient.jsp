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
	app.controller('PatientCntrl', function($scope, $http) {
		$http.get("GetAllPatient").then(function(response) {
			$scope.myData = response.data;
			$scope.data = response.data;
		});
	});
</script>
<body>
	<div class="row">
		<div class="container">

			<div ng-controller="PatientCntrl">
		
				<div class="panel panel-primary">
					<!-- Default panel contents -->
					<div class="panel-heading">Doctor List</div>
					<div class="panel-body">

					<a href="InsertDoc">Add New Doctor</a>
					</div>
						<table class="table table-striped table-hover">
							<thead>
								<th> Cnic</th>
								<th> Name</th>
								<th>Family Number</th>
								<th> Phone Number</th>
								<th>DOB</th>
							
							
							</thead>
							<tbody>
								<tr ng-repeat="x in data">
									
									<td>{{ x.Cnic }}</td>
									<td>{{ x.PatientName}} </td>
									<td>{{ x.FamilyName }}</td>
									<td>{{ x.PhoneNumberPersonalBusiness  }} </td>
									<td >{{ x.DOB }}</td>
									<td><a href="EditPatient?id={{x.PatientId}}"> Edit </a></td>
									<td><a href="DeletePatient?id={{x.PatientId}}"> Delete
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
