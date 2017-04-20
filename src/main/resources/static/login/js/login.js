
 angular.module('mumSched.login', ['ngRoute'])
.config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/login', {
            templateUrl: 'login/login.html',
            controller: 'loginController'
        });
    }])
.controller('loginController', function($http,$scope,$rootScope,$location,httpWrapper) {
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
                $location.path("/");
                console.log($rootScope);
                httpWrapper.get({},"/me").then(function(response){
                	$rootScope.userProfile = response.data;
                },function(response){
                	console.error("Something wrong in fetching the user profile. In login.js");
                })
                
            }, function errorCallback(response) {
               $scope.error = "Invalid login" + response;
            })
        }
    });

