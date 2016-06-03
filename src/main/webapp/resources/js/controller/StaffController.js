

adminApp.config(['$routeProvider',function($routeProvider) {
					$routeProvider
							
						.when(
								'/GetStaff',
								{
									templateUrl : 'http://localhost:8080/eHealthService/GetStaff',
									controller : 'GetStaffController',
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
							'/EditStaff/:id',
							{
								templateUrl : 'http://localhost:8080/eHealthService/EditStaff',
								controller : 'EditStaffController',
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
									'/InsertStaff',
									{
										templateUrl : 'http://localhost:8080/eHealthService/InsertStaff',
										controller : 'InsertStaffController',
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
									'/DeleteStaff/:id',
									{
										templateUrl : 'http://localhost:8080/eHealthService/GetStaff',
										controller : 'DeleteStaffController',
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



adminApp.controller('EditStaffController', function($scope, $http,$routeParams,$window) {
	var formDataa;
	var RowId;
	var RoleJson;

	
	$http.get("GetAllDepartment").then(function(response) {

		$scope.data = response.data;
	});
	$http.get("GetAllRoles").then(function(response) {

		$scope.RoleData = response.data;
	});

	$http.get(
			"http://localhost:8080/eHealthService/GetStaffbyId/?id="
					+ $routeParams.id).then(function(response) {
						
		RowId = response.data.StaffData.Id;
	
		$scope.Name = response.data.StaffData.Name;
		$scope.Cnic=response.data.StaffData.Cnic;
		$scope.Gender=response.data.StaffData.Gender;
	
		$scope.Email =response.data.StaffData.Email;
		$scope.MobileNo = response.data.StaffData.MobileNo;
		$scope.DepartmentId = response.data.StaffData.department.DepartmentId;
		$scope.RoleId=response.data.StaffData.roles.RoleId;
	
		$scope.ImageByte = response.data.ImageData;
		formDataa = {
				"DepartmentId" :response.data.StaffData.department.DepartmentId
			};
		RoleJson = {
				"RoleId" : response.data.StaffData.roles.RoleId
			};
	});
	
	$scope.onCategoryChange = function(item) {
		formDataa = {
			"DepartmentId" : $scope.DepartmentId
		};

	};
	$scope.onRoleChange = function(item) {
		RoleJson = {
			"RoleId" : $scope.RoleId
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
		
		var formData = {
			"Id" : RowId,
			"Name" : $scope.Name,
			"Cnic":$scope.Cnic,
			"Gender":$scope.Gender,
			"Email" : $scope.Email,
			"MobileNo" : $scope.MobileNo,
			"department" : formDataa,
			"Content" : $scope.ImageByte,
			"roles":RoleJson
		};

		var response = $http.post(
				'UpdateStaff', formData);
		response.success(function(data, status,
				headers, config) {
			$window.location.href="http://localhost:8080/eHealthService/admin#/GetStaff"

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
	
});



adminApp.controller('GetStaffController', function($scope, $http) {
	
	
	$http.get("http://localhost:8080/eHealthService/GetAllStaff").then(function(response) {
		$scope.myData = response.data;
		$scope.data = response.data;
	});
});
adminApp.controller('DeleteStaffController', function($scope, $http,$routeParams) {
	
	$http.get("http://localhost:8080/eHealthService/DeleteStaff/?id="+ $routeParams.id)
	.then(function(response) {
		
		$http.get("http://localhost:8080/eHealthService/GetAllStaff").then(function(response) {
			$scope.myData = response.data;
			$scope.data = response.data;
		});
	});
});
adminApp.controller('InsertStaffController', function($scope, $http,$window) {
	var formDataa;
	var contentinbyte;
	var RoleJson;
	var RowId;
	var DPJson;
	var DoctorJson;
	$scope.changevisibilty = {'visibility': 'hidden'}; 
	 $scope.alertstyle= {'visibility': 'hidden'};
	 $scope.Gender="M"
		
	 $scope.closeAlert = function() {
		    $scope.message="";
		    $scope.alertstyle= {'visibility': 'hidden'};
		  };
	//Get all Department and Store in Dropdown
			$http.get("http://localhost:8080/eHealthService/GetAllDepartment").then(function(response) {

				$scope.data = response.data;
			});
	
			$http.get("http://localhost:8080/eHealthService/GetAllRoles").then(function(response) {
			
				$scope.RoleData = response.data;
			});
			
			$http.get("http://localhost:8080/eHealthService/GetAllDoctor").then(
					function(response) {
				
						$scope.DoctorData = response.data;
						
						
					});
		
			$scope.onRoleChange = function(item) {
				if($scope.RoleId==1)
				{
					$scope.changevisibilty = {'visibility': 'visibile'}; 
				}
				else
				{
					$scope.changevisibilty = {'visibility': 'hidden'}; 
				}
				RoleJson = {
					"RoleId" : $scope.RoleId
				};

			};
	
			$scope.onCategoryChange = function(item) {
				formDataa = {
					"DepartmentId" : $scope.DepartmentId
				};

			};
			$scope.onDoctorChange = function(item) {
				DoctorJson = {
					"Id" : $scope.DoctorId
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
				var formData = {
						"Id" : RowId,
						"Name" : $scope.Name,
						"Cnic":$scope.Cnic,
						"Email" : $scope.Email,
						"Gender":$scope.Gender,
						"MobileNo" : $scope.MobileNo,
						"department" : formDataa,
						"Content" : contentinbyte,
						"roles":RoleJson
					};
				
				DPJson={
						"doctor":DoctorJson
				};
			
				var WrapperJson={
						"staff":formData,
						"dp":DPJson
				}
				var response = $http.post('http://localhost:8080/eHealthService/PostStaff', WrapperJson);
				response.success(function(data, status, headers, config) {
					if(data.Status=="10")
					{
					$window.location.href="http://localhost:8080/eHealthService/admin#/GetStaff";
					 $scope.alertstyle= {'visibility': 'hidden'};
					}
					else
					{
						$scope.message={type:'danger',msg:'Staff is already register'};
						$scope.alertstyle= {'visibility': 'visible'};
					}

				});
				response.error(function(data, status, headers, config) {
					alert("Exception details: " + JSON.stringify({
						data : data
					}));
				});

				//Empty list data after process
				//$scope.list = [];

			};
});
