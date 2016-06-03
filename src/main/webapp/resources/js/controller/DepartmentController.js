

adminApp.config(['$routeProvider',function($routeProvider) {
					$routeProvider
							.when(
									'/GetDepartments',
									{
										templateUrl : 'http://localhost:8080/eHealthService/GetDepartments',
										controller : 'GetDepartmentsController',
										resolve:{
											data:  function($localstorage,$location,$window){
											var result = JSON.parse($localstorage.get("Admin"));
											if(result)
											{
												if (result.Status!="10")
													$location.path("login");
											}
											else
												$location.path("login");
											}
										}
									})
							.when(
									'/InsertDept',
									{
										templateUrl : 'http://localhost:8080/eHealthService/InsertDept',
										controller : 'InsertDeptController',
										resolve:{
											data:  function($localstorage,$location,$window){
											var result = JSON.parse($localstorage.get("Admin"));
											if(result)
											{
												if (result.Status!="10")
													$location.path("login");
											}
											else
												$location.path("login");
											}
										}
									})
							.when(
									'/EditDept/:id',
									{
										templateUrl : 'http://localhost:8080/eHealthService/EditDept',
										controller : 'EditDeptController',
										resolve:{
											data:  function($localstorage,$location,$window){
											var result = JSON.parse($localstorage.get("Admin"));
											if(result)
											{
												if (result.Status!="10")
													$location.path("login");
											}
											else
												$location.path("login");
											}
										}
									})
							.when(
									'/DeleteDept/:id',
									{
										templateUrl : 'http://localhost:8080/eHealthService/GetDepartments',
										controller : 'DeleteDepartmentController',
										resolve:{
											data:  function($localstorage,$location,$window){
											var result = JSON.parse($localstorage.get("Admin"));
											if(result)
											{
												if (result.Status!="10")
													$location.path("login");
											}
											else
												$location.path("login");
											}
										}
									});
							

				} ]);

adminApp.controller('GetDepartmentsController', function($scope, $http) {
	

	$http.get("http://localhost:8080/eHealthService/GetAllDepartment")
			.then(function(response) {
				$scope.data = response.data;
			});
	 
	
	  
});

adminApp.controller('InsertDeptController', function($scope, $http,$window) {
	 $scope.alertstyle= {'visibility': 'hidden'};
		
	 $scope.closeAlert = function() {
		    $scope.message="";
		    $scope.alertstyle= {'visibility': 'hidden'};
		  };
	$scope.headerText = 'InsertDepartmnet';
	$scope.submit = function() {
		$scope.list = $scope.DepartmentName;
		var formData = {
			"DepartmentName" : $scope.DepartmentName,
			"DepartmentDescription" : $scope.DepartmentDescription,
		};
		var response = $http.post(
				'http://localhost:8080/eHealthService/PostDepartment',
				formData);
		response.success(function(data, status, headers, config) {
			if(data.Status=="10")
			{
			$window.location.href="http://localhost:8080/eHealthService/admin/#/GetDepartments";
			 $scope.alertstyle= {'visibility': 'hidden'};
			}
			else
			{
				 $scope.alertstyle= {'visibility': 'visible'};
				$scope.message={type:"danger",msg:"Department name is already Register"};
			}

		});
		response.error(function(data, status, headers, config) {
			alert("Exception details: " + JSON.stringify({
				data : data
			}));
		});
	};
});

adminApp.controller('EditDeptController', function($scope, $routeParams,
		$http,$window) {
	$scope.alertstyle= {'visibility': 'hidden'};
	
	 $scope.closeAlert = function() {
		    $scope.message="";
		    $scope.alertstyle= {'visibility': 'hidden'};
		  };
	var RowId;
	$http.get(
			"http://localhost:8080/eHealthService/GetDepartmentbyId/?id="
					+ $routeParams.id).then(function(response) {
		RowId = response.data.DepartmentId;
		$scope.DepartmentName = response.data.DepartmentName;
		$scope.DepartmentDescription = response.data.DepartmentDescription;
	});
	$scope.submit = function() {
		var formData = {
			"DepartmentId" : RowId,
			"DepartmentName" : $scope.DepartmentName,
			"DepartmentDescription" : $scope.DepartmentDescription,
		};

		var response = $http.post(
				'http://localhost:8080/eHealthService/UpdateDepartment',
				formData);
		response.success(function(data, status, headers, config) {
			if(data.Status=="10")
			{
			 $window.location.href="http://localhost:8080/eHealthService/admin/#/GetDepartments";
			 $scope.alertstyle= {'visibility': 'hidden'};
			}
			else
			{
				 $scope.alertstyle= {'visibility': 'visible'};
				$scope.message={type:"danger",msg:"Department name is already Register"};
			}

		});
		response.error(function(data, status, headers, config) {
			alert("Exception details: " + JSON.stringify({
				data : data
			}));
		});
	};
});
adminApp.controller('DeleteDepartmentController',
				function($scope, $http, $routeParams) {
					$http.get("http://localhost:8080/eHealthService/DeleteDept/?id="+ $routeParams.id)
					.then(function(response) {
						$http.get("http://localhost:8080/eHealthService/GetAllDepartment")
						.then(function(response) {
							$scope.data = response.data;
								});
					});
				});



