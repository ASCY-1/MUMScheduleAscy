var app = angular.module("mumSched", ["ngRoute","ngCookies"]);

app.controller("mainController", ['$scope','$http','$cookieStore', 'httpWrapper', '$window', myFunc]);
//=============Controller Loaders==============//
	function myFunc($scope, $http, $cookieStore, httpWrapper, $window) {
		 $scope.courses = {};
		 $scope.roles = ["ADMIN", "FACULTY", "STUDENT"];
		 $scope.faculties = [];
		 $scope.blocks = [];
		 $scope.sections = [];
		 $scope.enrolled = [];
		 $scope.courses = [];
		 $scope.profiles = [];
		 
	//=============Blocks ==============//
	     $scope.getBlocks = function(){
             httpWrapper.get({},'http://localhost:8080/block').then(function(data){
	        	 $scope.blocks = data.data;
	         }, function (data) {
				 console.log("Error :"+data);
             });
	     };
	     $scope.getBlocks();

   //=============Enrollments ==============//
	     $scope.getEnrollments = function(){
	    	 httpWrapper.get({},'http://localhost:8080/enrollments').then(function(data){
	        	 $scope.enrolled = data.data.enrolledSections;
	         }, function (data) {
				 console.log("Error :"+data);
             });
	     };
	     $scope.getEnrollments();
    
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
	         }, function (data) {
				 console.log("Error :"+data);
             });
	     };
	     
	     $scope.getProfiles();
	     
   //============= Faculties ==============//
	     $scope.getFaculties = function(){
             httpWrapper.get({},'http://localhost:8080/faculty').then(function(data){
             	console.log("faculty called");
             	$scope.faculties  = data.data;
	         }, function (data) {
				 console.log("Error :"+data);
             });
	     };
	     
	     $scope.getFaculties();
	     
	//============= Save Section Enrollment ==============//
	     $scope.saveSectionEnrollment = function (data) {
	    	 var schedule_array = [];
	    	 data.sections.forEach(function(section){
	    		 if(section.selected == "selection"){
	    			 schedule_array.push(section);
	    		 }
	    	 });
	    	 
	     };
	//============= Save Enrollment ==============//
	     $scope.saveEnrollment = function (blocks) {
	    	 var schedule_array = [];
	    	 blocks.forEach(function(block){
		    	 block.sections.forEach(function(section){
		    		 if(section.selected == "selection"){
		    			 schedule_array.push(section);
		    		 }
		    	 });
	    	 })
	    	 httpWrapper.post(schedule_array, 'http://localhost:8080/enroll')
	         .then(function (response) {
	        	 toastr.success("Success");
	        	 $scope.getEnrollments();
	         },function (response) {
	        	 toastr.error("Error");
	         });
	     };
	//============= Logout ==============//
	     $scope.logout = function () {
	    	 console.log("---------logout-----------");
	    	 $window.location.href = '/';
	     };
	}


//=============All Routes==============//
	app.config(function ($routeProvider) {
	    $routeProvider
	        .when("/", {
	            templateUrl: "student_blocks.html"
	        }).when("/student", {
	            templateUrl: "students-sec.html"
	        }).when("/blocks", {
	        	templateUrl: "blocks.html"
		    }).when("/courses", {
		        templateUrl: "courses.html"
		    }).when("/faculty", {
		            templateUrl: "/facultyTemplates/facultyAll.html"
		    }).when("/profile", {
		            templateUrl: "profiles.html"
		    }).when("/schedule", {
		            templateUrl: "schedule.html"
		    });
	});