

		<div class="panel panel-primary" ng-style="stylehistory">
                <div class="panel-heading">  Search Patient Visit </div>
                 <div class="panel-body">
                     <div>
                            <form role="form" data-ng-submit="search()" enctype="multipart/form-data">
                                
                                 <div class="form-group">
                                <label for="department">Department:</label>
                                <div class="dropdown">
                                	<select  ng-model="DepartmentId" data-ng-change="onDepartmentChange(itemSelected)" ng-options="i.DepartmentId as i.DepartmentName for i in Deptdata">
        							<option value="0">Select Department</option>
      							</select>
      							
                                  
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="doctor">Doctor:</label>
                                <div class="dropdown">
                                <select  ng-model="DoctorId" data-ng-change="onDoctorChange(itemSelected)" ng-options="i.Id as i.Name for i in DoctorData">
        							<option ng-selected="true" value="0">Select Doctor</option>
      							</select>
                               </div></div>
				<div style="display: inline-block; min-height: 290px;">
					<uib-datepicker ng-model="dt" class="well well-sm"
						datepicker-options="options"></uib-datepicker>
				</div>
				<button type="submit" class="btn btn-info">Search</button>
                            </form>
                    </div>
                </div>
            </div>
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
								<th> Doctor </th>
								<th>Visit Time</th>
								
							
							</thead>
							<tbody>
						
								<tr ng-repeat="x in data">
								
									<td>{{ x.patient.PatientName }}</td>
									<td>{{ x.patient.Cnic}} </td>
									<td>{{ x.patient.DOB | ageFilter }}</td>
									<td>{{ x.doctor.Name  }} </td>
									<td><label ng-bind="x.VisitTime |  date:'MM/dd/yyyy HH:mm:ss'"></td>
									
									<td><a href="#/ShowTreatment/{{x.VisitId}}"> <button type="submit" class="btn btn-default">View</button></a></td>
								
								</tr>
							</tbody>
						</table>
					
				</div>
			</div>
		