var app = angular.module("mumSched", ["ngRoute","ngCookies"]);
console.log("inside script script");


app.controller("mainController", ['$scope','$http','$cookieStore', 'httpWrapper', myFunc]);
//=============Controller Loaders==============//
	function myFunc($scope, $http,$cookieStore, httpWrapper) {
		//=============Blocks ==============//
		    $scope.form = {};
		    console.log($cookieStore.get("token")); 
		    
		    $scope.sendData = function () {
		    	httpWrapper.post($scope.form, 'http://localhost:8080/block')
		         .then(function (response) {
		        	 $scope.getBlocks();
		        	 $scope.form = {};
		        	 toastr.success("Success");
		         },function (response) {
		        	 toastr.error("Error");
		         });
		     };
		     
		     $scope.blocks = [];
		     $scope.getBlocks = function(){
                 httpWrapper.get({},'http://localhost:8080/block').then(function(data){
		        	 $scope.blocks = data.data;
		        	 console.log(data.data);
		         }, function (data) {
					 console.log("Error :"+data);
                 });
		     };
		     $scope.getBlocks();
		     
	   //=============Students ==============//
		    $scope.student = {};
		    $scope.sendStudentData = function () {
		         $http.post('http://localhost:8080/student', $scope.student)
		         .success(function (data, status, headers, config) {
		        	 $scope.getStudents();
		        	 $scope.student = {};
		        	 toastr.success("Student Successfully");
		         })
		         .error(function (data, status, header, config) {
		        	 toastr.error("Error");
		         });
		     };
		     
		     $scope.students = [];
		     $scope.getStudents = function(){
		    	 httpWrapper.get({},'http://localhost:8080/student').then(function(data){
		        	 $scope.students = data.data;
		         }, function (data) {
					 console.log("Error :"+data);
                 });
//		    	 $http.get('http://localhost:8080/student').success(function(data){
//		        	 $scope.students = data;
//		         });
		     };
		     $scope.getStudents();
	    
	}


//=============All Routes==============//
	app.config(function ($routeProvider) {
	    $routeProvider
	        .when("/", {
	            templateUrl: "students-sec.html"
	        })
	        .when("/blocks", {
	        templateUrl: "blocks.html"
	    }).when("/courses", {
	        templateUrl: "courses.html"
	    }).when("/faculty", {
	            templateUrl: "faculty.html"
	    });
	});