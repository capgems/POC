var app = angular.module("Application",["ngRoute"]);


app.config(['$routeProvider',function($routeProvider){
	
	$routeProvider
    
    .when("/org", {
        templateUrl : "./static/app/modules/org/org.html",
 	
    })
     .when("/login", {
        templateUrl : "./static/app/modules/login/login.html",
 	
    })
    
    
    .otherwise({
    	redirectTo:"/"
    })
   
	
	
}]);

app.config(['$httpProvider', function($httpProvider) {
    $httpProvider.interceptors.push('AuthInterceptor');
  }]);
app.controller("ApplicationController", function($scope){
	
	$scope.signOff = function(){
		
		$('#signoff').submit();
	}
	
	
	
});
app.run(function($rootScope, $location, $timeout) {
    $rootScope.$on('$viewContentLoaded', function() {
        $timeout(function() {
            componentHandler.upgradeAllRegistered();
        });
    });
});