var app = angular.module("companyManagement", ["ngRoute", "datatables"]);

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

app.config(['$httpProvider', function ($httpProvider) {
	  //Reset headers to avoid OPTIONS request (aka preflight)
	  $httpProvider.defaults.headers.common = {};
	  $httpProvider.defaults.headers.post['Content-Type'] = 'application/json';
	  $httpProvider.defaults.headers.put = {};
	  $httpProvider.defaults.headers.patch = {};
	  delete $httpProvider.defaults.headers.common['X-Requested-With'];
}]);