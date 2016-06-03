

			<div >
		
				<div class="panel panel-primary">
					<!-- Default panel contents -->
					<div class="panel-heading">Patient  List</div>
					<div class="panel-body">

			
					</div>
						<table class="table table-striped table-hover">
							<thead>
								<th> Patient Name</th>
								<th>Age</th>
								<th>Visit Time</th>
								
							
							</thead>
							<tbody>
						
								<tr ng-repeat="x in RequestData">
								
									<td>{{ x.requestpanel.patient.PatientName }}</td>
									<td>{{ x.requestpanel.patient.DOB | ageFilter }}</td>
									<td><label ng-bind="x.requestpanel.VisitTime |  date:'MM/dd/yyyy HH:mm:ss'"></label></td>
									
									<td><a href="#/InsertTreatment/{{x.DoctorPanelId}}"> <button type="submit" class="btn btn-default">Process</button></a></td>
									
								</tr>
							</tbody>
						</table>
					
				</div>
			</div>
		