


<div class="panel panel-info">
	<div class="panel-heading">
		<h3 class="panel-title">Dr. {{Name}}</h3>
	</div>
	<div class="panel-body">
		<div class="row">
			<div class="col-md-3 col-lg-3 " align="center">
				<img alt="User Pic"
					ng-src="data:image/JPEG;base64,{{ImageByte}}"
					class="img-circle img-responsive">
			</div>

		
			<div class=" col-md-9 col-lg-9 ">
				<table class="table table-user-information">
					<tbody>
						<tr>
							<td>Department:</td>
							<td>{{DepartmentName}}</td>
						</tr>
						<tr>
							<td>Specialization</td>
							<td>{{Specialization}}</td>
						</tr>
						<tr>
							<td>Degree</td>
							<td>{{Degree}}</td>
						</tr>

						<tr>
						<tr>
							<td>Email</td>
							<td>{{Email}}</td>
						</tr>
						<tr>
							<td>HomeAddress</td>
							<td>{{HomeAddress}}</td>
						</tr>
						<tr>
							<td>OfficeAddress</td>
							<td>{{OfficeAddress}}</td>
						</tr>
						<tr>
							<td>Sex</td>
							<td>{{Sex}}</td>
						</tr>
						
						<tr>
							<td>BirthDate</td>
							<td><label ng-bind="BirthDate |  date:'MM/dd/yyyy'"></label></td>
						</tr>
						
						

					</tbody>
				</table>

				
			</div>
		</div>
	</div>


</div>
