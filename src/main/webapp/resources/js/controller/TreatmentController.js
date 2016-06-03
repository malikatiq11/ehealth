var adminApp = angular.module('AdminApp',["ngRoute","ngStorage","angular-web-notification","ngAnimate", "ui.bootstrap","angularUtils.directives.dirPagination"]);

adminApp.config([
				'$routeProvider',
				function($routeProvider) {
					$routeProvider
							
							.when(
								'/',
								{
									templateUrl : 'http://localhost:8080/eHealthService/',
									controller : 'DashboardController',
									resolve:{
										data:  function($localstorage,$location,$window){
										var result = JSON.parse($localstorage.get("DoctorStatus"));
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
								'/InsertTreatment/:id',
								{
									templateUrl : 'http://localhost:8080/eHealthService/InsertTreatment',
									controller : 'InsertTreatmentController',
									resolve:{
										data:  function($localstorage,$location,$window){
										var result = JSON.parse($localstorage.get("DoctorStatus"));
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
									templateUrl : 'http://localhost:8080/eHealthService/TreatmentLogin',
									controller : 'TreatmentLoginController',
									resolve:{
										data:  function($localstorage,$location,$window){
										var result = JSON.parse($localstorage.get("DoctorStatus"));
										if(result)
										{
											$location.path("/");
										}
										
										}
									}
								})
								.when('/ShowHl7',
										{
											templateUrl : 'http://localhost:8080/eHealthService/Hl7',
											controller : 'Hl7Controller',
											
										})
										//destination of these pages is PA controller in both angular or spring
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
																.when('/PatientRequest',
																		{
																			templateUrl : 'http://localhost:8080/eHealthService/AllPatientRequest',
																			controller : 'PatientRequestController',
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

//adminApp.factory('Poller', function($http, $timeout,$localstorage,webNotification) {
//	var data=JSON.parse($localstorage.get("DoctorData"));
//	var DoctorId=data.Id;
//	  var data = { response: {}, calls: 0 };
//	  var poller = function() {
//	    $http.get("http://localhost:8080/eHealthService/GetNotification").then(function(r) {
//	      data.response = r.data.Status;
//	      if(r.data.Status=="10")
//	    	  {
//	    	  webNotification.showNotification(r.data.information.requestpanel.patient.PatientName, {
//	    	         body: 'be ready for treatment',
//	    	         icon: '/eHealthService/resources/images/logo.jpg',
//	    	         onClick: function onNotificationClicked() {
//	    	             window.alert('Notification clicked.');
//	    	         },
//	    	         autoClose: 4000 //auto close the notification after 2 seconds (you manually close it via hide function)
//	    	     }, function onShow(error, hide) {
//	    	         if (error) {
//	    	             window.alert('Unable to show notification: ' + error.message);
//	    	         } else {
//	    	             console.log('Notification Shown.');
//
//	    	             setTimeout(function hideNotification() {
//	    	                 console.log('Hiding notification....');
//	    	                 hide(); //manually close the notification (or let the autoClose close it)
//	    	             }, 5000);
//	    	         }
//	    	     });
//	    	  }
//	      
//	      $timeout(poller, 1000);
//	    });
//	    
//	  };
//	  poller();
//	  
//	  return {
//	    data: data
//	  };
//	});
//adminApp.run(function(Poller) {});

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

adminApp.controller('DashboardController', function($scope, $http,$localstorage,$window) {
	
});

//Main Controller for Main VIew
adminApp.controller('MainController', function($scope, $http,$localstorage,$window) {
	var result=JSON.parse($localstorage.get("DoctorStatus"));
	if(result)
		{
			$scope.changevisibilty = {'visibility': 'visible'};
			var data=JSON.parse($localstorage.get("DoctorData"));
			$scope.DoctorName=data.Name;
		}
	else
	$scope.changevisibilty = {'visibility': 'hidden'};
	$scope.logout=function()
	{
		$localstorage.clear();
		$scope.changevisibilty = {'visibility': 'hidden'};
		$window.location.href="http://localhost:8080/eHealthService/treatment#/login";
		
	};
});
			
adminApp.controller('TreatmentLoginController', function($scope, $http,$localstorage,$window) {
	$scope.submit=function()
	{
		var formData={ 
				UserName:$scope.UserName,
				Password:$scope.Password
		};
		var response = $http.post('http://localhost:8080/eHealthService/AuthenticateDoctor',formData);
		response.success(function(data, status,
				headers, config) {
			$scope.data=data;
		
			if(data.Status==10)
			{
				
		
					$localstorage.set("DoctorStatus", JSON.stringify({"Status":"10"}));
					$localstorage.set("DoctorData", JSON.stringify(data.DoctorData));
				
					$window.location.href="http://localhost:8080/eHealthService/treatment";
				
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

adminApp.controller('PatientRequestController', function($scope, $http,$localstorage,webNotification) {

	$http.get("http://localhost:8080/eHealthService/GetPatientRequest").then(function(response) {
		$scope.RequestData=response.data;
		
	});
	
});
adminApp.controller('InsertTreatmentController', function($scope, $http,$localstorage,webNotification,$routeParams) {
	
	//for solving child scope problem
	$scope.LISObject={
			"message":""
	};
	$scope.RISObject={
			"message":""
	};
	
	$scope.DepartmentObject={
			"message":""
	};
	$scope.DoctorObject={
			"message":""
	};
	$scope.DateObject={
			"message":""
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
		$http.get("http://localhost:8080/eHealthService/SearchDoctorbyDepartment/?id="+$scope.DepartmentObject.message)
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
	
	
	//$scope.atiq=Poller.data;
	
//	 webNotification.showNotification('Patinet Enter', {
//         body: 'Patient Name',
//         icon: '/eHealthService/resources/images/logo.jpg',
//         onClick: function onNotificationClicked() {
//             window.alert('Notification clicked.');
//         },
//         autoClose: 4000 //auto close the notification after 2 seconds (you manually close it via hide function)
//     }, function onShow(error, hide) {
//         if (error) {
//             window.alert('Unable to show notification: ' + error.message);
//         } else {
//             console.log('Notification Shown.');
//
//             setTimeout(function hideNotification() {
//                 console.log('Hiding notification....');
//                 hide(); //manually close the notification (or let the autoClose close it)
//             }, 5000);
//         }
//     });
	 
	var DepartmentJson;
	var DoctorJson;
	var PatientJson;
	var Updatejson;
	var VisitId;
	var ReqId;
	var DoctorPanelId;
	var DoctorId;
	var data=JSON.parse($localstorage.get("DoctorData"));
	var DoctorId=data.Id;
	var DoctorName=data.Name;
	var patientId;
	var SexText=["Ambiguous","Female","Male","Not applicable","Other","Unknown"];
	var SexValue=["A","F","M","N","O","U"];
	var datajson={
			"first":DoctorId,
			"second":$routeParams.id
	};
	var response = $http.post('http://localhost:8080/eHealthService/GetDoctorPanelRecord',
			datajson);
	response.success(function(data, status, headers, config) {
		$scope.data=data.Visit.PatientClass;
		ReqId=data.ReqId;
		DoctorPanelId=data.DoctorPanelId;
		/*UpdateJson={
				"ReqId":response.data.ReqId,
				"patient":{"PatientId":response.data.patient.PatientId},
				"department":{"DepartmentId":response.data.department.DepartmentId},
				"doctor":{"Id":response.data.doctor.Id}
		}; */
		VisitId=data.Visit.VisitId;
		$scope.PatientClass= data.Visit.PatientClass;
		$scope.AssignedPatientLocation= data.Visit.AssignedPatientLocation;
		$scope.AdmissionType= data.Visit.AdmissionType;
		$scope.Weight= data.Visit.Weight;
		$scope.Tempreture=data.Visit.Tempreture;
		$scope.Pressure=data.Visit.Pressure;
		$scope.Pulse=data.Visit.Pulse;
		$scope.BP=data.Visit.BP;
		$scope.PatientId = data.Visit.patient.PatientId;
		patientId=data.Visit.patient.PatientId;
		$scope.PatientName = data.Visit.patient.PatientName;
		$scope.Cnic =data.Visit.patient.Cnic;
		$scope.cnic=data.Visit.patient.Cnic;
		
		//calculate age from date of birth
		var ageDifMs = Date.now() - data.Visit.patient.DOB;
	    var ageDate = new Date(ageDifMs); // miliseconds from epoch
	    var age= Math.abs(ageDate.getUTCFullYear() - 1970);
		$scope.DOB=age;
		//////
		
		$scope.DepartmentId = data.Visit.department.DepartmentName;
		$scope.DoctorId = data.Visit.doctor.Name;
		
		for(var i=0; i<6; i++)
		{
			if(SexValue[i]==data.Visit.patient.Sex)
				{
				
					$scope.Sex=SexText[i];
				}
		}
		
		DepartmentJson={
				DepartmentId:data.department.DepartmentId
		};
		
		DoctorJson={
				Id:data.doctor.Id
		};
		
		PatientJson={
				PatientId:data.patient.PatientId
		};
		

	});
	response.error(function(data, status, headers, config) {
		alert("Exception details: " + JSON.stringify({
			data : data
		}));
	});
	


	$scope.submit=function()
	{
		alert($scope.LISObject.message);
		alert($scope.RISObject.message);
		alert($scope.DepartmentObject.message);
		alert($scope.DoctorObject.message);
	var treatmentJson={
				"Symptom":$scope.Symptom,
				"Investigation":$scope.Investigation,
				"PatientProcedure":$scope.PatientProcedure,
				"patientVisit":{"VisitId":VisitId},
				
				
		};
	var DeptId;
	var DocId;
	if($scope.DepartmentObject.message==undefined)
		Dept=0;
	if($scope.DoctorObject.message==undefined)
		DocId=0

	
		var LaboratoryJson={"treatment":treatmentJson,"TestName":$scope.LISObject.message,"PatientId":$scope.PatientId,
				"ReferDept":DeptId,"ReferDoctor":DocId, "ReferName":DoctorName,"RISName":$scope.RISObject.message};
		var response = $http.post('http://localhost:8080/eHealthService/PostTreatment', LaboratoryJson);
		response.success(function(data, status, headers, config) {
			alert("done g");
//			$http.get("http://localhost:8080/eHealthService/DeleteDoctorPanelRow/?id="+DoctorPanelId)
//			.then(function(response) {
//				$http.get("http://localhost:8080/eHealthService/GetRequestDetails/?id="+ReqId)
//				.then(function(response) {
//					UpdateJson={
//							"ReqId":ReqId,
//							"patient":{"PatientId":response.data.patient.PatientId},
//							"department":{"DepartmentId":response.data.department.DepartmentId},
//							"doctor":{"Id":response.data.doctor.Id},
//							"Status":"Done",
//							"ReferFrom":response.data.ReferFrom
//					}
//					var res = $http.post('http://localhost:8080/eHealthService/UpdateVisitRequest', UpdateJson);
//					res.success(function(data, status, headers, config) {
//						alert("sab ho gia ");
//						
//					});
//					res.error(function(data, status, headers, config) {
//						alert("Exception details: " + JSON.stringify({
//							data : data
//						}));
//					});
//					
//				});
//				
//			});
//			
		});
		response.error(function(data, status, headers, config) {
			alert("Exception details: " + JSON.stringify({
				data : data
			}));
		}); 
	};
	
	$scope.appointmentsubmit=function()
	{
		alert("ADasda");
		var formData={
				patient:{"PatientId":patientId},
				doctor:{"Id":DoctorId},
				AppointmentDate:$scope.DateObject.message
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

adminApp.controller('Hl7Controller', function($scope, $http,$localstorage) {
	
	$http.get("http://localhost:8080/eHealthService/Hl7message")
	.then(function(response) {
		//alert(response.ERMessage);
		$scope.XML=response.data.XMLMessage;
		$scope.ER=response.data.ERMessage;
	});
		
	});

adminApp.controller('GetAllVisitController', function($scope, $http) {
	$scope.stylehistory= {'display': 'block'};
	$scope.search=function()
	{
	var SexText=["Ambiguous","Female","Male","Not applicable","Other","Unknown"];
	var SexValue=["A","F","M","N","O","U"];
	$http.get("http://localhost:8080/eHealthService/GetAllVisit/?cnic=1021")
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
adminApp.controller('LaboratoryObervationController', function($scope, $http,$localstorage) {
	
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
			//myService.set(response);
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

adminApp.controller('LaboratoryParamsObervationController', function($scope, $http,$localstorage,$routeParams) {
	
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
			//myService.set(response);
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
		
	};
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
adminApp.controller('ObservationDetailsController', function($scope,$http, $routeParams,$localstorage) {
	var testName;
	var preres;
	//var Obxvalue=["atiq","atiq","atiq","atiq","atiq","atiq","atiq"];
//		$http.get("http://localhost:8080/eHealthService/GetObservationDetails/?id="+$routeParams.id)
//		.then(function(response) {
//			alert("there");
//			$scope.test=myService.get();
//			$scope.TestName=response.data.TestName;
//			$scope.ObxIden=response.data.OBXIdentifier;
//			$scope.Obxvalue=response.data.OBXValue;
//			
//		});+
	
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
	$http.get("http://localhost:8080/eHealthService/GetPreviousVisit")
	.then(function(response) {
		$scope.data = response.data;
	});
	
});


