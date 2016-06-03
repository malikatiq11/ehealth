<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html data-ng-app="formSubmit">
<head>
<meta charset="ISO-8859-1">
<title>Insert Treatment</title>

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
				
				var formDataa={
						VisitId:"1"
				};
			
				$scope.submit = function() {
					
			
					var formData = {
						"patientVisit" : formDataa,
						"Symptom" : $scope.Symptom,
						"Investigation" : $scope.Investigation,
						"PatientProcedure" : $scope.PatientProcedure
						
					};
					alert("Sdada");
					var response = $http.post('PostTreatment', formData);
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
							<label for="Symptom">Symptom</label> <input type="text"
								class="form-control" id="Symptom"
								data-ng-model="Symptom" placeholder="Email">
						</div>
						<div class="form-group">
							<label for="Investigation">Investigation </label> <input
								type="text" class="form-control" id="Investigation"
								data-ng-model="Investigation" placeholder="Email">
						</div>

						<div class="form-group">
							<label for="PatientProcedure">PatientProcedure </label> <input
								type="text" class="form-control" id="PatientProcedure"
								data-ng-model="PatientProcedure" placeholder="Email">
						</div>
						
						

						
						<button type="submit" class="btn btn-default">Submit</button>

					</form>
				</div>
			</div>
		</div>

	</div>

</body>
</html>