
				<div class="panel panel-primary">
					<!-- Default panel contents -->
					<div class="panel-heading">Patient List</div>
					<div class="panel-body">

					<a href="http://localhost:8080/eHealthService/admin/#/InsertPatient">Add New Patient</a>
					</div>
						<table class="table table-striped table-hover">
							<thead>
								<th> Cnic</th>
								<th> Name</th>
								<th>Family Number</th>
								<th> Phone Number</th>
								<th>DOB</th>
							
							
							</thead>
							<tbody>
								<tr dir-paginate="x in data | itemsPerPage:2" >
									
									<td>{{ x.Cnic }}</td>
									<td>{{ x.PatientName}} </td>
									<td>{{ x.FamilyName }}</td>
									<td>{{ x.PhoneNumberPersonalBusiness  }} </td>
									<td >{{ x.DOB }}</td>
									<td><a href="#/EditPatient/{{x.PatientId}}"> Edit </a></td>
									<td><a href="#/DeletePatient?/{{x.PatientId}}"> Delete
									</a></td>
								</tr>
							</tbody>
							<dir-pagination-controls
					
					direction-links="true"
					boundary-links="true" >
				</dir-pagination-controls>
						</table>
					
				</div>
	
