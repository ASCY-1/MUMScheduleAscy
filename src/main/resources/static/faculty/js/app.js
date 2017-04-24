angular
    .module(
    'mumSched',
    ['ngRoute','mumSched.index'])
    .config(['$locationProvider','$routeProvider',function ($locationProvider, $routeProvider) {
        $routeProvider.otherwise({
            redirectTo:"/offerings"
        });
    }]);
