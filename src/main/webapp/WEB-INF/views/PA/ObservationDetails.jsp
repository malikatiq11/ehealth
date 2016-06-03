


<div class="panel panel-info">
	<div class="panel-heading">
		<h3 class="panel-title">Patient Visit of {{TestName}}</h3>
	</div>
	<div class="panel-body">
		<div class="row">
		

		
			<div class=" col-md-9 col-lg-9 ">
				<table class="table table-user-information">
					<tbody>
						  <tr ng-repeat="data in ObxIden">
						<td>{{data}}</td>
						<td>{{Obxvalue[$index]}}</td>
						</tr>

					</tbody>
				</table>

		{{Obxvalue}}
			</div>
		</div>
	</div>


</div>
