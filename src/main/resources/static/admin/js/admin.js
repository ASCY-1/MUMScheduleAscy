var adminApp = angular.module("adminApp", ['ngRoutes']);

adminApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/admin', {
        templateUrl: 'admin/admin.html',
//        controller: 'loginController'
    });
}])