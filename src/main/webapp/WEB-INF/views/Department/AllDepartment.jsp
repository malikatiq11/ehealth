

<div class="mui-panel" style=" background: #ECF0F5;">
	<a href="#/InsertDept">Add New Department</a>
	<br>
	<br>
	<table class="mui-table">
		<thead>
			<th>Department Name</th>
			<th>Department Description</th>
			<th>Edit</th>
			<th>Delete</th>
		</thead>
		<tbody>
			<tr dir-paginate="x in data |itemsPerPage : 2">

				<td>{{ x.DepartmentName }}</td>
				<td>{{ x.DepartmentDescription }}</td>
				<td><a href="#/EditDept/{{x.DepartmentId}}"> Edit </a></td>
				<td><a href="#/DeleteDept/{{x.DepartmentId}}"> Delete </a></td>
			</tr>
		</tbody>

	</table>
	<div class="mui-divider"></div>
	<div  style="margin: auto;  width: 25%; " >
	<dir-pagination-controls  direction-links="true" boundary-links="true">
	</dir-pagination-controls>
	</div>

</div>





