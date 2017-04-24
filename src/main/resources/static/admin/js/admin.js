var adminApp = angular.module("adminApp", ['ngRoutes']);

adminApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/admin_old', {
        templateUrl: 'admin_old/admin_old.html',
//        controller: 'loginController'
    });
}])