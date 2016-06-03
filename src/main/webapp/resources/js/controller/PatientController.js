

adminApp.config(['$routeProvider',function($routeProvider) {
					$routeProvider
							
						.when(
								'/GetPatient',
								{
									templateUrl : 'http://localhost:8080/eHealthService/GetPatient',
									controller : 'GetPatientController',
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
							'/EditPatient/:id',
							{
								templateUrl : 'http://localhost:8080/eHealthService/EditPatient',
								controller : 'EditPatientController',
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
									'/InsertPatient',
									{
										templateUrl : 'http://localhost:8080/eHealthService/InsertPatient',
										controller : 'InsertPatientController',
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
									'/DeletePatient/:id',
									{
										templateUrl : 'http://localhost:8080/eHealthService/GetPatient',
										controller : 'DeletePatientController',
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



adminApp.controller('EditPatientController', function($scope, $http,$routeParams,$window) {
	$scope.open2 = function() {
	    $scope.popup2.opened = true;
	  };

	  $scope.popup2 = {
	    opened: false
	  };
	$scope.finalstyle={'display':'none'};
	$scope.basicstyle={'display':'block'};
	$scope.personalstyle={'display':'none'};
	$scope.infotab={active:true};
	$scope.personaltab={active:false};
	$scope.finaltab={active:false};
	
	$scope.changeState=function(item)
	{
		if(item=='basic')
		{
			$scope.infotab={active:true};
			$scope.personaltab={active:false};
			$scope.finaltab={active:false};
			$scope.basicstyle={display:"block"};
			$scope.personalstyle={display:"none"};
			$scope.finalstyle={display:"none"};
		}
		else if(item=='personal')
		{
			$scope.infotab={active:false};
			$scope.personaltab={active:true};
			$scope.finaltab={active:false};
			$scope.basicstyle={display:"none"};
			$scope.personalstyle={display:"block"};
			$scope.finalstyle={display:"none"};
		}
		else if(item=='final')
		{
			$scope.infotab={active:false};
			$scope.personaltab={active:false};
			$scope.finaltab={active:true};
			$scope.basicstyle={display:"none"};
			$scope.personalstyle={display:"none"};
			$scope.finalstyle={display:"block"};
		}
	};

	
	var countryjson;
	var statejson;
	var cityjson;
	var languagejson;
	var religionjson;
	var citizenjson;
	var nationalityjson;
	$http.get("http://localhost:8080/eHealthService/GetAllCountry").then(
			function(response) {

				$scope.CountryData = response.data;
			});
	$http.get("http://localhost:8080/eHealthService/GetAllLanguage")
	.then(function(response) {

				$scope.LanguageData = response.data;
	});
	$http.get("http://localhost:8080/eHealthService/GetAllReligion").then(
			function(response) {

				$scope.ReligionData = response.data;
			});
	$http.get("http://localhost:8080/eHealthService/GetAllNC")
	.then(function(response) {

				$scope.CitizenNationalityData = response.data;
	});
	
	
	$scope.onCountryChange = function(item) {
		
		countryjson = {
			CountryId : $scope.CountryId
		};
		$http.get("http://localhost:8080/eHealthService/findStateBycountryid/"
								+ $scope.CountryId)
				.then(
						function(response) {

							$scope.StateData = response.data;
						});
	};

	$scope.onStateChange = function(item) {
		
		statejson = {
			StateId : $scope.StateId
		};
	
		$http.get("http://localhost:8080/eHealthService/findcityBystateid/"
								+ $scope.StateId)
				.then(
						function(response) {

							$scope.CityData = response.data;
						});
	};
	$scope.onCityChange = function(item) {
		
		cityjson = {
			CityId : $scope.CityId
		};
	};

	
	$scope.onLanguageChange = function(item) {
	
		languagejson = {
			LanguageId : $scope.LanguageId
		};
	};
	
	$scope.onReligionChange = function(item) {
	
		religionjson = {
			ReligionId : $scope.ReligionId
		};
	};

	$scope.onCitizenChange = function(item) {
	
		citizenjson = {
			NcId : $scope.Citizenship
		};
	};
	$scope.onNationalityChange = function(item) {
	
		
		nationalityjson = {
			NcId : $scope.Nationality
		};
	};

	$http.get(
			"http://localhost:8080/eHealthService/GetPatientbyId/?id="
					+ $routeParams.id).then(function(response) {
						RowId=response.data.PatientId;
					
							 $scope.Cnic=response.data.Cnic;
							$scope.PatientName = response.data.PatientName;
							$scope.FamilyName = response.data.FamilyName;
							$scope.MothersMaidenName = response.data.MothersMaidenName;
							$scope.Sex = response.data.Sex;
							$scope.Address =response.data.Address;
							$scope.Street = response.data.Street;
							$scope.Designation = response.data.Designation;
							
							$scope.CityId = response.data.CityId;
							
							$scope.DOB = response.data.DOB;
							$scope.Sex=response.data.Sex;
							$scope.PhoneNumberHome =response.data.PhoneNumberHome;
							$scope.Email = response.data.Email;
							$scope.PhoneNumberPersonalBusiness = response.data.PhoneNumberPersonalBusiness;
							$scope.LanguageId = response.data.language.LanguageId;
							$scope.MaritalStatus = response.data.MaritalStatus;
							$scope.ReligionId =response.data.religion.ReligionId;
							$scope.AccountNumber = response.data.AccountNumber;
							$scope.EthnicGroup = response.data.EthnicGroup;
							$scope.BirthPlace = response.data.BirthPlace;
							$scope.Citizenship = response.data.citizenship.NcId;
							$scope.Nationality = response.data.nationality.NcId;
							$scope.DeathDateTime = response.data.DeathDateTime;
							
							$scope.CountryId =  response.data.country.CountryId;
							
							$http.get("http://localhost:8080/eHealthService/findStateBycountryid/"
									+ response.data.country.CountryId).then(function(response) {
								$scope.StateData = response.data;
							});
							
							$scope.StateId=response.data.state.StateId;
							$http.get("http://localhost:8080/eHealthService/findcityBystateid/"+ response.data.state.StateId).then(
									function(response) {

										$scope.CityData = response.data;
									});
							$scope.CityId=response.data.city.CityId;
							
							countryjson = {
									CountryId : response.data.country.CountryId
								};
							statejson = {
									StateId : response.data.state.StateId
								};
							cityjson = {
									CityId  :response.data.city.CityId
								};
							languagejson = {
									LanguageId : response.data.language.LanguageId
								};
							
							citizenjson = {
									NcId : response.data.citizenship.NcId
								};
							
							nationalityjson = {
									NcId : response.data.nationality.NcId
								};
							religionjson = {
									ReligionId : response.data.religion.ReligionId
								};
							
							
							
							
							
			
	});
	
	
	$scope.submit = function() {

		var formData = {
			"PatientId" : RowId,
			"Cnic" : $scope.Cnic,
			"PatientName" : $scope.PatientName,
			"FamilyName" : $scope.FamilyName,
			"MothersMaidenName" : $scope.MothersMaidenName,
			"Sex" : $scope.Sex,
			"Address" : $scope.Address,
			"Street" : $scope.Street,
			"Designation" : $scope.Designation,
			"city" : cityjson,
			"state" : statejson,
			"DOB" : $scope.DOB,

			"country" : countryjson,
			"PhoneNumberHome" : $scope.PhoneNumberHome,
			"Email" : $scope.Email,
			"PhoneNumberPersonalBusiness" : $scope.PhoneNumberPersonalBusiness,
			"language" : languagejson,
			"MaritalStatus" : $scope.MaritalStatus,
			"religion" : religionjson,

			"AccountNumber" : $scope.AccountNumber,
			"EthnicGroup" : $scope.EthnicGroup,
			"BirthPlace" : $scope.BirthPlace,
			"citizenship" : citizenjson,

			"nationality" : nationalityjson,
			"DeathDateTime" : $scope.DeathDateTime
		};

		var response = $http.post('http://localhost:8080/eHealthService/UpdatePatient',
				formData);
		response.success(function(data, status,
				headers, config) {
			$window.location.href="http://localhost:8080/eHealthService/admin/#/GetPatient";

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



adminApp.controller('GetPatientController', function($scope, $http) {
	
	
	$http.get("http://localhost:8080/eHealthService/GetAllPatient").then(function(response) {
		$scope.myData = response.data;
		$scope.data = response.data;
	});
});
adminApp.controller('DeletePatientController', function($scope, $http,$routeParams) {
	alert("ADasd");
	$http.get("http://localhost:8080/eHealthService/DeletePatient/?id="+ $routeParams.id)
	.then(function(response) {
		
		$http.get("http://localhost:8080/eHealthService/GetAllPatient").then(function(response) {
			$scope.myData = response.data;
			$scope.data = response.data;
		});
	});
});
adminApp.controller('InsertPatientController', function($scope, $http,$window) {
	$scope.open2 = function() {
	    $scope.popup2.opened = true;
	  };

	  $scope.popup2 = {
	    opened: false
	  };
	$scope.finalstyle={'display':'none'};
	$scope.basicstyle={'display':'block'};
	$scope.personalstyle={'display':'none'};
	$scope.infotab={active:true};
	$scope.personaltab={active:false};
	$scope.finaltab={active:false};
	
	$scope.changeState=function(item)
	{
		if(item=='basic')
		{
			$scope.infotab={active:true};
			$scope.personaltab={active:false};
			$scope.finaltab={active:false};
			$scope.basicstyle={display:"block"};
			$scope.personalstyle={display:"none"};
			$scope.finalstyle={display:"none"};
		}
		else if(item=='personal')
		{
			$scope.infotab={active:false};
			$scope.personaltab={active:true};
			$scope.finaltab={active:false};
			$scope.basicstyle={display:"none"};
			$scope.personalstyle={display:"block"};
			$scope.finalstyle={display:"none"};
		}
		else if(item=='final')
		{
			$scope.infotab={active:false};
			$scope.personaltab={active:false};
			$scope.finaltab={active:true};
			$scope.basicstyle={display:"none"};
			$scope.personalstyle={display:"none"};
			$scope.finalstyle={display:"block"};
		}
	};

	
	var countryjson;
	var statejson;
	var cityjson;
	var languagejson;
	var religionjson;
	var citizenjson;
	var nationalityjson;

	//Get all Department and Store in Dropdown
	$http.get("http://localhost:8080/eHealthService/GetAllCountry").then(
			function(response) {

				$scope.CountryData = response.data;
			});

	$scope.onCountryChange = function(item) {
		countryjson = {
			CountryId : $scope.CountryId
		};
		$http
				.get(
						"http://localhost:8080/eHealthService/findStateBycountryid/"
								+ $scope.CountryId)
				.then(
						function(response) {

							$scope.StateData = response.data;
						});
	};

	$scope.onStateChange = function(item) {
		statejson = {
			StateId : $scope.StateId
		};
		$http
				.get(
						"http://localhost:8080/eHealthService/findcityBystateid/"
								+ $scope.CountryId)
				.then(
						function(response) {

							$scope.CityData = response.data;
						});
	};
	$scope.onCityChange = function(item) {
		cityjson = {
			CityId : $scope.CityId
		};
	};

	$http
			.get("http://localhost:8080/eHealthService/GetAllLanguage")
			.then(
					function(response) {

						$scope.LanguageData = response.data;
					});
	$scope.onLanguageChange = function(item) {
		languagejson = {
			LanguageId : $scope.LanguageId
		};
	};
	$http
			.get("http://localhost:8080/eHealthService/GetAllReligion")
			.then(
					function(response) {

						$scope.ReligionData = response.data;
					});
	$scope.onReligionChange = function(item) {
		religionjson = {
			ReligionId : $scope.ReligionId
		};
	};
	$http
			.get("http://localhost:8080/eHealthService/GetAllNC")
			.then(
					function(response) {

						$scope.CitizenNationalityData = response.data;
					});
	$scope.onCitizenChange = function(item) {
		citizenjson = {
			NcId : $scope.Citizenship
		};
	};
	$scope.onNationalityChange = function(item) {
		alert("ASda");
		nationalityjson = {
			NcId : $scope.Nationality
		};
	};

	$scope.submit = function() {

		var formData = {
			"Cnic" : $scope.Cnic,
			"PatientName" : $scope.PatientName,
			"FamilyName" : $scope.FamilyName,
			"MothersMaidenName" : $scope.MothersMaidenName,
			"Sex" : $scope.Sex,
			"Address" : $scope.Address,
			"Street" : $scope.Street,
			"Designation" : $scope.Designation,
			"city" : cityjson,
			"state" : statejson,
			"DOB" : $scope.DOB,

			"country" : countryjson,
			"PhoneNumberHome" : $scope.PhoneNumberHome,
			"Email" : $scope.Email,
			"PhoneNumberPersonalBusiness" : $scope.PhoneNumberPersonalBusiness,
			"language" : languagejson,
			"MaritalStatus" : $scope.MaritalStatus,
			"religion" : religionjson,

			"AccountNumber" : $scope.AccountNumber,
			"EthnicGroup" : $scope.EthnicGroup,
			"BirthPlace" : $scope.BirthPlace,
			"citizenship" : citizenjson,

			"nationality" : nationalityjson,
			"DeathDateTime" : $scope.DeathDateTime
		};

		var response = $http.post('http://localhost:8080/eHealthService/PostPatient',
				formData);
		response.success(function(data, status,
				headers, config) {
			alert("Success")
			$window.location.href="http://localhost:8080/eHealthService/admin/#/GetPatient";

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