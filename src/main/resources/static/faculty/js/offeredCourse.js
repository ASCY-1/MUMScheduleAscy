/**
 * Created by 985649 on 4/20/2017.
 */
angular.module('mumSched.index')
    .config(['$routeProvider','$locationProvider'],function ($routeProvider,$locationProvider) {
       $routeProvider
           .when(
               '/offerings', {
                   templateUrl: "faculty/offered.html",
                   controller: "offeredController"
               });

    })
    .controller(['$scope','httpWrapper'],function($scope,httpWrapper){

    });