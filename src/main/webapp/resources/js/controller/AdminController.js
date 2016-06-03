var adminApp = angular.module('AdminApp',["ngRoute","UserValidation","ngResource","ngStorage","mui","angularUtils.directives.dirPagination","ngAnimate", "ui.bootstrap"]);
adminApp.config(['$routeProvider',function($routeProvider) {
				$routeProvider.when('/',
								{
									templateUrl : 'http://localhost:8080/eHealthService/',
									controller : 'DashboardController',
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
										'/login',
										{
											templateUrl : 'http://localhost:8080/eHealthService/login',
											controller : 'LoginController',
											resolve:{
												data:  function($localstorage,$location,$window){
												var result = JSON.parse($localstorage.get("Admin"));
												if(result)
												{
													$location.path("/");
												}
												
												}
											}
										})
								.when(
										'/StaffAccount',
										{
											templateUrl : 'http://localhost:8080/eHealthService/StaffAccount',
											controller : 'StaffAccountController',
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
										.when('/PatientHistory',
												{
													templateUrl : 'http://localhost:8080/eHealthService/PatientHistory',
													controller : 'PatientHistoryController',
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
												.when('/ShowTreatment/:id',
												{
													templateUrl : 'http://localhost:8080/eHealthService/ShowTreatment',
													controller : 'ShowTreatmentController',
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
angular.module('UserValidation', []).directive('validPasswordC', function () {
    return {
        require: 'ngModel',
        link: function (scope, elm, attrs, ctrl) {
            ctrl.$parsers.unshift(function (viewValue, $scope) {
                var noMatch = viewValue != scope.userForm.password.$viewValue
                ctrl.$setValidity('noMatch', !noMatch)
            })
        }
    }
})

//Main Controller for Main VIew
adminApp.controller('MainController', function($scope, $http,$localstorage,$window) {
	var result=JSON.parse($localstorage.get("Admin"));

	if(result)
		$scope.changevisibilty = {'visibility': 'visible'};
	else
		$scope.changevisibilty = {'visibility': 'hidden'};
	$scope.logout=function()
	{
		$localstorage.clear();
		$scope.changevisibilty = {'visibility': 'hidden'};
		$window.location.href="http://localhost:8080/eHealthService/admin#/login";
		
	};
	//pagination Control
	  $scope.currentPage = 1;
	  $scope.pageSize = 5;
	  
});

//app Factory for Local Storage
adminApp.factory('$localstorage', ['$window', function($window) {
	  return {
	    set: function(key, value) {
	      $window.localStorage[key] = value;
	    },
	    get: function(key, defaultValue) {
	      return $window.localStorage[key] || false;
	    },
	    setObject: function(key, value) {
	      $window.localStorage[key] = JSON.stringify(value);
	    },
	    getObject: function(key) {
	      if($window.localStorage[key] != undefined){
	        return JSON.parse( $window.localStorage[key] || false );
	      }
	      return false;   
	    },
	    remove: function(key){
	      $window.localStorage.removeItem(key);
	    },
	    clear: function(){
	      $window.localStorage.clear();
	    }
	  }
	}]);

adminApp.factory("flash", function($rootScope) {
	  var queue = [];
	  var currentMessage = "";

	  $rootScope.$on("$routeChangeSuccess", function() {
	    currentMessage = queue.shift() || "";
	  });

	  return {
	    setMessage: function(message) {
	      queue.push(message);
	    },
	    getMessage: function() {
	      return currentMessage;
	    }
	  };
	});

//filter for caluclate age from DOB
adminApp.filter('ageFilter', function() {
     function calculateAge(birthday) { // birthday is a date
    	 var ageDifMs = Date.now() - birthday;
		    var ageDate = new Date(ageDifMs); // miliseconds from epoch
		    return  Math.abs(ageDate.getUTCFullYear() - 1970);
     }

     return function(birthdate) { 
           return calculateAge(birthdate);
     }; 
});

adminApp.controller('DashboardController', function($scope, $http,$window) {

});


adminApp.controller('StaffAccountController', function($scope, $http,$window,$localstorage) {
	var RowId;
	
	$scope.search=function()
	{
		alert($scope.Cnic);
		$http.get("http://localhost:8080/eHealthService/GetStaffByCnic/?cnic="+$scope.Cnic)
		.then(function(response) {
			
			$scope.StaffName=response.data.StaffData.Name;
			$scope.RoleName=response.data.StaffData.roles.RoleName;
			$scope.data=response.data.ImageData;
			$scope.ImageByte=response.data.ImageData;
			$scope.UserName=response.data.StaffData.Email;
			RowId=response.data.StaffData.Id;
			
		});
	};
	
	$scope.submit=function()
	{
		var AccountJson={
				"UserName":$scope.UserName,
				"Password":$scope.Password,
				"staff":{"Id":RowId}
		};

		var response = $http.post('http://localhost:8080/eHealthService/PostAccount',AccountJson);
		response.success(function(data, status,
				headers, config) {
			alert("POST");

		});
		response.error(function(data, status,
				headers, config) {
			alert("Exception details: "+ JSON.stringify({
						data : data
				}));
		});
	};
	
	
});
adminApp.controller('LoginController', function($scope, $http,$window,$localstorage,flash) {
	//scope.show=false;
	 flash.setMessage(message);
	 
	 $scope.alertstyle= {'visibility': 'hidden'};
	
	 $scope.closeAlert = function() {
		    $scope.message="";
		    $scope.alertstyle= {'visibility': 'hidden'};
		  };
	$scope.submit=function()
	{
		var formData={ 
				UserName:$scope.UserName,
				Password:$scope.Password
		};
		var response = $http.post('http://localhost:8080/eHealthService/LoginAuthentication',formData);
		response.success(function(data, status,
				headers, config) {
			$scope.data=data;
		
			if(data.Status==10)
			{
					$localstorage.set("Admin", JSON.stringify({"Status":"10","Description":"Admin is logged"}));
					$window.location.href="http://localhost:8080/eHealthService/admin";
				
			}
			else
				{
				
					
					alert("Invalid User Name and Password");
					 $scope.alertstyle= {'visibility': 'visible'};
					$scope.message={type:"danger",msg:"Invalid User name and Password"};
				}

		});
		response.error(function(data, status,
				headers, config) {
			alert("Exception details: "+ JSON.stringify({
						data : data
					}));
		});
		
	};
	
});


adminApp.controller('PatientHistoryController', function($scope, $http) {
	$scope.search=function()
	{
		var searchjson={
				"DepartmentId":$scope.DepartmentId,
				"DoctorId":$scope.DoctorId,
				"date":$scope.dt
		};
		
		var response = $http.post('http://localhost:8080/eHealthService/FilterData',searchjson);
		response.success(function(data, status,
				headers, config) {
			$scope.data=data;

		});
		response.error(function(data, status,
				headers, config) {
			alert("Exception details: "+ JSON.stringify({
						data : data
				}));
		});
		
	};
	
	$http.get("http://localhost:8080/eHealthService/GetAllDepartment")
	.then(function(response) {
		$scope.Deptdata = response.data;
	});
	$scope.onDepartmentChange=function(item)
	{
		DepartmentJson={
				"DepartmentId":$scope.DepartmentId
		};
		$http.get("http://localhost:8080/eHealthService/SearchDoctorbyDepartment/?id="+$scope.DepartmentId)
		.then(function(response) {
			$scope.DoctorData = response.data;
		});
	}
	$http.get("http://localhost:8080/eHealthService/GetPatientHistory")
	.then(function(response) {
		
		//$scope.data=response.data;
		
	});
});

adminApp.controller('ShowTreatmentController', function($scope, $http,$routeParams) {
	$http.get("http://localhost:8080/eHealthService/GetVisitTreatment/?id="+$routeParams.id)
	.then(function(response) {
		$scope.PatientName=response.data.patientVisit.patient.PatientName
		$scope.PatientClass=response.data.patientVisit.PatientClass;
		$scope.AssignedPatientLocation=response.data.patientVisit.AssignedPatientLocation;
		$scope.AdmissionType=response.data.patientVisit.AdmissionType;
		$scope.Weight=response.data.patientVisit.Weight;
		 $scope.Tempreture=response.data.patientVisit.Tempreture;
		$scope.Pressure=response.data.patientVisit.Pressure;
		$scope.Pulse=response.data.patientVisit.Pulse;
		$scope.BP=response.data.patientVisit.BP;
		$scope.Symptom=response.data.Symptom;
		$scope.Investigation=response.data.Investigation;
		$scope.PatientProcedure=response.data.PatientProcedure;

	});
	
});


 
// Department Module Controller Define Here

/*adminApp.controller('GetDepartmentsController', function($scope, $http) {
	$http.get("http://localhost:8080/eHealthService/GetAllDepartment")
			.then(function(response) {
				$scope.data = response.data;
			});
});

adminApp.controller('InsertDeptController', function($scope, $http) {
	$scope.headerText = 'InsertDepartmnet';
	$scope.submit = function() {
		$scope.list = $scope.DepartmentName;
		var formData = {
			"DepartmentName" : $scope.DepartmentName,
			"DepartmentDescription" : $scope.DepartmentDescription,
		};
		$scope.list = formData.DepartmentName;
		var response = $http.post(
				'http://localhost:8080/eHealthService/PostDepartment',
				formData);
		response.success(function(data, status, headers, config) {
			$scope.list = data;

		});
		response.error(function(data, status, headers, config) {
			alert("Exception details: " + JSON.stringify({
				data : data
			}));
		});
	};
});

adminApp.controller('EditDeptController', function($scope, $routeParams,
		$http) {
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
			$scope.list = data;

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

adminApp.controller('GetDoctorController', function($scope, $http) {
	
		$http.get("http://localhost:8080/eHealthService/GetAllDoctor").then(function(response) {
			$scope.test="adadad";
			$scope.alldoctor = response.data;
			
		});
});
adminApp.controller('InsertDocController', function($scope, $http) {
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
});
	
*/

//Department Module Ccontroller Enf Here

