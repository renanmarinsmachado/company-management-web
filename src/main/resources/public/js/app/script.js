var app = angular.module("companyManagement", ["ngRoute"]);
	
app.config(function($routeProvider) {
    $routeProvider
    .when("/home", {
        templateUrl : "/js/app/home/home.view.htm",
        controller : "homeController"
    })
    .when("/", {
    	redirectTo: '/home'
    })
    .when("/employee", {
        templateUrl : "/js/app/employee/employee.view.htm",
        controller : "employeeController"
    });
});