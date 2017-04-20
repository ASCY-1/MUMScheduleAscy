angular.module("mumSched")
.factory('httpWrapper',["$http","$rootScope",function($http,$rootScope){        
    var getRequest = function(data1,url1){
        return $http({
            method: 'GET',
            url: url1,
            headers: {
                'Content-Type': "Application/json",
                'Authorization': "Bearer "+$rootScope.token
            },
            data: data1
        });
    };
    var postRequest = function(data1,url1){
        return $http({
            method: 'POST',
            url: url1,
            headers: {
                'Content-Type': "Application/json",
                'Authorization': "Bearer "+$rootScope.token
            },
            data: data1
        });
    };
    var putRequest = function(data1,url1){
        return $http({
            method: 'PUT',
            url: url1,
            headers: {
                'Content-Type': "Application/json",
                'Authorization': "Bearer "+$rootScope.token
            },
            data: data1
        }); 
    };
    var deleteRequest = function(data1,url1){
         return $http({
            method: 'DELETE',
            url: url1,
            headers: {
                'Content-Type': "Application/json",
                'Authorization': "Bearer "+$rootScope.token
            },
            data: data1
        });
    };
    
    return {
            get :getRequest,
            post :postRequest,
            put : putRequest,
            delete : deleteRequest
           }
}]);