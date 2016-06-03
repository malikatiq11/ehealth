

		<div class="panel panel-primary" ng-style="stylehistory">
                <div class="panel-heading">  Search Patient Visit </div>
                 <div class="panel-body">
                     <div>
                            <form role="form" data-ng-submit="search()" enctype="multipart/form-data">
                                
                                <div class="form-group">
                                    <label for="cnic">Search by CNIC:</label>
                                    <input type="text"  data-ng-model="Cnic" class="form-control" id="cnic">
                                </div>
                                
                                <button type="submit" class="btn btn-info">Search</button>
                            </form>
                    </div>
                </div>
            </div>
			<div >
		<div class="panel panel-success">
			<div class="panel-heading">
				<h1>Patient Information</h1>
			</div>
			{{test}}
			<div class="panel-body">

				<div class="group">
					<label for="refId">Reference ID:</label> <input type="text"
						class="form-control" data-ng-model="PatientId" id="refId"
						disabled="disabled">
				</div>
				<div class="group">
					<label for="name">Name:</label> <input type="text"
						class="form-control" id="name" data-ng-model="PatientName"
						disabled="disabled">
				</div>
				<div class="group">
					<label for="cnic">CNIC:</label> <input type="text"
						class="form-control" data-ng-model="Cnic" id="cnic"
						disabled="disabled">
				</div>
				<div class="group">
					<label for="age">Age:</label> <input type="text"
						class="form-control" data-ng-model="DOB" id="age"
						disabled="disabled">
				</div>
				<div class="group">
					<label for="gender">Gender:</label> <input type="text"
						class="form-control" data-ng-model="Sex" id="gender"
						disabled="disabled">
				</div>
				
		</div>
				<div class="panel panel-primary">
					<!-- Default panel contents -->
					<div class="panel-heading">Patient  List</div>
					<div class="panel-body">

					<a href="InsertDoc">Patient Listr</a>
					</div>
						<table class="table table-striped table-hover">
							<thead>
								<th> Patient Name</th>
								<th> Patient Class </th>
								<th>Assigned Patient Location</th>
								<th> Doctor Name</th>
								<th>Department</th>
								
							
							</thead>
							<tbody>
						
								<tr dir-paginate="x in VisitData | itemsPerPage: 5">
								
									<td>{{ x.patient.PatientName }}</td>
									<td>{{ x.PatientClass}} </td>
									<td>{{ x.AssignedPatientLocation }}</td>
									<td>{{ x.doctor.Name  }} </td>
									<td>{{x.department.DepartmentName}}</td>
									
									<td><a href="#/ShowTreatment/{{x.VisitId}}"> <button type="submit" class="btn btn-default">View</button></a></td>
								
								</tr>
							</tbody>
						</table>
						<dir-pagination-controls
					
					direction-links="true"
					boundary-links="true" >
				</dir-pagination-controls>
					
				</div>
			</div>
		