 angular.module('mumSched.login', ['ngRoute'])
.config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/login', {
            templateUrl: 'login/login.html',
            controller: 'loginController'
        });
    }])
.controller('loginController', function($http,$scope,$rootScope,$location) {
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
               
                $rootScope.token = response.data.token;
                $location.path("/");
            }, function errorCallback(response) {
               $scope.error = "Invalid login" + response;
            })
        }
    });

