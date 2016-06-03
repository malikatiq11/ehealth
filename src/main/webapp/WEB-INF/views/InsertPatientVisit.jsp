<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html data-ng-app="formSubmit">
<head>
<meta charset="ISO-8859-1">
<title>Insert Patient Visit</title>

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
				//Get all Department and Store in Dropdown
				$http.get("GetAllDepartment").then(function(response) {

					$scope.data = response.data;
				});
				$http.get("GetAllDoctor").then(function(response) {

					$scope.Doctordata = response.data;
				});
			
				//get the select value from dropdown of department
				//and make department object to store in json
				$scope.onCategoryChange = function(item) {
					formDataa = {
						"DepartmentId" : $scope.DepartmentId
					};

				};
				
				$scope.onDoctorChange = function(item) {
					DoctorFormData = {
						"Id" : $scope.DoctorId
					};
					alert($scope.DoctorId);

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
						$scope.test = data;
						$scope.ImageByte = data;
						contentinbyte = data.content;

						alert("Success ... " + data);
					}).error(function(data, status) {
						alert("Error ... " + status);
					});

				};
				$scope.submit = function() {
					$scope.list = $scope.DepartmentName;
					var formData = {
						"PatientClass" : $scope.PatientClass,
						"AssignedPatientLocation" : $scope.AssignedPatientLocation,
						"AdmissionType" : $scope.AdmissionType,
						"doctor" : DoctorFormData,
						"Weight" : $scope.Weight,
						"Tempreture" : $scope.Tempreture,
						"Pressure" : $scope.Pressure,
						"Pulse" : $scope.Pulse,
						"BP" : $scope.BP,
						"department":formDataa
					};
					$scope.test = formData.department.DepartmentId;
					$scope.list = formData.DepartmentName;
					var response = $http.post('PostVisit', formData);
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
							<select data-ng-model="PatientClass">
								<option value="B">B-Obstetric</option>
								<option value="C">C- Commercial Account</option>
								<option value="E">E- Emergency</option>
								<option value="I">I- InPatient</option>
								<option value="N">N-Not Applicable</option>
								<option value="O">O- OutPatient</option>
								<option value="P">P- PreAdmit</option>
								<option value="R">R- RecurringPatient</option>
								<option value="U">U- UnKnown</option>
							</select>
						</div>
						<div class="form-group">
							<select data-ng-model="AssignedPatientLocation">
								<option value="O/R">O/R</option>
								<option value="Instate">Instate</option>

							</select>
						</div>
						<div class="form-group">
							<select data-ng-model="AdmissionType">
								<option value="A">A-Accident</option>
								<option value="C">C-Elective</option>
								<option value="E">E-Emergency</option>
								<option value="L">L-Labor and Delivery</option>
								<option value="N">N-Newborn</option>
								<option value="R">R-Routine</option>
								<option value="U">U-Urgent</option>

							</select>
						</div>
						
							<div class="form-group">
							<select data-ng-model="DoctorId"
								data-ng-change="onDoctorChange(itemSelected)">
								<option data-ng-repeat="x in Doctordata" value="{{ x.Id }}">
								{{
									x.Name }}</option>
							</select>
							</div>
						

						<div class="form-group">
							<label for="Weight">Weight</label> <input type="text"
								class="form-control" id="Weight"
								data-ng-model="Weight" placeholder="Email">
						</div>
						<div class="form-group">
							<label for="Tempreture">Tempreture </label> <input
								type="text" class="form-control" id="Tempreture"
								data-ng-model="Tempreture" placeholder="Email">
						</div>

						<div class="form-group">
							<label for="Pressure">Pressure </label> <input
								type="text" class="form-control" id="Pressure"
								data-ng-model="Pressure" placeholder="Email">
						</div>
						
						<div class="form-group">
							<label for="Pulse ">Pulse </label> <input
								type="text" class="form-control" id="Pulse "
								data-ng-model="Pulse " placeholder="Email">
						</div>
						
						<div class="form-group">
							<label for="BP">BP </label> <input
								type="text" class="form-control" id="BP"
								data-ng-model="BP" placeholder="Email">
						</div>
						
							<div class="form-group">
							<select data-ng-model="DepartmentId"
								data-ng-change="onCategoryChange(itemSelected)">
								<option data-ng-repeat="x in data" value="{{ x.DepartmentId }}">{{
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