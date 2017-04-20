 angular.module('mumSched.login', ['ngRoute'])
.config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/', {
            templateUrl: 'login/login.html',
            controller: 'loginController'
        });
    }])
.controller('loginController', function($http,$scope,$rootScope,$location,httpWrapper,$window) {
        $scope.user = {
            userName:"email@mail.com",
            password:"pass"
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
                httpWrapper.get({},"/me").then(function(response){
                	$rootScope.userProfile = response.data;
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
//                 		$location.path("/admin");
                 		$window.location.href = 'admin';
//                 		$window.location.href = '/faculty2';
                 		break;
                 	case "FACULTY":
                 		$window.location.href = 'admin.html';
                 		break;
                 	case "STUDENT":
                 		console.log("student");
                 		$location.path("/student");
                 		break;
                 	default: 
                 		console.log("Default");
                 }
            }
        }
    });

