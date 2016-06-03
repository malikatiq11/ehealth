
		<div class="panel panel-primary">
                <div class="panel-heading"> <h1> Search Patient </h1></div>
                 <div class="panel-body">
                     <div>
                            <form role="form" data-ng-submit="search()" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label for="name">Search by Id:</label>
                                    <input type="text" data-ng-model="PatientId" class="form-control" id="name">
                                </div>
                                <div class="form-group">
                                    <label for="cnic">Search by CNIC:</label>
                                    <input type="text"  data-ng-model="Cnic" class="form-control" id="cnic">
                                </div>
                                
                                <button type="submit" class="btn btn-info">Search</button>
                            </form>
                    </div>
                </div>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading"><h1>Patient Information</h1></div>
                <div class="panel-body">
                    <div>
                        <form role="form" ng-submit="submit()">
                        <label ng-bind="DOB |  date:'MM/dd/yyyy HH:mm:ss'"></label>
                            <div class="form-group">
                                <label for="refId">Reference ID:</label>
                                <input type="text" data-ng-model="PatientId" class="form-control" id="refId">
                            </div>
                            <div class="form-group">
                                <label for="name">Name:</label>
                                <input type="text" data-ng-model="PatientName" class="form-control" id="name">
                            </div>
                            <div class="form-group">
                                <label for="cnic">CNIC:</label>
                                <input type="text" data-ng-model="Cnic" class="form-control" id="cnic">
                            </div>
                            <div class="form-group">
                                <label for="age">Age:</label>
                                <input type="text" data-ng-model="DOB" class="form-control" id="age">
                            </div>
                            <div class="form-group">
                                <label for="gender">Gender:</label>
                                <input type="text" data-ng-model="Sex" class="form-control" id="gender">
                            </div>
                            <div class="form-group">
                                <label for="bgroup">Blood Group:</label>
                                <input type="text" class="form-control" id="bgroup">
                            </div>
                            <div class="form-group">
                                <label for="department">Department:</label>
                                <div class="dropdown">
                                	<select  ng-model="DepartmentId" data-ng-change="onDepartmentChange(itemSelected)" ng-options="i.DepartmentId as i.DepartmentName for i in data">
        							<option value="0">Select Department</option>
      							</select>
                                   <!--  <button class="btn btn-default dropdown-toggle" type="button" id="department" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">Select Department
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                        <li><a href="#">Action</a></li>
                                        <li><a href="#">Another action</a></li>
                                        <li><a href="#">Something else here</a></li>
                                    </ul>-->
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="doctor">Doctor:</label>
                                <div class="dropdown">
                                <select  ng-model="DoctorId" data-ng-change="onDoctorChange(itemSelected)" ng-options="i.Id as i.Name for i in DoctorData">
        							<option ng-selected="true" value="0">Select Doctor</option>
      							</select>
                                   <!--  <button class="btn btn-default dropdown-toggle" type="button" id="doctor" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">Select Doctor
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                        <li><a href="#">Action</a></li>
                                        <li><a href="#">Another action</a></li>
                                        <li><a href="#">Something else here</a></li>
                                    </ul>
                                     -->
                                </div>
                            </div>
                            
                            <button type="Submit" class="btn btn-info">Register Visit</button>
                        </form>
                    </div>
                </div>
            </div>
   

