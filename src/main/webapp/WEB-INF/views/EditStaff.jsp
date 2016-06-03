<!DOCTYPE html>
<html data-ng-app="formSubmit">
<head>
<meta charset="ISO-8859-1">
<title>Edit Staff</title>

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

	app.controller(
					'FormSubmitController',
					[
							'$scope',
							'$http',
							function($scope, $http) {

							
								var formDataa;
								var RowId;

								RowId = "${model.StaffData.id}";
								$scope.Name = "${model.StaffData.name}";
								$scope.Email = "${model.StaffData.email}";
								$scope.MobileNo = "${model.StaffData.mobileNo}}";
								$scope.DepartmentId = "${model.StaffData.department.departmentId}";
								$scope.ImageByte = "${model.ImageData }";
							
							formDataa = {
									"DepartmentId" : "${model.StaffData.department.departmentId}"
								};
								//Get all Department and Store in Dropdown
											$http.get("GetAllDepartment").then(function(response) {

					$scope.data = response.data;
				});
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
								$scope.submit = function() {
									$scope.list = $scope.Name;
									var formData = {
										"DepartmentId" : $scope.id,
										"Name" : $scope.Name,
										"Email" : $scope.Email,
										"MobileNo" : $scope.MobileNo,
										"department" : formDataa,
										"Content" : $scope.ImageByte,
									};

									var response = $http.post(
											'UpdateStaff', formData);
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

									//Empty list data after process
									//$scope.list = [];

								};
							} ]);
</script>

</head>
<body>

	<div class="row">
		<div class="container">
			<div class="panel panel-primary">
				<!-- Default panel contents -->
				<div class="panel-heading">Edit Staff</div>
				<div class="panel-body">
					<form data-ng-submit="submit()"
						data-ng-controller="FormSubmitController">
						 <p style="display: none">{{id=${StaffData.id}}}

						<div class="form-group">
							<label for="Name">Name</label> <input type="text"
								class="form-control" id="Name" data-ng-model="Name"
								value="${model.StaffData.name }"
								placeholder="Name" required>
						</div>
						<div class="form-group">
							<label for="Email">Email </label> <input type="email"
								class="form-control" id="Email" data-ng-model="Email"
								value="${model.StaffData.email}"
								placeholder="Email" required>
						</div>
						<div class="form-group">
							<label for="MobileNo">MobileNo </label> <input type="text"
								class="form-control" id="MobileNo" data-ng-model="MobileNo"
								value="${model.StaffData.mobileNo}"
								placeholder="Mobile No" required>
						</div>	
					<div class="form-group">
							<img width="200" height="200"
								data-ng-src="data:image/JPEG;base64,{{ImageByte.content}}">
						</div>
							<div class="form-group">
							<input class="inline-block" type="file" name="file"
								onchange="angular.element(this).scope().FileUpload(this)"
								ng-model="file" data-rule-required="true" id="file" required>
						</div>
						<div class="form-group">
							<select data-ng-model="DepartmentId"
								data-ng-change="onCategoryChange(itemSelected) " required >
								<option data-ng-repeat="x in data" value="{{ x.DepartmentId }}">{{
									x.DepartmentName }}</option>
							</select>

						</div>



						<button type="submit" class="btn btn-default">Submit</button>
					</form>
				</div>
			</div>
		</div>
</body>
</html>