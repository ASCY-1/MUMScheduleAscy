 angular.module('mumSched.login', ['ngRoute','ngCookies'])
.config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/', {
            templateUrl: 'login/login.html',
            controller: 'loginController'
        });
    }])
.controller('loginController', function($http,$scope,$rootScope,$location,httpWrapper,$window,$cookieStore) {
        $scope.user = {
            userName:"faculty@mail.com",
            password:"password"
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
//               
				$cookieStore.put('token', response.data.token);
                httpWrapper.get({},"/me").then(function(response){
                	$rootScope.userProfile = response.data;
                	$cookieStore.put('userProfile', response.data); 
                	$cookieStore.put('test', "Test 1"); 
                	redirectUser();
                },function(response){
                	console.error("Something wrong in fetching the user profile. In login.js");
                })
                
            }, function errorCallback(response) {
               $scope.error = "Invalid login" + response;
            });
            
            function redirectUser(){
                 console.log("==========++++++++++++++++=========>",$rootScope);
                 switch($rootScope.userProfile.role){
                 	case "ADMIN":
                 		console.log("admin");
                 		$window.location.href = 'admin';
                 		break;
                 	case "FACULTY":
                 		$window.location.href = 'facultyIndex';
                 		break;
                 	case "STUDENT":
                 		console.log("student 1");
                 		$location.path("/student");
                 		break;
                 	default: 
                 		console.log("Default");
                 }
            }
        }
    });

