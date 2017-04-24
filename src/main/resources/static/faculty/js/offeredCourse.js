/**
 * Created by 985649 on 4/20/2017.
 */
angular.module('mumSched.index',['ngRoute','ngCookies'])
    .config(['$routeProvider','$locationProvider',function ($routeProvider,$locationProvider) {
       $routeProvider
           .when(
               '/offerings', {
                   templateUrl: "facultyTemplates/offers.html",
                   controller: "offeredController"
               });

    }])
    .controller("offeredController",['$scope','httpWrapper',function($scope,httpWrapper){
       $scope.pageSubTitle = "Offered Courses";
       $scope.message = "";
        var getCourses = function(){

           console.log("fucntion  ");

         httpWrapper.get({},"/course").then(function (response) {
             console.log(response);
            x= response.data;
            $scope.allCourses = response.data;
         },function (response) {
            var display= '<div class="alert alert-danger" role="alert">'
                + '<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>' +
                '<span class="sr-only">' +
                'Error:' +
                '</span>' +
                response.data+
                '</div>';
            $scope.message = display;
            console.error(response);

         });

       };
        getCourses();

       $scope.saveOffer = function(){

       };
       $scope.courseSelected = function ($event) {
            console.log($event);
       };
    }]);