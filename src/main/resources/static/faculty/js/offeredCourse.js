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

        $scope.getCourses = function(){
            httpWrapper.get({},'http://localhost:8080/course').then(function(data){
                $scope.courses = data.data;
                console.log($scope.courses);
            }, function (data) {
                console.log("Error :"+data);
            });
        };
        $scope.getOfferedCourses = function(){
            httpWrapper.get({},'http://localhost:8080/faculty/getOffered').then(function(data){
                $scope.offeredCourses = data.data;
                console.log($scope.courses);
            }, function (data) {
                console.log("Error :"+data);
            });
        };
        $scope.getCourses();
        $scope.getOfferedCourses();
        $scope.saveOffer = function(){
            httpWrapper.post($scope.addedCourse,'/faculty/addOffer').then(
                function (response) {
                    console.log("real recognize real");
                },
                function (response) {
                    console.log("Bullshit");
                }
            );
        };




        $scope.addedCourse = [];
        $scope.courseSelected = function (course,$event) {
            if($event.currentTarget.checked){
                $scope.addedCourse.push(course);
            }
            else{
               for(var x=0;x<$scope.addedCourse.length;x++){
                   if($scope.addedCourse[x].id== course.id) {
                       $scope.addedCourse.splice(x, 1);
                       break;
                   }
               }
            }
        };
        }]);