'use strict';
 
angular.module('Application').factory('DBService', ['$http', '$q','$cookie', function($http, $q){
 
  
    var factory = {
        getToken:getToken,
        getAllData:getAllData,
        checkForCookie:checkForCookie
    }
 
    return factory;
    function createUser(user) {
        var deferred = $q.defer();
        $http.post(Urls.AUTH_TOKEN_URL, user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
  


}]);