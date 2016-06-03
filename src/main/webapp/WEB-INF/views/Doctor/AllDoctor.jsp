
<div class="mui-panel" style="background: #ECF0F5;">

	<a href="http://localhost:8080/eHealthService/admin/#/InsertDoctor">Add
		New Doctor</a> <br> <br>

	<table class="mui-table">
		<thead>
			<th>Picture</th>
			<th>Name</th>
			<th>Email</th>
			<th>Degree</th>
			<th>Specialization</th>
			<th>Department</th>
			<th>Edit</th>
			<th>Delete</th>

		</thead>
		<tbody>

			<tr dir-paginate="x in alldoctor | itemsPerPage: 2">
				<td><img width="50" height="50"
					ng-src="data:image/JPEG;base64,{{ x.Content }}"></td>
				<td><a href="#/Profile/{{x.Id}}">{{ x.Name }} </a></td>
				<td>{{ x.Email}}</td>
				<td>{{ x.Degree }}</td>
				<td>{{ x.Specialization }}</td>
				<td>{{ x.department.DepartmentName }}</td>
				<td><a href="#/EditDoctor/{{x.Id}}"> Edit </a></td>
				<td><a href="#/DeleteDoctor/{{x.Id}}"> Delete </a></td>
			</tr>
		</tbody>
	</table>
	<div class="mui-divider"></div>
	<div  style="margin: auto;  width: 25%; " >
	<dir-pagination-controls  direction-links="true" boundary-links="true">
	</dir-pagination-controls>
	</div>

</div>
