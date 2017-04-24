
 angular.module('##Replace with component name', ['ngRoute'])
.config(['$routeProvider', function($routeProvider) {
        //if multiple add here
        $routeProvider.when("/route", {
            templateUrl: "feature/feature.html",
            controller :"controller-name"
        });
    }])
     .controller('controller-name', function() {});

