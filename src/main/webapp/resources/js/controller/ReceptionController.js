var adminApp = angular.module('AdminApp',["ngRoute","ngStorage","ngAnimate", "ui.bootstrap","angularUtils.directives.dirPagination"]);

	adminApp.config(['$routeProvider',
					function($routeProvider) {
						$routeProvider
						.when('/',
								{
										templateUrl : 'http://localhost:8080/eHealthService/',
										controller : 'DashboardController',
										resolve:{
											data:  function($localstorage,$location,$window){
											var result = JSON.parse($localstorage.get("ReceptionStatus"));
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
								.when('/ReceptionPage',
										{
											templateUrl : 'http://localhost:8080/eHealthService/ReceptionPage',
											controller : 'ReceptionPageController',
												resolve:{
													data:  function($localstorage,$location,$window){
													var result = JSON.parse($localstorage.get("ReceptionStatus"));
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
								
										.when('/login',
											{
													templateUrl : 'http://localhost:8080/eHealthService/receptionlogin',
													controller : 'receptionloginController',
													resolve:{
														data:  function($localstorage,$location,$window){
														var result = JSON.parse($localstorage.get("ReceptionStatus"));
														if(result)
														{
															$location.path("/");
														}
														
														}
													}
												})
												.when('/GetVisit',
										{
											templateUrl : 'http://localhost:8080/eHealthService/GetVisit',
											controller : 'GetAllVisitController',
											resolve:{
												data:  function($localstorage,$location,$window){
												var result = JSON.parse($localstorage.get("ReceptionStatus"));
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
										.when('/GetVisit/:cnic',
										{
											templateUrl : 'http://localhost:8080/eHealthService/GetVisit',
											controller : 'GetAllParamsVisitController',
											resolve:{
												data:  function($localstorage,$location,$window){
												var result = JSON.parse($localstorage.get("ReceptionStatus"));
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
														var result = JSON.parse($localstorage.get("ReceptionStatus"));
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
												.when('/AppointmentList',
														{
															templateUrl : 'http://localhost:8080/eHealthService/AppointmentList',
															controller : 'AppointmentListController',
															resolve:{
																data:  function($localstorage,$location,$window){
																var result = JSON.parse($localstorage.get("ReceptionStatus"));
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

	//Main Controller for Main VIew
	adminApp.controller('MainController', function($scope, $http,$localstorage,$window) {
		var result=JSON.parse($localstorage.get("ReceptionStatus"));
		if(result)
			{
				$scope.changevisibilty = {'visibility': 'visible'};
				var data=JSON.parse($localstorage.get("ReceptionData"));
				$scope.ReceptionName=data.staff.Name;
			}
		else
			$scope.changevisibilty = {'visibility': 'hidden'};
		$scope.logout=function()
		{
			$localstorage.clear();
			$scope.changevisibilty = {'visibility': 'hidden'};
			$window.location.href="http://localhost:8080/eHealthService/reception#/login";
			
		};
	});
	adminApp.controller('DashboardController', function($scope, $http,$localstorage,$window) {
		
	});
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

	adminApp.controller('ReceptionPageController', function($scope, $http,$window,$localstorage) {
		
		var data=JSON.parse($localstorage.get("ReceptionData"));
		var receptionId=data.staff.Id;
		
		$scope.changevisibilty = {'visibility': 'visible'};
		var DepartmentJson;
		var DoctorJson;
		var Patientjson;
		$http.get("http://localhost:8080/eHealthService/GetAllDepartment")
		.then(function(response) {
			$scope.data = response.data;
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
		$scope.onDoctorChange=function(item)
		{
			DoctorJson={
					"Id":$scope.DoctorId
			};
		};
	var SexText=["Ambiguous","Female","Male","Not applicable","Other","Unknown"];
	var SexValue=["A","F","M","N","O","U"];
		$scope.search = function() {
			var cnic = 0;
			var id = 0;

			if (angular.isUndefined($scope.PatientId) == false) {
				id = $scope.PatientId;
			}
			if (angular.isUndefined($scope.Cnic) == false) {
				cnic = $scope.Cnic;
			}
			alert(cnic);

			$http.get(
					"http://localhost:8080/eHealthService/SearchPatientbyIDCNIC/?id="
							+ id + "&cnic=" + cnic).then(function(response) {
				$scope.PatientId = response.data.PatientId;
				$scope.PatientName = response.data.PatientName;
				$scope.Cnic = response.data.Cnic;
				//calulcate age from date of birth
				var ageDifMs = Date.now() - response.data.DOB;
			    var ageDate = new Date(ageDifMs); // miliseconds from epoch
			    var age= Math.abs(ageDate.getUTCFullYear() - 1970);
				$scope.DOB=age;
				////
				for(var i=0; i<6; i++)
				{
					if(SexValue[i]==response.data.Sex)
						{
							$scope.Sex=SexText[i];
						}
				}
				
			});

		};
		
		$scope.submit=function()
		{
			PatientJson={
					"PatientId":$scope.PatientId
			};
			var formData = {
					"patient" : PatientJson,
					"department" : DepartmentJson,
					"doctor" : DoctorJson,
					"ReferFrom":"Receptionist"
				};
			var response = $http.post(
					'http://localhost:8080/eHealthService/PostVisitRequest',
					formData);
			response.success(function(data, status, headers, config) {
				alert("POST");
				$window.location.href="http://localhost:8080/eHealthService/reception#/ReceptionPage";

			});
			response.error(function(data, status, headers, config) {
				alert("Exception details: " + JSON.stringify({
					data : data
				}));
			});
		};
	});
	
	adminApp.controller('receptionloginController', function($scope, $http,$localstorage,$window) {
		
		$scope.submit=function()
		{
			var formData={ 
					UserName:$scope.UserName,
					Password:$scope.Password
			};
			var response = $http.post('http://localhost:8080/eHealthService/ReceptionistAuthenticate',formData);
			response.success(function(data, status,
					headers, config) {
				$scope.data=data;
			
				if(data.Status==10)
				{
					
						$localstorage.set("ReceptionStatus", JSON.stringify({"Status":"10"}));
						$localstorage.set("ReceptionData", JSON.stringify(data.StaffInfo));
						$window.location.href="http://localhost:8080/eHealthService/reception";
					
				}
				else
					{
						alert("Invalid User Name and Password");
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
	adminApp.controller('GetAllVisitController', function($scope, $http) {
		$scope.stylehistory= {'display': 'block'};
		$scope.search=function()
		{
		var SexText=["Ambiguous","Female","Male","Not applicable","Other","Unknown"];
		var SexValue=["A","F","M","N","O","U"];
		$http.get("http://localhost:8080/eHealthService/GetAllVisit/?cnic="+$scope.Cnic)
		.then(function(response) {
			
			$scope.PatientId = response.data.Patient.PatientId;
			$scope.PatientName = response.data.Patient.PatientName;
			$scope.Cnic = response.data.Patient.Cnic;
			//calculate age from date of birth
			
			$scope.DOB=response.data.Patient.DOB;
			for(var i=0; i<6; i++)
			{
				if(SexValue[i]==response.data.Patient.Sex)
					{
						$scope.Sex=SexText[i];
					}
			}
			
			$scope.VisitData=response.data.Visit;
			
		});
		};
	});
	adminApp.controller('GetAllParamsVisitController', function($scope, $http,$routeParams) {
		$scope.stylehistory= {'display': 'none'};
		var SexText=["Ambiguous","Female","Male","Not applicable","Other","Unknown"];
		var SexValue=["A","F","M","N","O","U"];
		$http.get("http://localhost:8080/eHealthService/GetAllVisit/?cnic="+$routeParams.cnic)
		.then(function(response) {
			
			$scope.PatientId = response.data.Patient.PatientId;
			$scope.PatientName = response.data.Patient.PatientName;
			$scope.Cnic = response.data.Patient.Cnic;
			//calculate age from date of birth
			
			$scope.DOB=response.data.Patient.DOB;
			for(var i=0; i<6; i++)
			{
				if(SexValue[i]==response.data.Patient.Sex)
					{
						$scope.Sex=SexText[i];
					}
			}
			
			$scope.VisitData=response.data.Visit;
			
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
	
	adminApp.controller('AppointmentListController', function($scope, $http) {
		
		$scope.search=function()
		{
			var json={
					"date":$scope.dt
			};
			var response = $http.post('http://localhost:8080/eHealthService/GetAppointmentList',json);
			response.success(function(data, status,
					headers, config) {
				$scope.data=data;
				alert("success");
			});
			response.error(function(data, status,
					headers, config) {
				alert("Exception details: "+ JSON.stringify({
							data : data
						}));
			});
		};
		$scope.process=function(DId,PId,DocId)
		{
			var formData = {
					"patient" : {"PatientId":PId},
					"department" :{"DepartmentId":DId},
					"doctor" : {"Id":DocId},
					"ReferFrom":"R/A"
				};
			var response = $http.post(
					'http://localhost:8080/eHealthService/PostVisitRequest',
					formData);
			response.success(function(data, status, headers, config) {
				alert("POST");
				$window.location.href="http://localhost:8080/eHealthService/reception#/ReceptionPage";

			});
			response.error(function(data, status, headers, config) {
				alert("Exception details: " + JSON.stringify({
					data : data
				}));
			});
		};
		
	});
	