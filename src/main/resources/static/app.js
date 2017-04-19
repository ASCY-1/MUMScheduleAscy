'use strict';

// Declare app level module which depends on views, and components
angular.module('mumSched', [
    'ngMaterial',
    'mumSched.login'
])
    
    .config(['$locationProvider', '$routeProvider',function($locationProvider, $routeProvider) {
  
        $locationProvider.hashPrefix('!');
        $routeProvider.otherwise({redirectTo: '/login'});
    }]);

        
  var checkRouting= function ($q, $location,httpWrapper) {
    if ($rootscope.userProfile) {
        return true;
    } 
      else {
        var deferred = $q.defer();
        httpWrapper.get({},"/me")
            .success(function (response) {
                $rootscope.userProfile = response.data;
                console.log();
                deferred.resolve(true);
            })
            .error(function () {
                deferred.reject();
                $location.path("/login");
             });
        return deferred.promise;
    }
  };
 