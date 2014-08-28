/**
 * Main Script
 * Author : 김종훈
 * Date   : 2014-08-22
 * Description : 없어 그런거. 각자 공부 ㄱ
 */
	var myApp = angular.module('myApp', []);
	
	var userInfo = {
		name : null
	};
	
	$(function(){
		$('#btnLogout').click(function(){
			alert('정상적으로 로그아웃 처리되었습니다.');
			userInfo.name=null;
			location.replace("/");
		});
	});
			
	myApp.config(['$routeProvider','$locationProvider',function($routeProvider,$locationProvider){
		$locationProvider.html5Mode(true);
		$routeProvider.when('/', {
			controller: MainController,
			templateUrl : 'views/main.jsp'
		}).when('/join', {
			controller: JoinController,
			templateUrl : 'views/join.jsp'
		}).when('/login', {
			controller: LoginController,
			templateUrl : 'views/login.jsp'
		}).when('/admin', {
			controller: AdminController,
			templateUrl : 'views/admin.jsp'
		}).when('/minivill', {
			controller: MinivillController,
			templateUrl : 'views/minivill.jsp'
		}).otherwise({
			templateUrl : 'views/main.jsp'
		});
	}]);
	
	myApp.factory('server', [ '$http', function($http) {
		return {
			list : function(data,sqlId) {
				return $http({
				    method: 'POST',
				    url: '/list',
				    data: data,
				    params : { query : sqlId },
				    headers: {'Content-Type': 'application/json;charset=utf-8'}
				});
			},
			save : function(data,sqlId){
				return $http({
				    method: 'POST',
				    url: '/save',
				    data: data,
				    params : { query : sqlId },
				    headers: {'Content-Type': 'application/json;charset=utf-8'}
				});
			},
			update : function(data,sqlId){
				return $http({
				    method: 'POST',
				    url: '/update',
				    data: data,
				    params : { query : sqlId },
				    headers: {'Content-Type': 'application/json;charset=utf-8'}
				});
			},
			del : function(data,sqlId){
				return $http({
				    method: 'POST',
				    url: '/delete',
				    data: data,
				    params : { query : sqlId },
				    headers: {'Content-Type': 'application/json;charset=utf-8'}
				});
			},
			insert : function(data,sqlId){
				return $http({
				    method: 'POST',
				    url: '/insert',
				    data: data,
				    params : { query : sqlId },
				    headers: {'Content-Type': 'application/json;charset=utf-8'}
				});
			},
			login : function(data){
				return $http({
				    method: 'POST',
				    url: '/login',
				    data: data,
				    headers: {'Content-Type': 'application/json;charset=utf-8'}
				});
			}
		};
	}]);
	
	function getJsonArrayData(data){
		var dataArray = new Array();
		var dataMap = new Object();
		var headers = new Array();
		for(obj in data){
			headers.push(obj);
			var str = "dataMap."+obj+"=data."+obj;
			eval(str);
		}
		dataMap.headers = headers;
		dataArray.push(dataMap);
		return JSON.stringify(dataArray);
	}
	
	function getJsonObjectData(data){
		var dataMap = new Object();
		var headers = new Array();
		for(obj in data){
			headers.push(obj);
			var str = "dataMap."+obj+"=data."+obj;
			eval(str);
		}
		dataMap.headers = headers;
		return JSON.stringify(dataMap);
	}
	
	function makeUserInfo($scope){
		if(userInfo.name==null){
			$scope.name="로그인이 필요합니다.";
		}else{
			$scope.name=userInfo.name;
		}
	}
			
	function MainController($scope,server){
		makeUserInfo($scope);
		server.list(null,"main.notice_srch")
		.success(function(data, status, headers, config) {
			$scope.items = data.list;
		}).error(function(data, status, headers, config) {
			alert('error code: '+status);
		});
	}
			
	function JoinController($scope,$location,server){
		$scope.join = function(){
			if($scope.form.password!=$scope.form.password2){
				alert('Incorrected Password.');
				return;
			}
			server.insert(getJsonObjectData($scope.form),"main.user_info_insert")
			.success(function(data, status, headers, config) {
				alert('회원가입을 축하합니다.');
				$location.path("/");
			}).error(function(data, status, headers, config) {
				alert('error code: '+status);
			});
		}
	}
	
	function AdminController($scope){
	}
	
	function LoginController($scope,$location,server){
		$scope.login = function(){
			if($scope.login.email=="admin" && $scope.login.password=="admin"){
				alert('반갑습니다. 관리자님!');
				$location.path("/admin");
			}else if($scope.login.email==null || $scope.login.password==null){
				alert('Please Input E-Mail or Password');
			}else{
				server.login(getJsonObjectData($scope.login))
				.success(function(data, status, headers, config){
					alert(data.userInfo.NAME+'님 환영합니다.');
					userInfo.name=data.userInfo.NAME;
					$('#btnJoin').hide();
					$('#btnLogin').hide();
					$('#btnLogout').show();
					$location.path("/");
				}).error(function(data, status, headers, config) {
					alert('error code: '+status);
				});
			};
		}
	}
	
	function MinivillController($scope){
		makeUserInfo($scope);
		/*$('#sidebar').show();*/
	}