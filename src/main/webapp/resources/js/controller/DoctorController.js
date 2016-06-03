adminApp.config(['$routeProvider',function($routeProvider) {
					$routeProvider
						.when(
								'/GetDoctor',
								{
									templateUrl : 'http://localhost:8080/eHealthService/GetDoctor',
									controller : 'GetDoctorController',
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
							'/EditDoctor/:id',
							{
								templateUrl : 'http://localhost:8080/eHealthService/EditDoc',
								controller : 'EditDocController',
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
									'/InsertDoctor',
									{
										templateUrl : 'http://localhost:8080/eHealthService/InsertDoc',
										controller : 'InsertDocController',
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
									'/DeleteDoctor/:id',
									{
										templateUrl : 'http://localhost:8080/eHealthService/GetDoctor',
										controller : 'DeleteDocController',
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
							'/Profile/:id',
							{
								templateUrl : 'http://localhost:8080/eHealthService/GetProfile',
								controller : 'ProfileController',
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

adminApp.controller('EditDocController', function($scope, $http,$routeParams,$window) {
	var formDataa;
	var RowId;
	var password;
	 $scope.alertstyle= {'visibility': 'hidden'};
		
	 $scope.closeAlert = function() {
		    $scope.message="";
		    $scope.alertstyle= {'visibility': 'hidden'};
		  };
	$scope.open2 = function() {
	    $scope.popup2.opened = true;
	  };

	  $scope.popup2 = {
	    opened: false
	  };
	
	$http.get("http://localhost:8080/eHealthService/GetAllDepartment").then(
			function(response) {
		
				$scope.data = response.data;
				$scope.departmentdata= response.data;
				
			});

	$http.get("http://localhost:8080/eHealthService/GetDoctorbyId/?id="
					+ $routeParams.id).then(function(response) {
						
						RowId = response.data.DoctorData.Id;
						$scope.Name = response.data.DoctorData.Name;
						$scope.Cnic = response.data.DoctorData.Cnic;
						$scope.Email = response.data.DoctorData.Email;
						$scope.HomeAddress =response.data.DoctorData.HomeAddress;
						$scope.OfficeAddress = response.data.DoctorData.OfficeAddress;
						$scope.Sex =response.data.DoctorData.Sex;
						$scope.BirthDate =response.data.DoctorData.BirthDate;
						//$scope.BirthDates =response.data.DoctorData.BirthDate;
						$scope.Password=response.data.DoctorData.Password;
						password=response.data.DoctorData.Password;
						$scope.Degree =response.data.DoctorData.Degree;
						$scope.Specialization =response.data.DoctorData.Specialization;
						$scope.DepartmentId = response.data.DoctorData.department.DepartmentId;
						$scope.ImageByte = response.data.ImageData;
						formDataa = {
								"DepartmentId" : response.data.DoctorData.department.DepartmentId
							};
	});
	
	
	
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
	$scope.submit = function() {
	var formData = {
			"Id" : RowId,
			"Name" : $scope.Name,
			"Email" : $scope.Email,
			"Cnic" : $scope.Cnic,
			"Password":$scope.Password,
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
			if(data.Status=="10")
			{
			$window.location.href="http://localhost:8080/eHealthService/admin#/GetDoctor";
			 $scope.alertstyle= {'visibility': 'hidden'};
			}
			else
			{
				$scope.message={type:'danger',msg:'Dcotor is already register'};
				$scope.alertstyle= {'visibility': 'visible'};
			}

		});
		response.error(function(data, status,
				headers, config) {
			alert("Exception details: "
					+ JSON.stringify({
						data : data
					}));
		});
	};
	
});



adminApp.controller('GetDoctorController', function($scope, $http) {
	
	
		$http.get("http://localhost:8080/eHealthService/GetAllDoctor").then(function(response) {
			$scope.test="adadad";
			$scope.alldoctor = response.data;
			
		});
});
adminApp.controller('DeleteDocController', function($scope, $http,$routeParams) {
	
	$http.get("http://localhost:8080/eHealthService/DeleteDoc/?id="+ $routeParams.id)
	.then(function(response) {
		alert("Dada");
		$http.get("http://localhost:8080/eHealthService/GetAllDoctor").then(function(response) {
			$scope.test="adadad";
			$scope.alldoctor = response.data;
			
		});
	});
});
adminApp.controller('InsertDocController', function($scope, $http,$window) {
	
	var formDataa;
	var contentinbyte;
	 $scope.alertstyle= {'visibility': 'hidden'};
		
	 $scope.closeAlert = function() {
		    $scope.message="";
		    $scope.alertstyle= {'visibility': 'hidden'};
		  };
	$scope.Sex="Male";
	$scope.DepartmentId="";
	 $scope.open2 = function() {
		    $scope.popup2.opened = true;
		  };

		  $scope.popup2 = {
		    opened: false
		  };
		  
	//Get all Department and Store in Dropdown
	$http.get("http://localhost:8080/eHealthService/GetAllDepartment").then(function(response) {

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
			"Cnic":$scope.Cnic,
			"Password":$scope.Password,
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
		var response = $http.post('http://localhost:8080/eHealthService/PostDoctor', formData);
		response.success(function(data, status, headers, config) {
			if(data.Status=="10")
			{
			$window.location.href="http://localhost:8080/eHealthService/admin#/GetDoctor";
			 $scope.alertstyle= {'visibility': 'hidden'};
			}
			else
			{
				$scope.message={type:'danger',msg:'Dcotor is already register'};
				$scope.alertstyle= {'visibility': 'visible'};
			}
			

		});
		response.error(function(data, status, headers, config) {
			alert("Exception details: " + JSON.stringify({
				data : data
			}));
		});

	};
});


adminApp.controller('ProfileController', function($scope, $http,$routeParams) {
	$http.get("http://localhost:8080/eHealthService/GetDoctorbyId/?id="
			+ $routeParams.id).then(function(response) {
				
				
				
				$scope.Name = response.data.DoctorData.Name;
				$scope.Email = response.data.DoctorData.Email;
				$scope.HomeAddress =response.data.DoctorData.HomeAddress;
				$scope.OfficeAddress = response.data.DoctorData.OfficeAddress;
				$scope.Sex =response.data.DoctorData.Sex;
				$scope.BirthDate =response.data.DoctorData.BirthDate;
				//$scope.BirthDates =response.data.DoctorData.BirthDate;
				$scope.Password=response.data.DoctorData.Password;
				
				$scope.Degree =response.data.DoctorData.Degree;
				$scope.Specialization =response.data.DoctorData.Specialization;
				$scope.DepartmentName = response.data.DoctorData.department.DepartmentName;
				$scope.ImageByte = response.data.ImageData;
				
});
});
