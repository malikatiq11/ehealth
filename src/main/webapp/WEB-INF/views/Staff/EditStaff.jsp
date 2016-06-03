
				<!-- Default panel contents -->
				<div class="panel-heading">Edit New Staff</div>
				<div class="panel-body">
					<form data-ng-submit="submit()"  enctype="multipart/form-data"> 
						

						<div class="form-group">
							<label for="Name">Name</label> <input type="text"
								class="form-control" id="Name" data-ng-model="Name"
								placeholder="Name"  required >
						</div>
						<div class="form-group">
							<label for="Email">Cnic </label> <input type="Cnic"
								class="form-control" id="Cnic" data-ng-model="Cnic"
								placeholder="Cnic"   >
						</div>
						<div class="form-group">
							<select data-ng-model="Gender">
								<option value="A">Ambiguous</option>
								<option value="F">Female</option>
								<option value="M">Male</option>
								<option value="N">Not applicable</option>
								<option value="O">Other</option>
								<option value="U">Unknown</option>
							</select>
						</div>
						<div class="form-group">
							<label for="Email">Email </label> <input type="email"
								class="form-control" id="Email" data-ng-model="Email"
								placeholder="Email"  required >
						</div>

						<div class="form-group">
							<label for="MobileNo">Mobile No</label> <input type="text"
								class="form-control" id="MobileNo"
								data-ng-model="MobileNo" placeholder="Mobile No"  required>
						</div>
						

						
						

						<div class="form-group">
							<select  ng-model="DepartmentId"
								data-ng-change="onCategoryChange(itemSelected)" 
							 ng-options="i.DepartmentId as i.DepartmentName for i in data">
        							<option value="0">Select Department</option>
      						</select>

						</div>
							<div class="form-group">
							<select  ng-model="RoleId"
								data-ng-change="onRoleChange(itemSelected)" 
							 ng-options="i.RoleId as i.RoleName for i in RoleData">
        							<option value="0">Select Department</option>
      						</select>

						</div>
						
						<img width="200" height="200" ng-src="data:image/JPEG;base64,{{ImageByte}}">
						
						<div class="col-xs-4 input-max controls ">
							<input class="inline-block" type="file" name="file" onchange="angular.element(this).scope().FileUpload(this)"
								ng-model="file" data-rule-required="true" id="file" required>
						</div>
						<button type="submit" class="btn btn-default">Submit</button>

					</form>
				</div>
	