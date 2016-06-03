

<div class="panel panel-primary">
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
				
				<button type="submit" class="btn btn-info">Search</button>
			</form>
		</div>
	</div>
</div>
<div class="panel panel-primary">
		<!-- Default panel contents -->
		<div class="panel-heading">Patient List</div>
		<div class="panel-body"></div>
		<table class="table table-striped table-hover">
			<thead>
				<th>Patient Name</th>
				<th>Cnic</th>
				<th>Age</th>
				<th>Department</th>
				<th>Doctor</th>


			</thead>
			<tbody>

				<tr dir-paginate="x in data  | itemsPerPage: 2">

					<td>{{ x.patient.PatientName }}</td>
					<td>{{ x.patient.Cnic}}</td>
					<td>{{ x.patient.DOB | ageFilter }}</td>
						<td>{{ x.department.DepartmentName }}</td>
					<td>{{ x.doctor.Name}}</td>
				

					<td><label
						ng-bind="x.requestpanel.VisitTime |  date:'MM/dd/yyyy HH:mm:ss'"></label></td>

					<td>
							<button type="submit" ng-click="process(x.department.DepartmentId,x.patient.PatientId,x.doctor.Id)" class="btn btn-default">Process</button>
					</td>

				</tr>
			</tbody>
		</table>
			<dir-pagination-controls
					
					direction-links="true"
					boundary-links="true" >
				</dir-pagination-controls>

	</div>

