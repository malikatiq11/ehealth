<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html data-ng-app="formSubmit">
<head>
<meta charset="ISO-8859-1">
<title>Edit Patient</title>

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

	app
			.controller(
					'FormSubmitController',
					[
							'$scope',
							'$http',
							function($scope, $http) {
								var countryjson;
								var statejson;
								var cityjson;
								var languagejson;
								var religionjson;
								var citizenjson;
								var nationalityjson;
								
								countryjson = {
										CountryId : "${PatientData.country.countryId}"
									};
								statejson = {
										StateId : "${PatientData.state.stateId}"
									};
								cityjson = {
										CityId :"${PatientData.city.cityId}"
									};
								languagejson = {
										LanguageId : "${PatientData.language.languageId}"
									};
								
								citizenjson = {
										NcId : "${PatientData.citizenship.ncId}"
									};
								
								nationalityjson = {
										NcId : "${PatientData.nationality.ncId}"
									};
								religionjson = {
										ReligionId : "${PatientData.religion.religionId}"
									};
								//Get all Department and Store in Dropdown
								$http.get("http://localhost:8080/eHealthService/GetAllCountry").then(
										function(response) {

											$scope.CountryData = response.data;
										});
								
								$scope.CountryId = "${PatientData.country.countryId}";
								$http.get("http://localhost:8080/eHealthService/findStateBycountryid/"
										+ $scope.CountryId).then(function(response) {
									$scope.StateData = response.data;
								});
								$scope.StateId = "${PatientData.state.stateId}";
								$http.get("http://localhost:8080/eHealthService/findcityBystateid/"+ $scope.CountryId).then(
										function(response) {

											$scope.CityData = response.data;
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
									
									nationalityjson = {
										NcId : $scope.Nationality
									};
								};
								RowId="${PatientData.patientId}"
								 $scope.Cnic="${PatientData.cnic}";
								$scope.PatientName = "${PatientData.patientName}";
								$scope.FamilyName = "${PatientData.familyName}";
								$scope.MothersMaidenName = "${PatientData.mothersMaidenName}";
								$scope.Sex = "${PatientData.sex}";
								$scope.Address = "${PatientData.address}";
								$scope.Street = "${PatientData.street}";
								$scope.Designation = "${PatientData.designation}";
								$scope.CityId = "${PatientData.city.cityId}";
								
								$scope.DOB = "${PatientData.dOB}";
							
								$scope.PhoneNumberHome = "${PatientData.phoneNumberHome}";
								$scope.Email = "${PatientData.email}";
								$scope.PhoneNumberPersonalBusiness = "${PatientData.phoneNumberPersonalBusiness}";
								$scope.LanguageId = "${PatientData.language.languageId}";
								$scope.MaritalStatus = "${PatientData.maritalStatus}";
								$scope.ReligionId = "${PatientData.religion.religionId}";
								$scope.AccountNumber = "${PatientData.accountNumber}";
								$scope.EthnicGroup = "${PatientData.ethnicGroup}";
								$scope.BirthPlace = "${PatientData.birthPlace}";
								$scope.Citizenship = "${PatientData.citizenship.ncId}";
								$scope.Nationality = "${PatientData.nationality.ncId}";
								$scope.DeathDateTime = "${PatientData.deathDateTime}";
								
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
										$scope.list = data;

									});
									response.error(function(data, status,
											headers, config) {
										alert("Exception details: "
												+ JSON.stringify({
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
							<label for="Cnic">Cnic </label> <input type="text"
								class="form-control" id="Cnic" data-ng-model="Cnic"
								placeholder="Cnic">
						</div>
						<div class="form-group">
							<label for="PatientName">Patient Name </label> <input type="text"
								class="form-control" id="PatientName"
								data-ng-model="PatientName" placeholder="PatientName">
						</div>
						<div class="form-group">
							<label for="FamilyName">Family Name</label> <input type="text"
								class="form-control" id="FamilyName" data-ng-model="FamilyName"
								placeholder="FamilyName">
						</div>
						<div class="form-group">
							<label for="MothersMaidenName">Mothers Maiden Name</label> <input
								type="text" class="form-control" id="MothersMaidenName"
								data-ng-model="MothersMaidenName"
								placeholder="MothersMaidenName">
						</div>

						<div class="form-group">
							<label for="DOB">Date of Birth</label> <input type="text"
								class="form-control" id="DOB" data-ng-model="DOB"
								placeholder="DOB">
						</div>
						<div class="form-group">
							<label for="BirthPlace">BirthPlace</label> <input type="text"
								class="form-control" id="BirthPlace" data-ng-model="BirthPlace"
								placeholder="BirthPlace">
						</div>
						<div class="form-group">
							<select data-ng-model="Sex">
								<option value="A">Ambiguous</option>
								<option value="F">Female</option>
								<option value="M">Male</option>
								<option value="N">Not applicable</option>
								<option value="O">Other</option>
								<option value="U">Unknown</option>
							</select>
						</div>

						<div class="form-group">
							<label for="Address">Address</label>
							<textarea class="form-control" id="Address"
								data-ng-model="Address" placeholder="Address">
								</textarea>
						</div>

						<div class="form-group">
							<label for="Street">Street</label> <input type="text"
								class="form-control" id="Street" data-ng-model="Street"
								placeholder="Street">
						</div>

						<div class="form-group">
							<label for="Designation">Designation</label> <input type="text"
								class="form-control" id="Designation"
								data-ng-model="Designation" placeholder="Designation">
						</div>
						<div class="form-group">
							<select data-ng-model="CountryId"
								data-ng-change="onCountryChange(itemSelected)">
								<option data-ng-repeat="x in CountryData"
									value="{{ x.CountryId }}">{{ x.CountryName }}</option>
							</select>
						</div>
						<div class="form-group">
							<select data-ng-model="StateId"
								data-ng-change="onStateChange(itemSelected)">
								<option data-ng-repeat="x in StateData" value="{{ x.StateId }}">
									{{ x.StateName }}</option>
							</select>
						</div>

						<div class="form-group">
							<select data-ng-model="CityId"
								data-ng-change="onCityChange(itemSelected)">
								<option data-ng-repeat="x in CityData" value="{{ x.CityId }}">
									{{ x.CityName }}</option>
							</select>
						</div>

						<div class="form-group">
							<label for="PhoneNumberHome">Phone Number Home</label> <input
								type="text" class="form-control" id="PhoneNumberHome"
								data-ng-model="PhoneNumberHome" placeholder="PhoneNumberHome">
						</div>

						<div class="form-group">
							<label for="Email">Email</label> <input type="text"
								class="form-control" id="Email" data-ng-model="Email"
								placeholder="Email">
						</div>

						<div class="form-group">
							<label for="PhoneNumberPersonalBusiness">Phone Number
								Personal Business</label> <input type="text" class="form-control"
								id="PhoneNumberPersonalBusiness"
								data-ng-model="PhoneNumberPersonalBusiness"
								placeholder="PhoneNumberPersonalBusiness">
						</div>

						<div class="form-group">
							<select data-ng-model="LanguageId"
								data-ng-change="onLanguageChange(itemSelected)">
								<option data-ng-repeat="x in LanguageData"
									value="{{ x.LanguageId }}">{{ x.LanguageName }}</option>
							</select>
						</div>

						<div class="form-group">
							<select data-ng-model="MaritalStatus" >
								<option selected value="default"> Select Marital Status</option>
								<option value="S">Single</option>
								<option value="T">Unreported</option>
								<option value="U">Unknown</option>
								<option value="W">Widowed</option>
								<option value="R">Registered domestic partner</option>
								<option value="P">Domestic partner</option>
								<option value="O">Other</option>
								<option value="N">Annulled</option>
								<option value="M">Married</option>
								<option value="I">Interlocutory</option>
								<option value="N">Annulled</option>
								<option value="G">Living together</option>
								<option value="E">Legally Separated</option>
								<option value="D"> Divorced</option>
								<option value="C">Common law</option>
								<option value="B">Unmarried</option>
								<option value="A">Separated</option>
							</select>
						</div>

						<div class="form-group">
							<select data-ng-model="ReligionId"
								data-ng-change="onReligionChange(itemSelected)">
								<option data-ng-repeat="x in ReligionData"
									value="{{ x.ReligionId }}">{{ x.ReligionName }}</option>
							</select>
						</div>

						<div class="form-group">
							<label for="AccountNumber">"AccountNumber"</label> <input
								type="text" class="form-control" id="AccountNumber"
								data-ng-model="AccountNumber" placeholder="AccountNumber">
						</div>

						<div class="form-group">
							<label for="EthnicGroup">"EthnicGroup"</label> <input type="text"
								class="form-control" id="EthnicGroup"
								data-ng-model="EthnicGroup" placeholder="EthnicGroup">
						</div>

						<div class="form-group">
							<select data-ng-model="Citizenship"
								data-ng-change="onCitizenChange(itemSelected)">
								
								<option data-ng-repeat="x in CitizenNationalityData"
									value="{{ x.NcId }}">{{ x.NcName }}</option>
							</select>
						</div>

						<div class="form-group">
							<select data-ng-model="Nationality"
								data-ng-change="onNationalityChange(itemSelected)">
								<option data-ng-repeat="x in CitizenNationalityData"
									value="{{ x.NcId }}">{{ x.NcName }}</option>
							</select>
						</div>

						<div class="form-group">
							<label for="DeathDateTime">"Death Date Time"</label> <input
								type="text" class="form-control" id="DeathDateTime"
								data-ng-model="DeathDateTime" placeholder="DeathDateTime">
						</div>


						<button type="submit" class="btn btn-default">Submit</button>

					</form>
				</div>
			</div>
		</div>

	</div>

</body>
</html>