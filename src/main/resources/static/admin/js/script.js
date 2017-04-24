var app = angular.module("mumSched", ["ngRoute","ngCookies"]);
console.log("inside script script");


app.controller("mainController", ['$scope','$http','$cookieStore', 'httpWrapper', myFunc]);
//=============Controller Loaders==============//
	function myFunc($scope, $http,$cookieStore, httpWrapper) {
		 $scope.courses = {};
		
		 $scope.faculties = ["Moses", "Kendakenda", "Asingya", "Kangwanzi"];
		//=============Blocks ==============//
		    $scope.form = {};

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

		     
		//=============Sections ==============//
		     	$scope.sections = [];
			    $scope.viewScetions = function (block) {
			    	console.log("==============progress here===============");
			    	console.log(block);
//			    	httpWrapper.post($scope.form, 'http://localhost:8080/block')
//			         .then(function (response) {
//			        	 $scope.getBlocks();
//			        	 $scope.form = {};
//			        	 toastr.success("Success");
//			         },function (response) {
//			        	 toastr.error("Error");
//			         });
			     };
			     
//			     $scope.blocks = [];
//			     $scope.viewScetions = function(){
//	                 httpWrapper.get({},'http://localhost:8080/block').then(function(data){
//			        	 $scope.blocks = data.data;
//			        	 console.log(data.data);
//			         }, function (data) {
//						 console.log("Error :"+data);
//	                 });
//			     };
//			     $scope.getBlocks();
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
	    
	     //=============Courses ==============//
		    $scope.cform = {};
		   
		    $scope.saveCourse = function () {
		    	httpWrapper.post($scope.cform, 'http://localhost:8080/course')
		         .then(function (response) {
		        	 $scope.getCourses();
		        	 $scope.cform = {};
		        	 toastr.success("Success");
		         },function (response) {
		        	 toastr.error("Error");
		         });
		     };
		     
		     $scope.courses = [];
		     $scope.getCourses = function(){
                 httpWrapper.get({},'http://localhost:8080/course').then(function(data){
		        	 $scope.courses = data.data;
		        	 console.log(data.data);
		         }, function (data) {
					 console.log("Error :"+data);
                 });
		     };
		     
		     
		     $scope.getCourses();
	}


//=============All Routes==============//
	app.config(function ($routeProvider) {
	    $routeProvider
	        .when("/", {
	            templateUrl: "blocks.html"
	        }).when("/student", {
	            templateUrl: "students-sec.html"
	        }).when("/blocks", {
	        	templateUrl: "blocks.html"
		    }).when("/courses", {
		        templateUrl: "courses.html"
		    }).when("/faculty", {
		            templateUrl: "faculty.html"
		    }).when("/profile", {
		            templateUrl: "profiles.html"
		    });
	});