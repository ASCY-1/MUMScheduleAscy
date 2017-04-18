var app = angular.module("myApp", ["ngRoute"]);

app.controller("mainController", ['$scope','$http', myFunc]);
//=============Controller Loaders==============//
	function myFunc($scope, $http) {
		//=============Blocks ==============//
		    $scope.form = {};
		    $scope.sendData = function () {
		         $http.post('http://localhost:8080/block', $scope.form)
		         .success(function (data, status, headers, config) {
		        	 $scope.getBlocks();
		        	 $scope.form = {};
		        	 toastr.success("Success");
		         })
		         .error(function (data, status, header, config) {
		        	 toastr.error("Error");
		         });
		     };
		     
		     $scope.blocks = [];
		     $scope.getBlocks = function(){
		    	 $http.get('http://localhost:8080/block').success(function(data){
		        	 $scope.blocks = data;
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
		    	 $http.get('http://localhost:8080/student').success(function(data){
		        	 $scope.students = data;
		         });
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