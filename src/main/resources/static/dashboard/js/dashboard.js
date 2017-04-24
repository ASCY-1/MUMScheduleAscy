
 angular.module('mumSched.dashboard', ['ngRoute'])
.config(['$routeProvider', function($routeProvider) {
        //if multiple add here
        $routeProvider.when("/dashboard", {
            templateUrl: "dashboard/registrarDashboard.html",
            controller :"studentDashboard"
        });
    }])
     .controller('studentDashboard', function() {});

