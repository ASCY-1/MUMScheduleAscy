 angular.module('mumSched.login', ['ngRoute','ngCookies'])
.config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/', {
            templateUrl: 'login/login.html',
            controller: 'loginController'
        });
    }])
.controller('loginController', function($http, $scope, $rootScope, $location, httpWrapper, $window, $cookieStore, $window) {
        $scope.user = {
            userName:"admin@ascy.com",
            password:"123"
        };

        $scope.send=function () {
            
            var user = $scope.user;
            var req = {
                method: 'POST',
                url: 'http://localhost:8080/login',
                headers: {
                    'Content-Type': 'Application/json'
                },
                data: user
            }
            $http(req).then(function successCallback(response) {
                $rootScope.token = response.data.token;
				$cookieStore.put('token', response.data.token);
                httpWrapper.get({},"/me").then(function(response){
                	$rootScope.userProfile = response.data;
                	$cookieStore.put('userProfile', response.data); 
                	redirectUser();
                },function(response){
                	console.error("Something wrong in fetching the user profile. In login.js");
                })
                
            }, function errorCallback(response) {
               $scope.error = "Invalid login" + response;
            });
            
            function redirectUser(){
                 switch($rootScope.userProfile.role){
                 	case "ADMIN":
                 		$window.location.href = 'admin';
                 		break;
                 	case "FACULTY":
                 		$window.location.href = 'facultyIndex';
                 		break;
                 	case "STUDENT":
                 		$window.location.href = 'student_home';
                 		break;
                 	default: 
                 		console.log("Default");
                 }
            }
        }
    });

