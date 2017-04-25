
angular.module('mumSched.index',['ngRoute','ngCookies'])
    .config(['$routeProvider','$locationProvider',function ($routeProvider,$locationProvider) {
       $routeProvider
           .when(
               '/SectReg', {
                   templateUrl: "facultyTemplates/regSect.html",
                   controller: "registeredController"
               });

    }])
    .controller("registeredController",['$scope','httpWrapper',function($scope,httpWrapper){
      // $scope.pageSubTitle = "registered sections";
       $scope.names = ["Emil", "Tobias", "Linus"];
        $scope.message = "";

       
        
  
        
        
        var getCourses = function(){

           console.log("function in calss");

         httpWrapper.get({},"/section").then(function (response) {
             console.log(response);
            x= response.data;
            $scope.allSections = response.data;
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

       $scope.saveStdRegSec = function(){
    	   	
       };
       $scope.courseSelected = function ($event) {
            console.log($event);
       };
    }]);