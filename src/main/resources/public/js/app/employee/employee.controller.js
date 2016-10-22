
app.controller('employeeController', function($scope, $window, employeeService) {
	
	$scope.users = [];
	
	var loadUsers = function(){
		employeeService.getUsers().then((data) => {
			$scope.$apply(function () {
				$scope.users = data;
			});
		});
	}
	
	loadUsers();
});