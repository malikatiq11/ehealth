
<div class="row">
	<div class="col-md-3"></div>


	<div class="col-md-6">

		<form data-ng-submit="submit()"
		style="width: 380px; padding: 3em 2em 2em 2em; background: #ECF0F5; border: 1px solid #ebebeb;">
			<h1 style="text-align: center; color: #3C8DBC">Update Department</h1>
			<div class="mui-textfield mui-textfield--float-label">
				<input type="text" id="DepartmentName"
					data-ng-model="DepartmentName"> <label for="DepartmentName">Department
					Name</label>
			</div>
			<div class="mui-textfield mui-textfield--float-label">
				<input type="text" id="DepartmentDescription"
					data-ng-model="DepartmentDescription"> <label
					for="DepartmentDescription">Department Description </label>
			</div>

			<br>
			<button type="submit" class="mui-btn mui-btn--primary"
					style="position: relative; display: inline-block; padding: 12px 24px; margin: .3em 0 1em 0; width: 100%; vertical-align: middle; color: #fff; font-size: 16px; line-height: 20px; -webkit-font-smoothing: antialiased; text-align: center; letter-spacing: 1px; background:#3C8DBC; border: 0; border-bottom: 2px solid #3160B6; cursor: pointer; text-shadow: 1px 1px 0 rgba(39, 110, 204, .5); transition: all 0.15s ease;">Submit</button>
				<uib-alert ng-style="alertstyle" type="{{message.type}}" close="closeAlert()">{{message.msg}}</uib-alert>
		</form>

	</div>

	<div class="col-md-3"></div>
</div>


