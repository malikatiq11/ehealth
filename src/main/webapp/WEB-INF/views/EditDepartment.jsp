<!DOCTYPE html>
<html data-ng-app="formSubmit">
<head>
<meta charset="ISO-8859-1">
<title>Edit Department</title>

<link href="/eHealthService/resources/css/bootstrap.css"
	rel="Stylesheet" />
<link href="/eHealthService/resources/css/bootstrap.min.css"
	rel="Stylesheet" />

<script src="/eHealthService/resources/js/bootstrap.js"></script>
<script src="/eHealthService/resources/js/bootstrap.min.js"></script>

<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.8/angular.min.js"></script>
<script type="text/javascript">

	var app = angular.module('formSubmit', []);

	app
			.controller(
					'FormSubmitController',
					[
							'$scope',
							'$http',
							function($scope, $http) {
								$scope.DepartmentName="${DepartmentData.departmentname}";
								$scope.DepartmentDescription="${DepartmentData.departmentdescription}";
								$scope.submit = function() {
									$scope.list = $scope.DepartmentName;
									var formData = {
										"DepartmentId" : $scope.id,
										"DepartmentName" : $scope.DepartmentName,
										"DepartmentDescription" : $scope.DepartmentDescription,
									};

									var response = $http.post(
											'UpdateDepartment', formData);
									response.success(function(data, status,
											headers, config) {
										$scope.list = data;

									});
									response.error(function(data, status,
											headers, config) {
										alert("Exception details: "
												+ JSON.stringify({
													data : data
												}));
									});

								

								};
							} ]);
</script>

</head>
<body>

	<div class="row">
		<div class="container">
			<div class="panel panel-primary">
				<!-- Default panel contents -->
				<div class="panel-heading">Edit Department</div>
				<div class="panel-body">
					<form data-ng-submit="submit()"
						data-ng-controller="FormSubmitController">
						<p style="display: none">{{id=${DepartmentData.departmentId}}}</p>

						<div class="form-group">
							<label for="DepartmentName">Department Name</label> <input
								type="text" class="form-control" id="DepartmentName"
								data-ng-model="DepartmentName" placeholder="Name"
								>
						</div>
						<div class="form-group">
							<label for="DepartmentDescription">Department Description
							</label> <input type="text" class="form-control"
								id="DepartmentDescription" data-ng-model="DepartmentDescription"
								placeholder="Description"
								>
						</div>


						<button type="submit" class="btn btn-default">Submit</button>
					</form>
				</div>
			</div>
		</div>
		</div>
</body>
</html>