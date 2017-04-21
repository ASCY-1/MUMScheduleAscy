angular
    .module(
    'mumSched',
    ['ngRoute',])
    .config(['$locationProvider','$routeProvider',function ($locationProvider, $routeProvider) {
        $routeProvider.otherwise({
            redirectTo:"/index"
        });
    }]);
