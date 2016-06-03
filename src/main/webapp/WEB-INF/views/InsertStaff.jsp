
<!DOCTYPE html>
<html data-ng-app="formSubmit">
<head>
<meta charset="ISO-8859-1">
<title>Insert Staff</title>

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

	app.controller('FormSubmitController', [ '$scope', '$http',
			function($scope, $http) {
		var formDataa;
		var contentinbyte;
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
						"MobileNo" : $scope.MobileNo,
						"department" : formDataa,
						//"DepartmentId" : $scope.DepartmentId,
						"Content" :contentinbyte
						
						
					};
				//	$scope.test=formData.Sex;
				alert("start")	
			
					var response = $http.post('PostStaff', formData);
					response.success(function(data, status, headers, config) {
						$scope.list = data;
						

					});
					response.error(function(data, status, headers, config) {
						alert("Exception details: " + JSON.stringify({
							data : data
						}));
					});
		alert("end")
					//Empty list data after process
					//$scope.list = [];

				};
			} ]);
</script>
</head>
<body>

	<div class="row" data-ng-controller="FormSubmitController">
		<div class="container">
			<div class="panel panel-primary">
				<!-- Default panel contents -->
				<div class="panel-heading">Add New Staff</div>
				<div class="panel-body">
					<form data-ng-submit="submit()"  enctype="multipart/form-data"> 
						

						<div class="form-group">
							<label for="Name">Name</label> <input type="text"
								class="form-control" id="Name" data-ng-model="Name"
								placeholder="Name"  required >
						</div>
						<div class="form-group">
							<label for="Email">Email </label> <input type="email"
								class="form-control" id="Email" data-ng-model="Email"
								placeholder="Email"  required >
						</div>

						<div class="form-group">
							<label for="MobileNo">Mobile No</label> <input type="text"
								class="form-control" id="MobileNo"
								data-ng-model="MobileNo" placeholder="Mobile No"  required>
						</div>
						

						
						{{test}}
						{{contentinbypte}}
						{{contentname}}

						<div class="form-group">
							<select data-ng-model="DepartmentId"
								data-ng-change="onCategoryChange(itemSelected) " required >
								<option data-ng-repeat="x in data" value="{{ x.DepartmentId }}">{{
									x.DepartmentName }}</option>
							</select>

						</div>
						
						<img width="200" height="200" ng-src="data:image/JPEG;base64,{{ImageByte.content}}">
						
						<div class="col-xs-4 input-max controls ">
							<input class="inline-block" type="file" name="file" onchange="angular.element(this).scope().FileUpload(this)"
								ng-model="file" data-rule-required="true" id="file" required>
						</div>
						<button type="submit" class="btn btn-default">Submit</button>

					</form>
				</div>
			</div>
		</div>

	</div>

</body>
</html>