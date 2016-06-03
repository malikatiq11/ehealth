

<div class="panel panel-primary" ng-style="stylehistory">
	<div class="panel-heading">
		<p>Search Patient Visit</p>
	</div>
	<div class="panel-body">
		<div>
			<form role="form" data-ng-submit="search()"
				enctype="multipart/form-data">

				<div style="display: inline-block; min-height: 290px;">
					<uib-datepicker ng-model="dt" class="well well-sm"
						datepicker-options="options"></uib-datepicker>
				</div>
				<span>{{dt}}</span>
				<button type="submit" class="btn btn-info">Search</button>
			</form>
		</div>
	</div>
</div>
<div>


	<div class="panel panel-primary">
		<!-- Default panel contents -->
		<div class="panel-heading">Patient List</div>
		<div class="panel-body"></div>
		<table class="table table-striped table-hover">
			<thead>
				<th>Patient Name</th>
				<th>Cnic</th>
				<th>Age</th>
				<th>Visit Time</th>


			</thead>
			<tbody>

				<tr ng-repeat="x in data">

					<td>{{ x.requestpanel.patient.PatientName }}</td>
					<td>{{ x.requestpanel.patient.Cnic}}</td>
					<td>{{ x.requestpanel.patient.DOB | ageFilter }}</td>

					<td><label
						ng-bind="x.requestpanel.VisitTime |  date:'MM/dd/yyyy HH:mm:ss'"></label></td>

					<td><a href="#/ShowTreatment/{{x.patientVisit.VisitId}}">
							<button type="submit" class="btn btn-default">Process</button>
					</a></td>

				</tr>
			</tbody>
		</table>

	</div>
</div>
