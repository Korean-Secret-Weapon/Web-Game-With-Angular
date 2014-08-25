<div class="form-join well">
<h2 class="form-signin-heading">Sign Up</h2>
<hr>
<form class="form-horizontal" role="form">
  <div class="form-group">
    <label for="inputEmail1" class="col-lg-2 control-label">Email(ID)</label>
    <div class="col-lg-10">
      <input type="email" class="form-control" id="inputEmail1" ng-model="form.email" placeholder="Email">
    </div>
  </div>
  <div class="form-group">
    <label for="inputNickname" class="col-lg-2 control-label">Nick Name</label>
    <div class="col-lg-10">
      <input type="password" class="form-control" id="inputNickname" ng-model="form.nick" placeholder="Password">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword1" class="col-lg-2 control-label">Password</label>
    <div class="col-lg-10">
      <input type="password" class="form-control" id="inputPassword1" ng-model="form.password" placeholder="Password">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword2" class="col-lg-2 control-label">Password Confirm</label>
    <div class="col-lg-10">
      <input type="password" class="form-control" id="inputPassword2" ng-model="form.password2" placeholder="Password">
    </div>
  </div>
  <div class="form-group">
    <div class="col-lg-offset-2 col-lg-10">
      <button type="submit" class="btn btn-lg btn-primary btn-block" ng-click="join()">Sign Up</button>
    </div>
  </div>
</form>
</div>