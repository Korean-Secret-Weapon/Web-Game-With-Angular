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
			templateUrl : 'views/mainA.jsp'
		}).otherwise({
			templateUrl : 'views/main.jsp'
		});
	}]);
	
	myApp.factory('server', [ '$http', function($http) {
		return {
			get : function(sqlId) {
				return $http.get('/get', { params : { query : sqlId }});
			},
			join : function(sqlId,data) {
				return $http.post('/join', { data : { data : data }});
			}
		};
	}]);
			
	function MainController($scope,server){
		server.get("main.notice_srch").success(function(data, status, headers, config) {
			$scope.items = data.list;
		}).error(function(data, status, headers, config) {
			alert('error code: '+status);
		});
	}
			
	function JoinController($scope,server){
		$scope.join = function(){
			if($scope.form.password!=$scope.form.password2){
				alert('Incorrected Password.');
				return;
			}
			server.join("main.join",$scope.form).success(function(data, status, headers, config) {
				alert('회원가입을 축하합니다.');
				$location.path("/main");
			}).error(function(data, status, headers, config) {
				alert('error code: '+status);
			});
		}
	}
	
	function AdminController($scope){
	}
	
	function LoginController($scope,$location){
		$scope.login = function(){
			if($scope.id=="admin" && $scope.password=="admin"){
				alert('반갑습니다. 관리자님!');
				$location.path("/admin");
			};
		}
	}