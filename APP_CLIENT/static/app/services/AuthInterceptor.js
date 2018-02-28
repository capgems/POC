angular.module('Application')
.factory('AuthInterceptor', [function() {  
    return {
    // Send the Authorization header with each request
        'request': function(config) {
            config.headers = config.headers || {};
            var encodedString = btoa($rootScope.user+':'+$rootScope.password);
            config.headers.Authorization = 'Basic '+encodedString;
           return config;
        }
    };
}]);