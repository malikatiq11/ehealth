
<div class="row">

	<div class="col-md-6">


		<div class="panel panel-success">
			<div class="panel-heading">
				<h1>Patient Information</h1>
			</div>
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
				<div class="group">
					<label for="bgroup">Blood Group:</label> <input type="text"
						class="form-control" id="bgroup" disabled="disabled">
				</div>
				<div class="group">
					<label for="department">Department:</label> <input type="Select"
						class="form-control" data-ng-model="DepartmentId" id="department"
						disabled="disabled">
				</div>
				<div class="group">
					<label for="doctor">Doctor:</label> <input type="Select"
						class="form-control" data-ng-model="DoctorId" id="doctor"
						disabled="disabled">
				</div>
			</div>
		</div>
	</div>

	<div class="col-md-6">

		<div class="panel panel-success">

			<div class="panel-heading">
				<h1>Pre-requisite</h1>
			</div>
			<div class="panel-body">



				<div class="form-group">
					<label for="PatientClass">PatientClass </label> <input type="text"
						class="form-control" id="PatientClass"
						data-ng-model="PatientClass" placeholder="PatientClass">
				</div>

				<div class="form-group">
					<label for="AssignedPatientLocation">AssignedPatientLocation
						Type</label> <input type="text" class="form-control"
						id="AssignedPatientLocation"
						data-ng-model="AssignedPatientLocation"
						placeholder="AssignedPatientLocation">
				</div>
				<div class="form-group">
					<label for="AdmissionType">Admission Type</label> <input
						type="text" class="form-control" id="AdmissionType"
						data-ng-model="AdmissionType" placeholder="Email">
				</div>





				<div class="form-group">
					<label for="Weight">Weight</label> <input type="text"
						class="form-control" id="Weight" data-ng-model="Weight"
						placeholder="Email">
				</div>
				<div class="form-group">
					<label for="Tempreture">Tempreture </label> <input type="text"
						class="form-control" id="Tempreture" data-ng-model="Tempreture"
						placeholder="Email">
				</div>

				<div class="form-group">
					<label for="Pressure">Pressure </label> <input type="text"
						class="form-control" id="Pressure" data-ng-model="Pressure"
						placeholder="Email">
				</div>

				<div class="form-group">
					<label for="Pulse ">Pulse </label> <input type="text"
						class="form-control" id="Pulse " data-ng-model="Pulse"
						placeholder="Email">
				</div>

				<div class="form-group">
					<label for="BP">BP </label> <input type="text" class="form-control"
						id="BP" data-ng-model="BP" placeholder="Email">
				</div>



			</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-12">
		<div class="panel panel-primary">

			<div class="panel-heading">
				<h1>Doctor's Opinion</h1>
			</div>
			<div class="panel-body">
				<form role="form" data-ng-submit="submit()">
					<div class="form-group">
						<label for="clinical">Symptom</label>
						<textarea class="form-control" rows="5" data-ng-model="Symptom"
							id="clinical"></textarea>
					</div>
					<div class="form-group">
						<label for="prescription">Investigation:</label>
						<textarea class="form-control" rows="5"
							data-ng-model="Investigation" id="prescription"></textarea>
					</div>
					<div class="form-group">
						<label for="prescription">PatientProcedure:</label>
						<textarea class="form-control" rows="5"
							data-ng-model="PatientProcedure" id="prescription"></textarea>
					</div>


					<div class="form-group">

						<uib-accordion> <uib-accordion-group
							is-open="status.open"> <uib-accordion-heading>
						Refer to Laboratory <i class="pull-right glyphicon"
							ng-class="{'glyphicon-chevron-down': status.open, 'glyphicon-chevron-right': !status.open}"></i>
						</uib-accordion-heading>
						<div>
							<uib-tabset active="activeForm"> <uib-tab index="0"
								heading="Laboratory Test"> <select
								data-ng-model="LISObject.message"
								data-ng-change="OnChange(itemSelected)">
								<option value="0" data-ng-selected="true">Select a Test</option>
								<option value="Urinere">Urinere</option>
								<option value="Serum">Serum</option>
							</select> </uib-tab> <uib-tab index="1" heading="Radiology test"> <input
								type="text" class="form-control" id="RISName"
								data-ng-model="RISObject.message" placeholder="Test Name">

							</uib-tab> </uib-tabset>
						</div>
						</uib-accordion-group> </uib-accordion>


					</div>


					<div class="form-group">
						<uib-accordion> <uib-accordion-group
							is-open="status.open"> <uib-accordion-heading>
						Refer to another Doctor <i class="pull-right glyphicon"
							ng-class="{'glyphicon-chevron-down': status.open, 'glyphicon-chevron-right': !status.open}"></i>
						</uib-accordion-heading>
						<div class="dropdown">
							<label for="department">Department:</label> <select
								ng-model="DepartmentObject.message"
								data-ng-change="onDepartmentChange(itemSelected)"
								ng-options="i.DepartmentId as i.DepartmentName for i in Deptdata">
								<option value="0">Select Department</option>
							</select>
						</div>
						<br>

						<div class="dropdown">
							<label for="doctor">Doctor:</label> <select
								ng-model="DoctorObject.message"
								data-ng-change="onDoctorChange(itemSelected)"
								ng-options="i.Id as i.Name for i in DoctorData">
								<option ng-selected="true" value="0">Select Doctor</option>
							</select>

						</div>
						</uib-accordion-group> </uib-accordion>
					</div>
				
					<div class="form-group">

						<uib-accordion> <uib-accordion-group
							is-open="status.open"> <uib-accordion-heading>
						Give Appointment <i class="pull-right glyphicon"
							ng-class="{'glyphicon-chevron-down': status.open, 'glyphicon-chevron-right': !status.open}"></i>
						</uib-accordion-heading>
						<div>
							<div style="display: inline-block; min-height: 290px;">
					<uib-datepicker ng-model="DateObject.message" class="well well-sm"
						datepicker-options="options"></uib-datepicker>
						<button type="button" ng-click="appointmentsubmit()" class="btn btn-info">Add Appointment</button>
					
				</div>
				
						</div>
						</uib-accordion-group> </uib-accordion>


					</div>

					<button type="submit" class="btn btn-info">Submit</button>
					<a href="#/ShowHl7"><button class="btn btn-info">Refere
							To LIS</button></a> <a href="#/GetVisit/{{cnic}}"><button
							class="btn btn-info">History</button></a>
							<td><a href="#/LaboratoryObservation/{{cnic}}"> <button type="submit" class="btn btn-default">lab Result</button>
									</a></td>
				</form>
			</div>
		</div>
	</div>
</div>

