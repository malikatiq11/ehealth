
<div class="com-md-6">
	<div class="panel panel-primary">
		<div class="panel-heading">
			Search Staff
		</div>
		<div class="panel-body">
			<div>
				<form role="form" data-ng-submit="search()"
					enctype="multipart/form-data">

					<div class="form-group">
						<label for="cnic">Search by CNIC:</label> <input type="text"
							data-ng-model="Cnic" class="form-control" id="cnic">
					</div>

					<button type="submit" class="btn btn-info">Search</button>
				</form>
			</div>
		</div>
	</div>
</div>


<div class="row">
	<div class="col-md-6">
		<div class="panel panel-success">
			<div class="panel-heading">
			Staff Information
			</div>
			<div class="panel-body">


				<img width="200" height="200"
					ng-src="data:image/JPEG;base64,{{ImageByte}}">
				<div class="group">
					<label for="refId">Name:</label> <input type="text"
						class="form-control" data-ng-model="StaffName" id="StaffName"
						disabled="disabled">
				</div>
				<div class="group">
					<label for="name">Roles</label> <input type="text"
						class="form-control" id="name" data-ng-model="RoleName"
						disabled="disabled">

				</div>
			</div>
		</div>

		<div class="col-md-6">

			<div class="panel panel-success">

				<div class="panel-heading">
					Account Detail
				</div>
				<div class="panel-body">


					<form role="form" data-ng-submit="submit()">
						<div class="form-group">
							<label for="UserName">User Name </label> <input type="text"
								class="form-control" id="UserName" data-ng-model="UserName"
								placeholder="UserName">
						</div>
						<div class="form-group">
							<label for="Password">Password </label> <input type="text"
								class="form-control" id="Password" data-ng-model="Password"
								placeholder="Password">
						</div>
							<button type="submit" class="btn btn-info">Submit</button>
					</form>



				</div>
			</div>
		</div>
	</div>