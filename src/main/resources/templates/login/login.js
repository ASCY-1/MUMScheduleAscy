/**
 * Created by 985649 on 4/17/2017.
 */

angular.module('mumSched.login', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/login', {
            templateUrl: 'login/login.html',
            controller: 'loginController'
        });
    }])

    .controller('loginController', function($scope,$http) {
        $scope.user = {
            email:"",
            password:""
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
                console.log(response);
            }, function errorCallback(response) {
               $scope.error = "Invalid login" + response;
            })
        }
    });