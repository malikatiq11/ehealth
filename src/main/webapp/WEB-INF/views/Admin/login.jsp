<div class="row">
	<div class="col-md-3"></div>


	<div class="col-md-6">
	

	
			<form role="form"
				style="width: 380px; padding: 3em 2em 2em 2em; background: #3C8DBC; border: 1px solid #ebebeb; border-left:5px solid #82E0AA; border-bottom:5px solid #82E0AA; "
				data-ng-submit="submit()">
					<h1 style="text-align:center;color:#ffffff">LOGIN</h1>
				<div class="mui-textfield mui-textfield--float-label">
					<input type="text" id="UserName" data-ng-model="UserName">
					<label for="UserName" style="color: #ffffff">User Name </label>
				</div>
				<div class="mui-textfield mui-textfield--float-label">
					<input type="text" id="Password" data-ng-model="Password">
					<label for="Password" style="color: #ffffff">Password </label>
				</div>
				<br>
				<button type="submit" class="mui-btn mui-btn--primary"
					style="position: relative; display: inline-block; padding: 12px 24px; margin: .3em 0 1em 0; width: 100%; vertical-align: middle; color: #fff; font-size: 16px; line-height: 20px; -webkit-font-smoothing: antialiased; text-align: center; letter-spacing: 1px; background:#28B463; border: 0; border-bottom: 1px solid #82E0AA; cursor: pointer; text-shadow: 1px 1px 0 rgba(39, 110, 204, .5); transition: all 0.15s ease;">Submit</button>
				<uib-alert ng-style="alertstyle" type="{{message.type}}" close="closeAlert()">{{message.msg}}</uib-alert>
			</form>




		</div>
	
	<div class="col-md-3"></div>
</div>