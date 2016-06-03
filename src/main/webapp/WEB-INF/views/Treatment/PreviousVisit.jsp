

			<div >
		
				<div class="panel panel-primary">
					<!-- Default panel contents -->
					<div class="panel-heading">Patient  List</div>
					<div class="panel-body">

					</div>
						<table class="table table-striped table-hover">
							<thead>
								<th> Patient Name</th>
								<th> Cnic </th>
								<th>Age</th>
								<th>Visit Time</th>
								
							
							</thead>
							<tbody>
						
								<tr ng-repeat="x in data">
								
									<td>{{ x.requestpanel.patient.PatientName }}</td>
									<td>{{ x.requestpanel.patient.Cnic}} </td>
									<td>{{ x.requestpanel.patient.DOB | ageFilter }}</td>
									
									<td><label ng-bind="x.requestpanel.VisitTime |  date:'MM/dd/yyyy HH:mm:ss'"></label></td>
									
									<td><a href="#/ShowTreatment/{{x.patientVisit.VisitId}}"> <button type="submit" class="btn btn-default">Process</button></a></td>
									
								</tr>
							</tbody>
						</table>
					
				</div>
			</div>
		