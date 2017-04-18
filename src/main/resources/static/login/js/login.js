
var myApp = angular.module('myApp', ['ngRoute']);
	console.log("Step 1");
myApp.config(['$routeProvider', function($routeProvider) {
        $routeProvider.when("/", {
//        	console.log("Step 2");
//            templateUrl: "login/blocks.html"
            templateUrl: "login/login.html"
        }).when('/login', {
            templateUrl: 'login/login.html',
            controller: 'loginController'
        });
    }]);

myApp.controller('loginController', function($scope,$http) {
        $scope.user = {
            userName:"email@mail.com",
            password:"pass"
        };

        $scope.send=function () {
            console.log($scope.user);
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
                console.log(response.data.token);
            }, function errorCallback(response) {
               $scope.error = "Invalid login" + response;
            })
        }
    });