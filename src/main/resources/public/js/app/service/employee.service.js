app.service('employeeService', function($http) {
	
	this.getUsers = function() {
		
		return new Promise((resolve, reject) => {
			$http({
				method : 'GET',
				url : 'http://localhost:8082/ed/user'
			}).then(function successCallback(response) {
				resolve(response.data);
			}, function errorCallback(response) {
				console.log(response);
				reject();
			});
		});
	}
});