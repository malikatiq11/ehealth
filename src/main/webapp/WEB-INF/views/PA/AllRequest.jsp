

			<div >
		
				<div class="panel panel-primary">
					<!-- Default panel contents -->
					<div class="panel-heading">Patient  List</div>
					<div class="panel-body">

					<a href="InsertDoc">Patient Listr</a>
					</div>
						<table class="table table-striped table-hover">
							<thead>
								<th> Patient Name</th>
								<th> Cnic </th>
								<th>Age</th>
								<th> Status</th>
								<th> Refer From</th>
								<th>Visit Time</th>
								
							
							</thead>
							<tbody>
						
								<tr dir-paginate="x in data  | itemsPerPage: 5">
								
									<td>{{ x.patient.PatientName }}</td>
									<td>{{ x.patient.Cnic}} </td>
									<td>{{ x.patient.DOB | ageFilter }}</td>
									
									<td>{{ x.Status  }} </td>
									<td>{{ x.ReferFrom }}</td>
									<td><label ng-bind="x.VisitTime |  date:'MM/dd/yyyy HH:mm:ss'"></label></td>
									
									<td><a href="#/RequestDetails/{{x.ReqId}}"> <button type="submit" class="btn btn-default">Process</button></a></td>
									<td><a href="#/SendPatient/{{x.ReqId}}"> <button type="submit" class="btn btn-default">Send</button>
									</a></td>
									<td><a href="#/GetVisit/{{x.patient.Cnic}}"> <button type="submit" class="btn btn-default">History</button>
									</a></td>
									<td><a href="#/LaboratoryObservation/{{x.patient.Cnic}}"> <button type="submit" class="btn btn-default">lab Result</button>
									</a></td>
								</tr>
							</tbody>
						</table>
					<dir-pagination-controls
					
					direction-links="true"
					boundary-links="true" >
				</dir-pagination-controls>
				</div>
			</div>
		