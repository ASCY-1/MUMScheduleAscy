'use strict';

// Declare app level module which depends on views, and components
angular.module('mumSched', [
    'ngMaterial',
    'mumSched.login'
])
    .config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');
  $routeProvider.otherwise({redirectTo: '/login'});
}])
