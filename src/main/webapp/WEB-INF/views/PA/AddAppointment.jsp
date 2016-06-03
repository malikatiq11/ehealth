
<div class="panel panel-primary" ng-style="labstyle">
	<div class="panel-heading">Search Patient Visits</div>
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

<div class="panel panel-primary">
	<div class="panel-heading">Patient Information</div>
	<div class="panel-body">
		<div>

			<table class="table">
				<tr>
					<td><label for="name">Patient Cnic:</label> <label
						data-ng-model="Cnic" for="name">{{Cnic}}</label></td>
					<td><label for="cnic">Patient Name:</label> <label
						data-ng-model="PatientName" for="name">{{PatientName}}</label></td>
					<td><label for="name">Age:</label> <label data-ng-model="DOB"
						for="name">{{DOB | ageFilter }}</label></td>
				</tr>
				<tr>
					<td><label for="cnic">Gender:</label> <label
						data-ng-model="Sex" for="name">{{Sex}}</label></td>
					<td><label for="name">Email:</label> <label
						data-ng-model="Email" for="name">{{Email}}</label></td>
					<td><label data-ng-model="FamilyName" for="familyname">Address:</label>
						<label for="familyname">{{FamilyName}}</label></td>
				</tr>
			</table>
			<hr>
			<form data-ng-submit="submit()">
				<div class="input-group">
					<input type="text" class="form-control" uib-datepicker-popup
						ng-model="AppointmentDate" is-open="popup2.opened"
						datepicker-options="dateOptions" ng-required="true"
						close-text="Close" /> <span class="input-group-btn">
						<button type="button" class="btn btn-default" ng-click="open2()">
							<i class="glyphicon glyphicon-calendar"></i>
						</button>
					</span>
				</div>
				<button type="submit" class="btn btn-info">Add Appointment</button>
			</form>

		</div>
	</div>

</div>
