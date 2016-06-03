<div class="mui-panel" style="background: #ECF0F5;">
					<a href="http://localhost:8080/eHealthService/admin/#/InsertStaff">Add New Staff</a>

						<table  class="mui-table">
							<thead>
								<th> Picture</th>
								<th>Name</th>
								<th>Cnic</th>
								<th>MobileNo</th>
								<th>Roles</th>
								<th>Edit</th>
								<th>Delete</th>
							</thead>
							<tbody>
								<tr dir-paginate="x in data | itemsPerPage: 2">
								<td><img width="50" height="50" ng-src="data:image/JPEG;base64,{{ x.Content }}"></td>
									<td>{{ x.Name }}</td>
									<td>{{ x.Cnic }}</td>
									<td>{{ x.MobileNo }}</td>
									<td>{{ x.roles.RoleName }}</td>
									<td><a href="#/EditStaff/{{x.Id}}"> Edit </a></td>
									<td><a href="#/DeleteStaff/{{x.Id}}"> Delete
									</a></td>
								</tr>
							</tbody>
						</table>
			<div class="mui-divider"></div>
	<div  style="margin: auto;  width: 25%; " >
	<dir-pagination-controls  direction-links="true" boundary-links="true">
	</dir-pagination-controls>
	</div>

</div>