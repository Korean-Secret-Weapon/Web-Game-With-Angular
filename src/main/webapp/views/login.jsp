<form class="form-signin" ng-controller="LoginController">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="form-control" placeholder="Email address" ng-model="email" autofocus>
        <input type="password" class="form-control" placeholder="Password" ng-model="password">
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-lg btn-success btn-block" ng-click="login()" type="submit">Sign in</button>
</form>