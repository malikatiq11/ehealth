

<div class="row">
	<div class="col-md-3"></div>


	<div class="col-md-6">

					<form data-ng-submit="submit()" name="userForm"   style="width: 380px; padding: 3em 2em 2em 2em; background: #ECF0F5; border: 1px solid #ebebeb;"  enctype="multipart/form-data"> 
						<h1 style="text-align: center; color: #3C8DBC">ADD STAFF</h1>

						<div class="mui-textfield mui-textfield--float-label"
							data-ng-class="{ 'has-error' : userForm.name.$invalid}">
							<input type="text" name="name" data-ng-model="Name" ng-pattern="/^(\D)+$/"
								data-ng-minlength="3" ng-required="true">
								<label>Name</label>
								<label ng-show="userForm.name.$invalid && userForm.name.$touched " style = "color:#F44336">Name</label>
							<p data-ng-show="userForm.name.$error.minlength" style = "color:#F44336" class="help-block">Name
								is too short.</p>
							<p data-ng-show="userForm.name.$error.pattern"   style = "color:#F44336" class="help-block">Number Should be Text only </p>
						</div>
						
						
			<div class="mui-textfield mui-textfield--float-label" data-ng-class="{ 'has-error' : userForm.cnic.$invalid}">
				<input type="text" name="cnic" data-ng-model="Cnic" data-ng-minlength="13" data-ng-maxlength="13" ng-pattern="/^(\d)+$/" required>
				<label >Cnic</label>
				<label ng-show="userForm.cnic.$invalid && userForm.cnic.$touched " style = "color:#F44336">Cnic</label>
				<p data-ng-show="userForm.cnic.$error.minlength" style = "color:#F44336" class="help-block">Cnic should b 13 digit</p>
				<p data-ng-show="userForm.cnic.$error.maxlength" style = "color:#F44336"  class="help-block">Cnic should not exceed </p>
				<p data-ng-show="userForm.cnic.$error.pattern"  style = "color:#F44336" class="help-block">Cnic should be Digit</p>
			</div>
						<div class="mui-textfield mui-textfield--float-label">
							<select id="soflow" data-ng-model="Gender">
								<option  value="A">Ambiguous</option>
								<option value="F">Female</option>
								<option value="M">Male</option>
								<option value="N">Not applicable</option>
								<option value="O">Other</option>
								<option value="U">Unknown</option>
							</select>
						</div>
					<div class="mui-textfield mui-textfield--float-label"  data-ng-class="{ 'has-error' : userForm.email.$invalid}">
				<input type="email" name="email" data-ng-model="Email" required>
				<label >Email </label>
				<label ng-show="userForm.email.$invalid && userForm.email.$touched" style ="color:#F44336">Email</label>
				<p data-ng-show="userForm.email.$error.email" style ="color:#F44336"  class="help-block">Invalid Email</p>
			</div>

<div class="mui-textfield mui-textfield--float-label" data-ng-class="{ 'has-error' : userForm.mobile.$invalid}">
				<input type="text" name="mobile" data-ng-model="MobileNo" data-ng-minlength="10"  ng-pattern="/^(\d)+$/" required>
				<label >Mobile No</label>
				<label ng-show="userForm.mobile.$invalid && userForm.mobile.$touched " style = "color:#F44336">Mobile No</label>
				<p data-ng-show="userForm.mobile.$error.minlength" style = "color:#F44336" class="help-block">Mobile number should be atleast 10 digit </p>
				<p data-ng-show="userForm.mobile.$error.pattern"  style = "color:#F44336" class="help-block">Cnic should be Digit</p>
			</div>
						

				
						<div class="mui-textfield mui-textfield--float-label" data-ng-class="{ 'has-error' : userForm.departmentid.$invalid}">
							<select data-ng-model="DepartmentId" id="soflow" name="departmentid"
								data-ng-change="onCategoryChange(itemSelected) " required  >
								<option value="">Select Department </option>
								<option data-ng-repeat="x in data" value="{{ x.DepartmentId }}">{{
									x.DepartmentName }}</option>
							</select>
							<span ng-show="userForm.departmentid.$dirty && userForm.departmentid.$invalid" style ="color:#F44336">Department Not Selected</span>
						</div>
						<div class="mui-textfield mui-textfield--float-label" data-ng-class="{ 'has-error' : userForm.roleid.$invalid}">
							<select data-ng-model="RoleId" id="soflow" name="roleid"
								data-ng-change="onRoleChange(itemSelected) "  required>
								<option value="">Select Role </option>
								<option data-ng-repeat="x in RoleData" value="{{ x.RoleId }}">{{
									x.RoleName }}</option>
							</select>
								<span ng-show="userForm.roleid.$dirty && userForm.roleid.$invalid" style ="color:#F44336">Role Not Selected</span>
						</div>
						
						<div class="mui-textfield mui-textfield--float-label" data-ng-class="{ 'has-error' : userForm.doctorid.$invalid}" ng-style="changevisibilty">
			
							<select data-ng-model="DoctorId" name="doctorid" id="soflow"
								data-ng-change="onDoctorChange(itemSelected) " required >
								<option value="">Select Doctor</option>
								<option data-ng-repeat="x in DoctorData" value="{{ x.Id }}">{{
									x.Name }}</option>
							</select>
								<span ng-show="userForm.doctorid.$dirty && userForm.doctorid.$invalid" style ="color:#F44336">Doctor Not Selected</span>
						</div>
						
						
						
						<div  class="mui-textfield mui-textfield--float-label" >
							<input class="inline-block" type="file" name="file" onchange="angular.element(this).scope().FileUpload(this)"
								ng-model="file" data-rule-required="true" accept="image/png, image/gif, image/jpeg"  id="file" required>
						</div>
						<div  class="mui-textfield mui-textfield--float-label" >
						<img width="200" height="200" ng-src="data:image/JPEG;base64,{{ImageByte.content}}">
						</div>
						<br>
						
						<button type="submit" class="mui-btn mui-btn--primary" 
			
				style="position: relative; display: inline-block; padding: 12px 24px; margin: .3em 0 1em 0; width: 100%; vertical-align: middle; color: #fff; font-size: 16px; line-height: 20px; -webkit-font-smoothing: antialiased; text-align: center; letter-spacing: 1px; background: #3C8DBC; border: 0; border-bottom: 2px solid #3160B6; cursor: pointer; text-shadow: 1px 1px 0 rgba(39, 110, 204, .5); transition: all 0.15s ease;">Submit</button>
			<uib-alert ng-style="alertstyle" type="{{message.type}}"
				close="closeAlert()">{{message.msg}}</uib-alert>


					</form>
					
				</div>
	