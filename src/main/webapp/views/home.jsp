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
                <li><a href="/minivill">Mini Village</a></li>
                <li><a href="">Game2</a></li>
                <li><a href="">Game3</a></li>
              </ul>
            </li>
            <li><a href="">About</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <a href="/login"><button id="btnLogin" type="submit" class="btn btn-success">Sign in</button></a>
            <a href="/join"><button id="btnJoin" type="button" class="btn btn-primary">Sign up</button></a>
            <button id="btnLogout" type="button" class="btn btn-danger" style="display:none;">Logout</button>
          </form>
	      </div>
      </div>
    </div>
    <div id="userInfo" class="panel panel-default" style="width:15%;position:absolute;display:none;margin:40px 15px 15px 15px;">
	  <div class="panel-heading">User Infomation</div>
	  <div class="panel-body">
	    <span id="name"></span><br/>
	  </div>
	</div>
    <div class="col-xs-2 col-sm-2 sidebar-offcanvas" style="top:170px;display:none;" id="sidebar" role="navigation">
          <div class="well sidebar-nav">
            <ul class="nav">
              <li>Talk</li>
              <li class="active"><a href="#">Rule</a></li>
              <li><a href="#">Tutorial</a></li>
              <li>Play</li>
              <li><a href="#">Single Play</a></li>
              <li><a href="#">Multi Play</a></li>
              <li>Love</li>
              <li><a href="#">Score</a></li>
              <li><a href="#">Rank</a></li>
            </ul>
          </div><!--/.well -->
        </div><!--/span-->
    <div ng-view class="container" style="width:65%;min-height:600px;"></div>
    <div class="container" style="width:65%;">
    <footer>
    	<hr>
        <p>Korean Secret Weapon&copy; Company 2014.</p>
      </footer>
    </div>
</body>
</html>
