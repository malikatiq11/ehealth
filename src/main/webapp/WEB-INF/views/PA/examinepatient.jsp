<div class="row">
	<div class="col-md-6">
		<div class="panel panel-success">
			<div class="panel-heading">
				Patient Information
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

		<div class="panel panel-primary">

			<div class="panel-heading">
				<h1>Pre-requisite</h1>
			</div>
			<div class="panel-body">
				<form data-ng-submit="submit()" enctype="multipart/form-data">

					<div class="form-group">
						<select data-ng-model="PatientClass">
							<option value="B">B-Obstetric</option>
							<option value="C">C- Commercial Account</option>
							<option value="E">E- Emergency</option>
							<option value="I">I- InPatient</option>
							<option value="N">N-Not Applicable</option>
							<option value="O">O- OutPatient</option>
							<option value="P">P- PreAdmit</option>
							<option value="R">R- RecurringPatient</option>
							<option value="U">U- UnKnown</option>
						</select>
					</div>
					<div class="form-group">
						<select data-ng-model="AssignedPatientLocation">
							<option value="O/R">O/R</option>
							<option value="Instate">Instate</option>

						</select>
					</div>
					<div class="form-group">
						<select data-ng-model="AdmissionType">
							<option value="A">A-Accident</option>
							<option value="C">C-Elective</option>
							<option value="E">E-Emergency</option>
							<option value="L">L-Labor and Delivery</option>
							<option value="N">N-Newborn</option>
							<option value="R">R-Routine</option>
							<option value="U">U-Urgent</option>

						</select>
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
							class="form-control" id="Pulse " data-ng-model="Pulse "
							placeholder="Email">
					</div>

					<div class="form-group">
						<label for="BP">BP </label> <input type="text"
							class="form-control" id="BP" data-ng-model="BP"
							placeholder="Email">
					</div>






					<button type="submit" class="btn btn-default">Submit</button>


				</form>
			</div>

		</div>
	</div>