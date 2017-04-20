'use strict';

var myApp = angular.module('mumSched', ['ngRoute'])
// Declare app level module which depends on views, and components
//angular.module('mumSched', [
//    'ngMaterial',
//    'mumSched.login',
//    'mumSched.dashboard',
//    
//])
//    
//    .config(['$locationProvider', '$routeProvider',function($locationProvider, $routeProvider) {
//  
//        $locationProvider.hashPrefix('!');
//        $routeProvider.when('/',{
//        	resolve:{
//                factory: checkRouting    
//            } 
//            
//        }).
//        
//        otherwise({redirectTo: '/login'});
//    }]);
//
//        
//  var checkRouting= function ($q, $location, httpWrapper, $rootScope) {
//      console.log("inside check routing");
//    if ($rootScope.userProfile) {
//        console.log("returned herer");
//        return true;
//    }else {
//        console.log("HERE SDSKFSDKFS ");
//        var deferred = $q.defer();
//        httpWrapper.get({},"/me").then(function (response) {
//                $rootScope.userProfile = response.data;
//                console.log("hree"+response);
//            
//                $location.path("/dashboard");
//                
//                //the role based route goes here
//                deferred.resolve(true);
//            },function () {
//                deferred.reject();
//                $location.path("/login");
//             });
//        return deferred.promise;
//    }
//  };
// 