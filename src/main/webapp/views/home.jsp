<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page pageEncoding='UTF-8'%>
<!DOCTYPE html>
<html ng-app="myApp">
<head>
	<title>Korean Secret Weapon Web Games!</title>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Expires" content="0"/> 
	<meta http-equiv="Pragma" content="no-cache"/>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <link href="/resources/lib/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="/resources/lib/bootstrap/css/signin.css" rel="stylesheet">
    <link href="/resources/lib/bootstrap/css/offcanvas.css" rel="stylesheet">
	<script src="/resources/lib/angular/angular.js"></script>
	<script src="/resources/lib/bootstrap/js/bootstrap.min.js"></script>
    <script src="/resources/lib/myApp.js"></script>
    
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/">Korean Secret Weapon Web Games</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="/">Main</a></li>
            <li class="dropdown">
              <a href="" class="dropdown-toggle" data-toggle="dropdown">Games<b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="">Game1</a></li>
                <li><a href="">Game2</a></li>
                <li><a href="">Game3</a></li>
              </ul>
            </li>
            <li><a href="">About</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <a href="/login"><button type="submit" class="btn btn-success">Sign in</button></a>
            <a href="/join"><button type="button" class="btn btn-primary">Sign up</button></a>
          </form>
	      </div>
      </div>
    </div>
    <div ng-view class="container"></div>
    <div class="container">
    <footer>
    	<hr>
        <p>Korean Secret Weapon&copy; Company 2014.</p>
      </footer>
    </div>
</body>
</html>
