<!DOCTYPE html>
<html data-ng-app="formSubmit">
<head>
<meta charset="ISO-8859-1">
<title>Edit Doctor</title>

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
								var formDataa;
								var RowId;

								
				
							
								formDataa = {
									"DepartmentId" : "${model.DoctorData.department.departmentId}"
								};

								//Get all Department and Store in Dropdown
								$http.get("http://localhost:8080/eHealthService/GetAllDepartment").then(
										function(response) {

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

									var uploadUrl = "http://localhost:8080/eHealthService/continueFileUpload";
									var formData = new FormData();
									formData.append("file", file.files[0]);

									$http(
											{
												method : 'POST',
												url : 'http://localhost:8080/eHealthService/continueFileUpload',
												headers : {
													'Content-Type' : undefined
												},
												data : formData,
												transformRequest : function(
														data,
														headersGetterFunction) {
													return data; // do nothing! FormData is very good!
												}
											}).success(function(data, status) {
										
										$scope.ImageByte = data.content;

										//alert("Success ... " + data);
									}).error(function(data, status) {
										alert("Error ... " + status);
									});

								};

								RowId = "${model.DoctorData.id}";
								$scope.Name = "${model.DoctorData.name}";
								$scope.Email = "${model.DoctorData.email}";
								$scope.HomeAddress = "${model.DoctorData.homeAddress}";
								$scope.OfficeAddress = "${model.DoctorData.officeAddress}";
								$scope.Sex = "${model.DoctorData.sex}";
								$scope.BirthDate = "${model.DoctorData.birthDate}";
								$scope.Degree = "${model.DoctorData.degree}";
								$scope.Specialization = "${model.DoctorData.specialization}";
								$scope.DepartmentId = "${model.DoctorData.department.departmentId}";
								$scope.ImageByte = "${model.ImageData }";
								$scope.submit = function() {
									alert(RowId);
									var formData = {
										"Id" : RowId,
										"Name" : $scope.Name,
										"Email" : $scope.Email,
										"HomeAddress" : $scope.HomeAddress,
										"OfficeAddress" : $scope.OfficeAddress,
										"Sex" : $scope.Sex,
										"BirthDate" : $scope.BirthDate,
										"Degree" : $scope.Degree,
										"Specialization" : $scope.Specialization,
										"department" : formDataa,
										"Content" : $scope.ImageByte
									};

									var response = $http.post('http://localhost:8080/eHealthService/UpdateDoctor',
											formData);
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
						<p style="display: none">{{id=${model.DoctorData.id}}}
						<div class="form-group">
							<label for="Name">Name</label> <input type="text"
								class="form-control" id="Name" data-ng-model="Name"
								placeholder="Name">
						</div>
						<div class="form-group">
							<label for="Email">Email </label> <input type="text"
								class="form-control" id="Email" data-ng-model="Email"
								value="${model.DoctorData.email}" placeholder="Email">
						</div>

						<div class="form-group">
							<label for="HomeAddress">Home Address </label> <input type="text"
								class="form-control" id="HomeAddress"
								data-ng-model="HomeAddress"
								value="${model.DoctorData.homeAddress }" placeholder="Email">
						</div>
						<div class="form-group">
							<label for="OfficeAddress">Office Address </label> <input
								type="text" class="form-control" id="OfficeAddress"
								data-ng-model="OfficeAddress"
								value="${model.DoctorData.officeAddress }" placeholder="Email">
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
								class="form-control" value="${model.DoctorData.birthDate }"
								id="BirthDate" data-ng-model="BirthDate" placeholder="BirthDate">
						</div>
						<div class="form-group">
							<label for="Degree">Degree </label> <input type="text"
								class="form-control" value="${model.DoctorData.degree }"
								id="Degree" data-ng-model="Degree" placeholder="Degree">
						</div>
						<div class="form-group">
							<label for="Specialization">Specialization </label> <input
								type="text" class="form-control" id="Specialization"
								data-ng-model="Specialization"
								value="${model.DoctorData.specialization }"
								placeholder="Specialization">
						</div>
						<div class="form-group">
							<img width="200" height="200"
								data-ng-src="data:image/JPEG;base64,{{ImageByte}}">
						</div>




							<div class="form-group">
							<input class="inline-block" type="file" name="file"
								onchange="angular.element(this).scope().FileUpload(this)"
								ng-model="file" data-rule-required="true" id="file">
						</div>
						
						<div class="form-group">
							<select data-ng-model="DepartmentId"
								data-ng-change="onCategoryChange(itemSelected)">
								<option data-ng-repeat="x in data" id="{{ x.DepartmentId }}" value="{{ x.DepartmentId }}">{{
									x.DepartmentName }}</option>
							</select>

						</div>

						<button type="submit" class="btn btn-default">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>

</html>