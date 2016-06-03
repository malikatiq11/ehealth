<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html data-ng-app="formSubmit">
<head>
<meta charset="ISO-8859-1">
<title>Insert Doctor</title>

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

	app.controller('FormSubmitController', [
			'$scope',
			'$http',
			function($scope, $http) {
				var formDataa;
				var contentinbyte;
				//Get all Department and Store in Dropdown
				$http.get("GetAllDepartment").then(function(response) {

					$scope.data = response.data;
				});

				//get the select value from dropdown of department
				//and make department object to store in json
				$scope.onCategoryChange = function(item) {
					formDataa = {
						"DepartmentId" : $scope.DepartmentId
					};

				};

				$scope.FileUpload = function() {

					var uploadUrl = "/continueFileUpload";
					var formData = new FormData();
					formData.append("file", file.files[0]);

					$http(
							{
								method : 'POST',
								url : 'continueFileUpload',
								headers : {
									'Content-Type' : undefined
								},
								data : formData,
								transformRequest : function(data,
										headersGetterFunction) {
									return data; // do nothing! FormData is very good!
								}
							}).success(function(data, status) {
								$scope.test=data;
								$scope.ImageByte=data;
								contentinbyte = data.content;
								
						alert("Success ... " + data);
					}).error(function(data, status) {
						alert("Error ... " + status);
					});

				};
				$scope.submit = function() {
					$scope.list = $scope.DepartmentName;
					var formData = {
						"Name" : $scope.Name,
						"Email" : $scope.Email,
						"HomeAddress" : $scope.HomeAddress,
						"OfficeAddress" : $scope.OfficeAddress,
						"Sex" : $scope.Sex,

						"BirthDate" : $scope.BirthDate,
						"Degree" : $scope.Degree,
						"Specialization" : $scope.Specialization,
						"department" : formDataa,
						"Content" :contentinbyte
					};
					$scope.test = formData.department.DepartmentId;
					$scope.list = formData.DepartmentName;
					var response = $http.post('PostDoctor', formData);
					response.success(function(data, status, headers, config) {
						$scope.list = data;

					});
					response.error(function(data, status, headers, config) {
						alert("Exception details: " + JSON.stringify({
							data : data
						}));
					});

				};
			} ]);
</script>
</head>
<body>

	<div class="row" data-ng-controller="FormSubmitController">
		<div class="container">
			<div class="panel panel-primary">
				<!-- Default panel contents -->
				<div class="panel-heading">Add New Dcotor</div>
				<div class="panel-body">
					<form data-ng-submit="submit()" enctype="multipart/form-data">

						<div class="form-group">
							<label for="Name">Name</label> <input type="text"
								class="form-control" id="Name" data-ng-model="Name"
								placeholder="Name">
						</div>
						<div class="form-group">
							<label for="Email">Email </label> <input type="text"
								class="form-control" id="Email" data-ng-model="Email"
								placeholder="Email">
						</div>

						<div class="form-group">
							<label for="HomeAddress">Home Address </label> <input type="text"
								class="form-control" id="HomeAddress"
								data-ng-model="HomeAddress" placeholder="Email">
						</div>
						<div class="form-group">
							<label for="OfficeAddress">Office Address </label> <input
								type="text" class="form-control" id="OfficeAddress"
								data-ng-model="OfficeAddress" placeholder="Email">
						</div>

						<div class="form-group">
							<select data-ng-model="Sex">
								<option value="Male">Male</option>
								<option value="Female">Female</option>
								<option value="Shemale">Shemale</option>
							</select>
						</div>

						<div class="form-group">
							<label for="BirthDate">Birth Date </label> <input type="text"
								class="form-control" id="BirthDate" data-ng-model="BirthDate"
								placeholder="BirthDate">
						</div>
						<div class="form-group">
							<label for="Degree">Degree </label> <input type="text"
								class="form-control" id="Degree" data-ng-model="Degree"
								placeholder="Degree">
						</div>
						<div class="form-group">
							<label for="Specialization">Specialization </label> <input
								type="text" class="form-control" id="Specialization"
								data-ng-model="Specialization" placeholder="Specialization">
						</div>
						{{test}}
						{{contentinbypte}}
						{{contentname}}

						<div class="form-group">
							<select data-ng-model="DepartmentId"
								data-ng-change="onCategoryChange(itemSelected)">
								<option data-ng-repeat="x in data" value="{{ x.DepartmentId }}">{{
									x.DepartmentName }}</option>
							</select>

						</div>
						<img width="200" height="200" ng-src="data:image/JPEG;base64,{{ImageByte.content}}">
						
						<div class="col-xs-4 input-max controls ">
							<input class="inline-block" type="file" name="file" onchange="angular.element(this).scope().FileUpload(this)"
								ng-model="file" data-rule-required="true" id="file">
						</div>

						<button type="submit" class="btn btn-default">Submit</button>

					</form>
				</div>
			</div>
		</div>

	</div>

</body>
</html>