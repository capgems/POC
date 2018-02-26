app.controller("LoginController", function loginController($scope){
	
	$scope.flip = function(flip) {
		 $('#cube').removeClass(); 
		 $('#cube').addClass(flip);   
		}


});