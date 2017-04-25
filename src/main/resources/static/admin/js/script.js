var app = angular.module("mumSched", ["ngRoute","ngCookies"]);
console.log("inside script script");

app.controller("mainController", ['$scope','$http','$cookieStore', 'httpWrapper', myFunc]);
//=============Controller Loaders==============//
	function myFunc($scope, $http,$cookieStore, httpWrapper) {
		 $scope.courses = {};
		 $scope.roles = ["ADMIN", "FACULTY", "STUDENT"];
		 $scope.faculties = {};
		 $scope.blocks = [];
		 $scope.sections = [];
		 $scope.student = {};
		 $scope.courses = [];
		 $scope.profiles = [];
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
     	
	    $scope.viewScetions = function (block) {
	    	console.log("==============progress here===============");
	    	console.log(block);
	     };
   //=============Students ==============//
	    
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
	     
	     $scope.getStudents = function(){
	    	 httpWrapper.get({},'http://localhost:8080/student').then(function(data){
	        	 $scope.students = data.data;
	         }, function (data) {
				 console.log("Error :"+data);
             });
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
	     
	     
	     $scope.getCourses = function(){
             httpWrapper.get({},'http://localhost:8080/course').then(function(data){
	        	 $scope.courses = data.data;
	        	 console.log(data.data);
	         }, function (data) {
				 console.log("Error :"+data);
             });
	     };
	     
	     $scope.getCourses();
	     
   //============= Profiles ==============//
	    $scope.pform = {};
	   
	    $scope.saveProfile = function () {
	    	
	    	httpWrapper.post($scope.pform, 'http://localhost:8080/profile')
	         .then(function (response) {
	        	 $scope.getProfiles();
	        	 $scope.pform = {};
	        	 toastr.success("Success");
	         },function (response) {
	        	 toastr.error("Error");
	         });
	     };
	     
	     
	     $scope.getProfiles = function(){
             httpWrapper.get({},'http://localhost:8080/profile').then(function(data){
	        	 $scope.profiles = data.data;
	        	 console.log(data.data);
	         }, function (data) {
				 console.log("Error :"+data);
             });
	     };
	     
	     $scope.getProfiles();
	     
   //============= Faculties ==============//
	     $scope.getFaculties = function(){
             httpWrapper.get({},'http://localhost:8080/profile').then(function(data){
	        	 $scope.faculties = data.data;
	        	 console.log(data.data);
	         }, function (data) {
				 console.log("Error :"+data);
             });
	     };
	     
	     $scope.getFaculties();
	     
	//============= Save Section ==============//
	     $scope.saveBlockScetion = function (data) {
	    	 data.sections.forEach(function(section){
	    		 httpWrapper.put(section, 'http://localhost:8080/section')
		         .then(function (response) {
		        	 $scope.getBlocks();
		        	 toastr.success("Success");
		         },function (response) {
		        	 toastr.error("Error");
		         });
	    	 });
	    	 
	     };
	//============= Generate Schedule ==============//
	     $scope.generateSchedule = function (blocks) {
	    	 blocks.forEach(function(block){
	    		 $scope.saveBlockScetion(block);
	    	 })
	     };
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
		    }).when("/schedule", {
		            templateUrl: "schedule.html"
		    });
	});