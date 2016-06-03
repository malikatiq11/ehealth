
            <div class="panel panel-primary">
                <div class="panel-heading"><h1>Patient Information</h1></div>
                <div class="panel-body">
                    <ul class="nav nav-pills nav-justified"> 
                    	<li    ng-class="infotab">
                        	<a ng-click="changeState('basic')" >Basic Info</a>
                        </li> 
                        <li id="p_li" role="presentation" ng-class="personaltab">
                        	<a  ng-click="changeState('personal')" >Personal Info</a>
                        </li> 
                        <li id="f_li" role="presentation" ng-class="finaltab">
                        	<a  ng-click="changeState('final')">Final Step</a>
                        </li> 
                  	</ul>
                    
                    <form data-ng-submit="submit()" enctype="multipart/form-data">
                    
            <!-- Portion 1 starts -->
                    
                    	<div  ng-style="basicstyle">
                            <div class="form-group">
                                <label for="PatientName">Patient Name </label>
                                <input type="text" class="form-control" id="PatientName" data-ng-model="PatientName" placeholder="PatientName">
                            </div>
                            <div class="form-group">
                                <label for="FamilyName">Family Name</label>
                                <input type="text" class="form-control" id="FamilyName" data-ng-model="FamilyName" placeholder="FamilyName">
                            </div>
                            <div class="form-group">
                            	<label for="sex">Sex</label>
								<select data-ng-model="Sex">
                                    <option value="A">Ambiguous</option>
                                    <option value="F">Female</option>
                                    <option value="M">Male</option>
                                    <option value="N">Not applicable</option>
                                    <option value="O">Other</option>
                                    <option value="U">Unknown</option>
								</select>
							</div>
                           			<div class="input-group">
          <input type="text" class="form-control" uib-datepicker-popup ng-model="DOB" is-open="popup2.opened" datepicker-options="dateOptions" ng-required="true" close-text="Close" />
          <span class="input-group-btn">
            <button type="button" class="btn btn-default" ng-click="open2()"><i class="glyphicon glyphicon-calendar"></i></button>
          </span>
        </div>
                            <div class="form-group">
								<label for="Cnic">Cnic </label> 
                                <input type="text" class="form-control" id="Cnic" data-ng-model="Cnic"
								placeholder="Cnic">
							</div>
                        	<div class="form-group">
								<label for="BirthPlace">BirthPlace</label>
                                <input type="text" class="form-control" id="BirthPlace" data-ng-model="BirthPlace" placeholder="BirthPlace">
							</div>
                        	<div class="form-group">
                        	<label for="language">Language</label>
							<select data-ng-model="LanguageId"
								data-ng-change="onLanguageChange(itemSelected)">
								<option data-ng-repeat="x in LanguageData" value="{{ x.LanguageId }}">{{ x.LanguageName }}</option>
							</select>
							</div>
                            <div class="form-group">
                            	<label for="religion">Religion</label>
                                <select data-ng-model="ReligionId" data-ng-change="onReligionChange(itemSelected)">
                                    <option data-ng-repeat="x in ReligionData" value="{{ x.ReligionId }}">{{ x.ReligionName }}</option>
                                </select>
							</div>
                        </div>
                        
            <!-- Portion 2 starts -->
                                    
                        
                        <div ng-style="personalstyle" >
                        	<div class="form-group">
                            	<label for="country">Country</label>
                                <select data-ng-model="CountryId" data-ng-change="onCountryChange(itemSelected)">
                                    <option data-ng-repeat="x in CountryData" value="{{ x.CountryId }}">{{ x.CountryName }}</option>
                                </select>
							</div>
							<div class="form-group">
                            	<label for="state">State</label>
                                <select data-ng-model="StateId" data-ng-change="onStateChange(itemSelected)">
                                    <option data-ng-repeat="x in StateData" value="{{ x.StateId }}">{{ x.StateName }}</option>
                                </select>
							</div>

							<div class="form-group">
                            	<label for="city">City</label>
                                <select data-ng-model="CityId" data-ng-change="onCityChange(itemSelected)">
                                    <option data-ng-repeat="x in CityData" value="{{ x.CityId }}">{{ x.CityName }}</option>
                                </select>
							</div>
                            <div class="form-group">
                                <label for="Address">Address</label>
                                <textarea class="form-control" id="Address" data-ng-model="Address" placeholder="Address"></textarea>
							</div>

							<div class="form-group">
                                <label for="Street">Street</label> 
                                <input type="text" class="form-control" id="Street" data-ng-model="Street" placeholder="Street">
							</div>
                            <div class="form-group">
                                <label for="PhoneNumberHome">Phone Number Home</label> 
                                <input type="text" class="form-control" id="PhoneNumberHome" data-ng-model="PhoneNumberHome" placeholder="PhoneNumberHome">
							</div>

							<div class="form-group">
                                <label for="Email">Email</label> 
                                <input type="text" class="form-control" id="Email" data-ng-model="Email" placeholder="Email">
							</div>

							<div class="form-group">
                                <label for="PhoneNumberPersonalBusiness">Phone Number Personal Business</label> 
                                <input type="text" class="form-control" id="PhoneNumberPersonalBusiness" data-ng-model="PhoneNumberPersonalBusiness" placeholder="PhoneNumberPersonalBusiness">
							</div>
							<div class="form-group">
                                <label for="AccountNumber">"AccountNumber"</label> 
                                <input type="text" class="form-control" id="AccountNumber" data-ng-model="AccountNumber" placeholder="AccountNumber">
							</div>
						</div>
                        
            <!-- Portion 3 starts -->
                        
                        <div ng-style="finalstyle" >
                        	<div class="form-group">
                            	<label for="maritalstatus">Marital Status</label>
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
								<label for="designation">Designation</label>
                            	<input type="text" class="form-control" id="Designation" data-ng-model="Designation" placeholder="Designation">
							</div>
                            <div class="form-group">
								<label for="MothersMaidenName">Mothers Maiden Name</label>
                            	<input type="text" class="form-control" id="MothersMaidenName" data-ng-model="MothersMaidenName" placeholder="MothersMaidenName">
							</div>
                            <div class="form-group">
								<label for="EthnicGroup">"EthnicGroup"</label> 
                                <input type="text" class="form-control" id="EthnicGroup" data-ng-model="EthnicGroup" placeholder="EthnicGroup">
							</div>

							<div class="form-group">
                            	<label for="citizenship">"Citizenship"</label>
								<select data-ng-model="Citizenship" data-ng-change="onCitizenChange(itemSelected)">
                                	<option data-ng-repeat="x in CitizenNationalityData" value="{{ x.NcId }}">{{ x.NcName }}</option>
							</select>
							</div>

							<div class="form-group">
                            	<label for="nationality">"Nationality"</label>
								<select data-ng-model="Nationality" data-ng-change="onNationalityChange(itemSelected)">
									<option data-ng-repeat="x in CitizenNationalityData" value="{{ x.NcId }}">{{ x.NcName }}</option>
							</select>
							</div>

							<div class="form-group">
							<label for="DeathDateTime">"Death Date Time"</label> 
                            <input type="text" class="form-control" id="DeathDateTime" data-ng-model="DeathDateTime" placeholder="DeathDateTime">
							</div>
                            <button type="submit" class="btn btn-default">Submit</button>
						</div>
   
                    </form>
                </div>
            </div>
     