var adminApp = angular.module('AdminApp',["ngStorage","ngRoute","ngAnimate", "ui.bootstrap","angularUtils.directives.dirPagination"]);

	adminApp.config(['$routeProvider',
					function($routeProvider) {
						$routeProvider
								.when('/',
										{
											templateUrl : 'http://localhost:8080/eHealthService/',
											controller : 'DashBoardController',
												resolve:{
													data:  function($localstorage,$location,$window){
													var result = JSON.parse($localstorage.get("PAStatus"));
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
								.when('/GetRequest',
										{
											templateUrl : 'http://localhost:8080/eHealthService/GetRequest',
											controller : 'GetRequestController',
											resolve:{
												data:  function($localstorage,$location,$window){
												var result = JSON.parse($localstorage.get("PAStatus"));
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
													templateUrl : 'http://localhost:8080/eHealthService/PAlogin',
													controller : 'PAloginController',
													resolve:{
														data:  function($localstorage,$location,$window){
														var result = JSON.parse($localstorage.get("PAStatus"));
														if(result)
														{
															$location.path("/");
														}
														
														}
													}
											})
								.when(
										'/RequestDetails/:id',
										{
											templateUrl : 'http://localhost:8080/eHealthService/RequestDetails',
											controller : 'RequestDetailsController',
											resolve:{
												data:  function($localstorage,$location,$window){
												var result = JSON.parse($localstorage.get("PAStatus"));
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
										.when('/SendPatient/:id',
												{
													templateUrl : 'http://localhost:8080/eHealthService/GetRequest',
													controller : 'SendPatientController'
												})
										.when('/GetVisit',
										{
											templateUrl : 'http://localhost:8080/eHealthService/GetVisit',
											controller : 'GetAllVisitController',
												resolve:{
													data:  function($localstorage,$location,$window){
													var result = JSON.parse($localstorage.get("PAStatus"));
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
													var result = JSON.parse($localstorage.get("PAStatus"));
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
															var result = JSON.parse($localstorage.get("PAStatus"));
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
												.when('/LaboratoryObservation',
														{
															templateUrl : 'http://localhost:8080/eHealthService/LaboratoryObervation',
															controller : 'LaboratoryObervationController',
																resolve:{
																	data:  function($localstorage,$location,$window){
																	var result = JSON.parse($localstorage.get("PAStatus"));
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
														.when('/LaboratoryObservation/:cnic',
														{
															templateUrl : 'http://localhost:8080/eHealthService/LaboratoryObervation',
															controller : 'LaboratoryParamsObervationController',
																resolve:{
																	data:  function($localstorage,$location,$window){
																	var result = JSON.parse($localstorage.get("PAStatus"));
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
														.when('/ObservationDetails/:id',
																{
																	templateUrl : 'http://localhost:8080/eHealthService/ObservationDetails',
																	controller : 'ObservationDetailsController',
																		resolve:{
																			data:  function($localstorage,$location,$window){
																			var result = JSON.parse($localstorage.get("PAStatus"));
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
																.when('/ObservationDetails/:id',
																		{
																			templateUrl : 'http://localhost:8080/eHealthService/ObservationDetails',
																			controller : 'ObservationDetailsController',
																				resolve:{
																					data:  function($localstorage,$location,$window){
																					var result = JSON.parse($localstorage.get("PAStatus"));
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
																	.when('/PreviousVisit',
																			{
																				templateUrl : 'http://localhost:8080/eHealthService/PreviousVisit',
																				controller : 'PreviousVisitController',
																					resolve:{
																						data:  function($localstorage,$location,$window){
																						var result = JSON.parse($localstorage.get("PAStatus"));
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
																	.when('/AddAppointment',
																			{
																				templateUrl : 'http://localhost:8080/eHealthService/AddAppointment',
																				controller : 'AddAppointmentController',
																					resolve:{
																						data:  function($localstorage,$location,$window){
																						var result = JSON.parse($localstorage.get("PAStatus"));
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
	adminApp.factory('myService', function() {
		 var savedData = {}
		 function set(data) {
		   savedData = data;
		 }
		 function get() {
		  return savedData;
		 }

		 return {
		  set: set,
		  get: get
		 }

		});
	//Main Controller for Main VIew
	adminApp.controller('MainController', function($scope, $http,$localstorage,$window) {
		var result=JSON.parse($localstorage.get("PAStatus"));
		if(result)
			{
				$scope.changevisibilty = {'visibility': 'visible'};
				var data=JSON.parse($localstorage.get("PAData"));
				$scope.PAName=data.staff.Name;
			}
		else
			$scope.changevisibilty = {'visibility': 'hidden'};
		$scope.logout=function()
		{
			$localstorage.clear();
			$scope.changevisibilty = {'visibility': 'hidden'};
			$window.location.href="http://localhost:8080/eHealthService/PA#/login";
			
		};
	});
	adminApp.controller('PAloginController', function($scope, $http,$localstorage,$window) {
		$scope.submit=function()
		{
			var formData={ 
					UserName:$scope.UserName,
					Password:$scope.Password
			};
			var response = $http.post('http://localhost:8080/eHealthService/PAAuthenticate',formData);
			response.success(function(data, status,
					headers, config) {
				$scope.data=data;
			
				if(data.Status==10)
				{
					
					
						$localstorage.set("PAStatus", JSON.stringify({"Status":"10"}));
						$localstorage.set("PAData", JSON.stringify(data.StaffInfo));
						$localstorage.set("DoctorInfo", JSON.stringify(data.DoctorInfo));
						$window.location.href="http://localhost:8080/eHealthService/PA";
					
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
	adminApp.controller('GetRequestController', function($scope, $http,$localstorage) {
		var DepartmentJson;
		var DoctorJson;
		var Patientjson;
		var result=JSON.parse($localstorage.get("DoctorInfo"));
		var Id=result.doctor.Id;
		
		$http.get("http://localhost:8080/eHealthService/GetPatientByDoctor/?id="+Id)
		.then(function(response) {
			$scope.data = response.data;
		});
		
	});
	
	
	adminApp.controller('SendPatientController', function($scope, $http,$routeParams,$localstorage) {
		
		var UpdateJson;
		var result=JSON.parse($localstorage.get("DoctorInfo"));
		var DocId=result.doctor.Id;
		alert(DocId);
		var PanelJson={
				"requestpanel":{"ReqId":$routeParams.id},
				"doctor":{"Id":DocId}
		};
		var response = $http.post('http://localhost:8080/eHealthService/PostDoctorPanel',PanelJson);
		response.success(function(data, status, headers, config) {
			
			$http.get("http://localhost:8080/eHealthService/GetRequestDetails/?id="+$routeParams.id)
			.then(function(response) {
				UpdateJson={
						"ReqId":response.data.ReqId,
						"patient":{"PatientId":response.data.patient.PatientId},
						"department":{"DepartmentId":response.data.department.DepartmentId},
						"doctor":{"Id":response.data.doctor.Id},
						"Status":"Sent",
						"ReferFrom":response.data.ReferFrom
				}
				var res = $http.post('http://localhost:8080/eHealthService/UpdateVisitRequest', UpdateJson);
				res.success(function(data, status, headers, config) {
					var result=JSON.parse($localstorage.get("DoctorInfo"));
					var Id=result.doctor.Id;
				
					$http.get("http://localhost:8080/eHealthService/GetPatientByDoctor/?id="+Id)
					.then(function(response) {
						$scope.data = response.data;
					});
					
				});
				res.error(function(data, status, headers, config) {
					alert("Exception details: " + JSON.stringify({
						data : data
					}));
				});
			});
			
			
		});
		response.error(function(data, status, headers, config) {
			alert("Exception details: " + JSON.stringify({
				data : data
			}));
		});
	
		
	});
	adminApp.controller('RequestDetailsController', function($scope, $http,$routeParams,$window) {
		$scope.CalculateAge=function CalculateAge()
		{
			$scope.message="sdasdsadasda";
			return "zangi kam chala parha apna to";
		};
		
		var DepartmentJson;
		var DoctorJson;
		var PatientJson;
		var Updatejson;
		var SexText=["Ambiguous","Female","Male","Not applicable","Other","Unknown"];
		var SexValue=["A","F","M","N","O","U"];
		$http.get("http://localhost:8080/eHealthService/GetRequestDetails/?id="+$routeParams.id)
		.then(function(response) {
			UpdateJson={
					"ReqId":response.data.ReqId,
					"patient":{"PatientId":response.data.patient.PatientId},
					"department":{"DepartmentId":response.data.department.DepartmentId},
					"doctor":{"Id":response.data.doctor.Id},
					"Status":"Pending",
					"ReferFrom":response.data.ReferFrom
			};
		//	alert(response.data.ReferFrom)
			$scope.PatientId = response.data.patient.PatientId;
			$scope.PatientName = response.data.patient.PatientName;
			$scope.Cnic = response.data.patient.Cnic;
			//calculate age from date of birth
			var ageDifMs = Date.now() - response.data.patient.DOB;
		    var ageDate = new Date(ageDifMs); // miliseconds from epoch
		    var age= Math.abs(ageDate.getUTCFullYear() - 1970);
			$scope.DOB=age;
			/////
			$scope.DepartmentId = response.data.department.DepartmentName;
			$scope.DoctorId = response.data.doctor.Name;
			for(var i=0; i<6; i++)
			{
				if(SexValue[i]==response.data.patient.Sex)
					{
						$scope.Sex=SexText[i];
					}
			}
			
			DepartmentJson={
					DepartmentId:response.data.department.DepartmentId
			};
			
			DoctorJson={
					Id:response.data.doctor.Id
			};
			
			PatientJson={
					PatientId:response.data.patient.PatientId
			};
			
		});
		
		$scope.submit = function() {
			
			var formData = {
				"PatientClass" : $scope.PatientClass,
				"patient":PatientJson,
				"AssignedPatientLocation" : $scope.AssignedPatientLocation,
				"AdmissionType" : $scope.AdmissionType,
				"doctor" : DoctorJson,
				"Weight" : $scope.Weight,
				"Tempreture" : $scope.Tempreture,
				"Pressure" : $scope.Pressure,
				"Pulse" : $scope.Pulse,
				"BP" : $scope.BP,
				"department":DepartmentJson
			};
		
			
			var response = $http.post('http://localhost:8080/eHealthService/PostVisit',{"visit":formData,"ReqId":UpdateJson.ReqId});
			response.success(function(data, status, headers, config) {
				var res = $http.post('http://localhost:8080/eHealthService/UpdateVisitRequest', UpdateJson);
				res.success(function(data, status, headers, config) {
					alert("Done");
					$window.location.href="http://localhost:8080/eHealthService/PA#/GetRequest";
					
				});
				res.error(function(data, status, headers, config) {
					alert("Exception details: " + JSON.stringify({
						data : data
					}));
				});

			});
			response.error(function(data, status, headers, config) {
				alert("Exception details: " + JSON.stringify({
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
	
	
	adminApp.controller('LaboratoryObervationController', function($scope, $http,myService,$localstorage) {
		
		$scope.labstyle= {'display': 'block'};
		$scope.labstyle1= {'display': 'none'};
		var SexText=["Ambiguous","Female","Male","Not applicable","Other","Unknown"];
		var SexValue=["A","F","M","N","O","U"];
		var i=0;
		
		$scope.search=function()
		{
			var url;
			if($scope.labsSelection==1)
			{
				url="http://localhost:8080/LIS/GetObservation/?cnic="+$scope.Cnic;
			}
			else if($scope.labsSelection==2)
			{
				url="http://localhost:8080/RIS/GetObservationDetails?cnic="+$scope.Cnic+"&Name=HIMS";
			}
			$http.get(url)
			.then(function(response) {
				myService.set(response);
				$localstorage.set("transfer",JSON.stringify(response));
				//$scope.test=response.data.Description;
				var responseJson={
						
						"Status":response.data.Status,
						"Description":response.data.Description
				};
				//alert(responseJson.Description);
				var res = $http.post('http://localhost:8080/eHealthService/ParseObservationMessage',responseJson);
				res.success(function(data, status, headers, config) {
				//	myService.set(data);
					$scope.TestName=data.TestName;
					$scope.TestDate=data.TestDate;
					$scope.PatientName=data.Patient.PatientName;
					$scope.Cnic=data.Patient.Cnic;
					$scope.DOB=data.Patient.DOB;
					$scope.PatientName=data.Patient.PatientName;
					for(var i=0; i<6; i++)
					{
						if(SexValue[i]==data.Patient.Sex)
							{
								$scope.Sex=SexText[i];
							}
					}
					$scope.Email=data.Patient.Email;
					$scope.FamilyName=data.Patient.FamilyName;
					
					
				});
				res.error(function(data, status, headers, config) {
					alert("Exception details: " + JSON.stringify({
						data : data
					}));
				});
	
			});
		};

		
	});

	adminApp.controller('LaboratoryParamsObervationController', function($scope, $http,myService,$localstorage,$routeParams) {
		
		$scope.labstyle= {'display': 'none'};
		$scope.labstyle1= {'display': 'block'};
		var SexText=["Ambiguous","Female","Male","Not applicable","Other","Unknown"];
		var SexValue=["A","F","M","N","O","U"];
		var i=0;
		var url="http://localhost:8080/LIS/GetObservation/?cnic="+$routeParams.cnic;
		
		$scope.onCategoryChange=function(itemSelected)
		{
			if($scope.labsSelection1==1)
				{
				url="http://localhost:8080/LIS/GetObservation/?cnic="+$routeParams.cnic;
				}
			else
				{
				url="http://localhost:8080/RIS/GetObservationDetails?cnic="+$routeParams.cnic+"&Name=HIMS";
				}
			$http.get(url)
			.then(function(response) {
				myService.set(response);
				$localstorage.set("transfer",JSON.stringify(response));
				//$scope.test=response.data.Description;
				var responseJson={
						
						"Status":response.data.Status,
						"Description":response.data.Description
				};
				//alert(responseJson.Description);
				var res = $http.post('http://localhost:8080/eHealthService/ParseObservationMessage',responseJson);
				res.success(function(data, status, headers, config) {
				//	myService.set(data);
					$scope.TestName=data.TestName;
					
					$scope.PatientName=data.Patient.PatientName;
					$scope.Cnic=data.Patient.Cnic;
					$scope.DOB=data.Patient.DOB;
					$scope.PatientName=data.Patient.PatientName;
					for(var i=0; i<6; i++)
					{
						if(SexValue[i]==data.Patient.Sex)
							{
								$scope.Sex=SexText[i];
							}
					}
					$scope.Email=data.Patient.Email;
					$scope.FamilyName=data.Patient.FamilyName;
			
				
					
					
				});
				res.error(function(data, status, headers, config) {
					alert("Exception details: " + JSON.stringify({
						data : data
					}));
				});
	
			});
			
		}
			$http.get(url)
			.then(function(response) {
				myService.set(response);
				$localstorage.set("transfer",JSON.stringify(response));
				//$scope.test=response.data.Description;
				var responseJson={
						
						"Status":response.data.Status,
						"Description":response.data.Description
				};
				//alert(responseJson.Description);
				var res = $http.post('http://localhost:8080/eHealthService/ParseObservationMessage',responseJson);
				res.success(function(data, status, headers, config) {
				//	myService.set(data);
					$scope.TestName=data.TestName;
					
					$scope.PatientName=data.Patient.PatientName;
					$scope.Cnic=data.Patient.Cnic;
					$scope.DOB=data.Patient.DOB;
					$scope.PatientName=data.Patient.PatientName;
					for(var i=0; i<6; i++)
					{
						if(SexValue[i]==data.Patient.Sex)
							{
								$scope.Sex=SexText[i];
							}
					}
					$scope.Email=data.Patient.Email;
					$scope.FamilyName=data.Patient.FamilyName;
			
				
					
					
				});
				res.error(function(data, status, headers, config) {
					alert("Exception details: " + JSON.stringify({
						data : data
					}));
				});
	
			});


		
	});
	adminApp.controller('ObservationDetailsController', function($scope,$http, $routeParams,myService,$localstorage) {
		var testName;
		var preres;
		//var Obxvalue=["atiq","atiq","atiq","atiq","atiq","atiq","atiq"];
//			$http.get("http://localhost:8080/eHealthService/GetObservationDetails/?id="+$routeParams.id)
//			.then(function(response) {
//				alert("there");
//				$scope.test=myService.get();
//				$scope.TestName=response.data.TestName;
//				$scope.ObxIden=response.data.OBXIdentifier;
//				$scope.Obxvalue=response.data.OBXValue;
//				
//			});+
		
		var object=JSON.parse($localstorage.get("transfer"));
		$scope.test=object;
		var atiq={
				
				"Status":$routeParams.id,
				"Description":object.data.Description
		};
		var res = $http.post('http://localhost:8080/eHealthService/GetObservationDetails',atiq);
		res.success(function(data, status, headers, config) {
			
			$scope.TestName=data.TestName;
			$scope.ObxIden=data.OBXIdentifier;
			$scope.Obxvalue=data.OBXValue;
		});
		res.error(function(data, status, headers, config) {
			alert("Exception details: " + JSON.stringify({
				data : data
			}));
		});
		

		
	});
	
	
	adminApp.controller('PreviousVisitController', function($scope,$http) {
		$scope.search=function()
		{
			var json={
					"date":$scope.dt
			};
			var response = $http.post('http://localhost:8080/eHealthService/SearchByDate',json);
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
//		$http.get("http://localhost:8080/eHealthService/GetPreviousVisit")
//		.then(function(response) {
//			$scope.data = response.data;
//		});
		
	});
	
	
	adminApp.controller('AddAppointmentController', function($scope,$http,$localstorage) {
		var result=JSON.parse($localstorage.get("DoctorInfo"));
		var Id=result.doctor.Id;
		var PID;
		$scope.open2 = function() {
		    $scope.popup2.opened = true;
		  };

		  $scope.popup2 = {
		    opened: false
		  };
		
		$scope.labstyle= {'display': 'block'};
		var SexText=["Ambiguous","Female","Male","Not applicable","Other","Unknown"];
		var SexValue=["A","F","M","N","O","U"];
		var i=0;
		
		$scope.search=function()
		{
			$http.get("http://localhost:8080/eHealthService/GetPatientbyCnic/?cnic="+$scope.Cnic)
			.then(function(response) {
					PID=response.data.PatientId;
					$scope.PatientName=response.data.PatientName;
					$scope.Cnic=response.data.Cnic;
					$scope.DOB=response.data.DOB;
					$scope.PatientName=response.data.PatientName;
					for(var i=0; i<6; i++)
					{
						if(SexValue[i]==response.data.Sex)
							{
								$scope.Sex=SexText[i];
							}
					}
					$scope.Email=response.data.Email;
					$scope.FamilyName=response.data.FamilyName;
			});
					
					
			};
			$scope.submit=function()
			{
				var formData={
						patient:{"PatientId":PID},
						doctor:{"Id":Id},
						AppointmentDate:$scope.AppointmentDate
				};
				
				var response = $http.post('http://localhost:8080/eHealthService/PostAppointment',formData);
				response.success(function(data, status,
						headers, config) {
				
					alert("success");
				});
				response.error(function(data, status,
						headers, config) {
					alert("Exception details: "+ JSON.stringify({
								data : data
							}));
				});
			};
				

	});
