
<div class="panel panel-primary" ng-style="labstyle">
	<div class="panel-heading">Search Patient Visits</div>
	<div class="panel-body">
		<div>
			<form role="form" data-ng-submit="search()"
				enctype="multipart/form-data">

				<div class="form-group">
					<label for="cnic">Search by CNIC:</label> <input type="text"
						data-ng-model="Cnic" class="form-control" id="cnic">
						<select ng-model="labsSelection">
						<option value="0" ng-selected="true"> Select Laboratory </option>
						<option value="1" >LIS</option>
						<option value="2"> RIS </option>
						</select>
				</div>

				<button type="submit" class="btn btn-info">Search</button>
			</form>
		</div>
	</div>
</div>
<div class="panel panel-primary" ng-style="labstyle1">
	<div class="panel-heading">Search Patient Visits</div>
	<div class="panel-body">
		<div>
			<div class="form-group">
				
						<select ng-model="labsSelection1" data-ng-change="onCategoryChange(itemSelected)">
						<option value="1" ng-selected="true" >LIS</option>
						<option value="2"> RIS </option>
						</select>
				</div>
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
{{TestName}}
			<table class="table table-striped table-hover">
				<thead>
					<th>Test Name</th>
					<th>TestDate</th>



				</thead>
				<tbody>
					<tr data-ng-repeat="x in TestName track by $index">
						<td>{{x}}</td>
						<td>{{TestDate[$index]}}</td>
						<td><a href="#/ObservationDetails/{{$index}}">
								<button type="submit" class="btn btn-default">View</button>
						</a></td>

					</tr>
				</tbody>
			</table>
		
		</div>
	</div>

</div>
