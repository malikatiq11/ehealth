
<div class="row">
	<div class="col-md-3"></div>


	<div class="col-md-6">


		<form name="userForm" data-ng-submit="submit()"
			enctype="multipart/form-data" novalidate
			style="width: 380px; padding: 3em 2em 2em 2em;background: #ECF0F5; border: 1px solid #ebebeb;"
			>
			<h1 style="text-align: center; color: #3C8DBC">UPDATE DOCTOR</h1>
   

			<div class="mui-textfield "
				data-ng-class="{ 'has-error' : userForm.name.$invalid}">
				<input type="text" name="name" data-ng-model="Name" ng-pattern="/^(\D)+$/"
					data-ng-minlength="3" ng-required="true">
					<label>Name</label>
					<label ng-show="userForm.name.$invalid && userForm.name.$touched " style = "color:#F44336">Name</label>
				<p data-ng-show="userForm.name.$error.minlength" style = "color:#F44336" class="help-block">Name
					is too short.</p>
				<p data-ng-show="userForm.name.$error.pattern"   style = "color:#F44336" class="help-block">Number Should be Text only </p>
			</div>
			
			<div class="mui-textfield" data-ng-class="{ 'has-error' : userForm.cnic.$invalid}">
				<input type="text" name="cnic" data-ng-model="Cnic" data-ng-minlength="13" data-ng-maxlength="13" ng-pattern="/^(\d)+$/" required>
				<label >Cnic</label>
				<label ng-show="userForm.cnic.$invalid && userForm.cnic.$touched " style = "color:#F44336">Cnic</label>
				<p data-ng-show="userForm.cnic.$error.minlength" style = "color:#F44336" class="help-block">Cnic should b 13 digit</p>
				<p data-ng-show="userForm.cnic.$error.maxlength" style = "color:#F44336"  class="help-block">Cnic should not exceed </p>
				<p data-ng-show="userForm.cnic.$error.pattern"  style = "color:#F44336" class="help-block">Cnic should be Digit</p>
			</div>
			
			<div class="mui-textfield"  data-ng-class="{ 'has-error' : userForm.email.$invalid}">
				<input type="email" name="email" data-ng-model="Email" required>
				<label >Email </label>
				<label ng-show="userForm.email.$invalid && userForm.email.$touched" style ="color:#F44336">Email</label>
				<p data-ng-show="userForm.email.$error.email" style ="color:#F44336"  class="help-block">Invalid Email</p>
			</div>
			
			<div class="mui-textfield"  data-ng-class="{ 'has-error' : userForm.password.$invalid}">
				<input type="text" name="password" ng-model="Password" ng-Readonly="true">
				<label >Password </label>
			</div>
			<div class="mui-textfield">
				<input type="text" id="HomeAddress"  data-ng-model="HomeAddress"
					required> <label for="HomeAddress">Home Address </label>
			</div>
			<div class="mui-textfield">
				<input type="text" id="OfficeAddress" data-ng-model="OfficeAddress"
					required> <label for="OfficeAddress">Office Address
				</label>
			</div>

			<div class="mui-textfield">
				<select data-ng-model="Sex" id="soflow" required> <option
					value="Male" label="Male"> </option> <option
					value="Female" label="Female"></option> <option
					value="Shemale" label="Shemale"></option> </select>

			</div>

			<div class="mui-textfield">
				<input type="text" uib-datepicker-popup ng-model="BirthDate"
					is-open="popup2.opened" datepicker-options="dateOptions"
					ng-required="true" ng-click="open2()" close-text="Close" /> <label
					for="Degree">Birth Date </label> 

			</div>



			<div class="mui-textfield">
				<input type="text" id="Degree" data-ng-model="Degree" required> <label
					for="Degree">Degree </label>
			</div>
			<div class="mui-textfield">
				<input type="text" id="Specialization" required
					data-ng-model="Specialization"> <label for="Specialization">Specialization
				</label>
			</div>


			<div class="mui-textfield" data-ng-class="{ 'has-error' : userForm.departmentid.$invalid}">
				<select  ng-model="DepartmentId" id="soflow" data-ng-change="onCategoryChange(itemSelected)" ng-options="i.DepartmentId as i.DepartmentName for i in data">
        							<option value="0">Select Department</option>
      						</select>
				<br>
				<span ng-show="userForm.departmentid.$dirty && userForm.departmentid.$invalid" style ="color:#F44336">Department Not Selected</span>

			</div>
			<div class="mui-textfield" >
				<input type="file" name="file"
					onchange="angular.element(this).scope().FileUpload(this)"
					ng-model="file" data-rule-required="true" id="file" >
			</div>

			<img class="mui-textfield"  width="200" height="200"
				ng-src="data:image/JPEG;base64,{{ImageByte}}"> <br>
			<br>
			<button type="submit" class="mui-btn mui-btn--primary" ng-disabled="userForm.$invalid"
			
				style="position: relative; display: inline-block; padding: 12px 24px; margin: .3em 0 1em 0; width: 100%; vertical-align: middle; color: #fff; font-size: 16px; line-height: 20px; -webkit-font-smoothing: antialiased; text-align: center; letter-spacing: 1px; background: #3C8DBC; border: 0; border-bottom: 2px solid #3160B6; cursor: pointer; text-shadow: 1px 1px 0 rgba(39, 110, 204, .5); transition: all 0.15s ease;">Submit</button>
			<uib-alert ng-style="alertstyle" type="{{message.type}}"
				close="closeAlert()">{{message.msg}}</uib-alert>

		</form>
	</div>
</div>