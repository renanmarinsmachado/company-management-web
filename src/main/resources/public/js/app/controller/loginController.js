
var app = angular.module('companyManagement', []);
app.controller('loginController', function($scope, $http, $window) {
    
	var login = function() {
		$http.post("http://localhost:8080/login")
		    .then(function(response) {
		    	$window.location.href = '/index.html';
		    });
    };
    angular.element('.btn-login').bind('click', login);
	
});