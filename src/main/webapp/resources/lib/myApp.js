/**
 * Main Script
 * Author : 김종훈
 * Date   : 2014-08-22
 * Description : 없어 그런거. 각자 공부 ㄱ
 */
	var myApp = angular.module('myApp', []);
			
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
			login : function(email,password){
				return $http({
				    method: 'POST',
				    url: '/login',
				    params : { email : email, password : password }
				});
			}
		};
	}]);
	
	function getJsonArrayData(data,param){
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
	
	function getJsonObjectData(data,param){
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
			
	function MainController($scope,server){
		server.list(null,"main.notice_srch").success(function(data, status, headers, config) {
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
			server.insert(getJsonObjectData($scope.form,"$scope.form."),"main.user_info_insert").success(function(data, status, headers, config) {
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
			if($scope.id=="admin" && $scope.password=="admin"){
				alert('반갑습니다. 관리자님!');
				$location.path("/admin");
			}else if($scope.id==null || $scope.password==null){
				alert('Please Input E-Mail or Password');
			}else{
				server.login($scope.email,$scope.password);
			};
		}
	}