app.service('employeeService', function($http) {
	
	var host = 'http://companymanagement.com.br';
	var endpoint = '/ed/user';
	
	this.getUsers = function() {
		
		return new Promise((resolve, reject) => {
			$http({
				method : 'GET',
				url : host+endpoint
			}).then(function successCallback(response) {
				resolve(response.data);
			}, function errorCallback(response) {
				console.log(response);
				reject();
			});
		});
	}
	
	this.saveUser = function(user) {
		
		console.log(user);
		
		return new Promise((resolve, reject) => {
			$http.post(host+endpoint, user)
			.then(function successCallback(response) {
				resolve(response.data);
			}, function errorCallback(response) {
				console.log(response);
				reject();
			});
		});
	}
	
	this.editUser = function(id, attr, newValue) {
		
		return new Promise((resolve, reject) => {
			$http({
				method : 'PUT',
				data: '[{ "op": "replace", "path": "/'+attr+'", "value": "'+newValue+'" }]',
				url : host+endpoint+'/'+id
			}).then(function successCallback(response) {
				resolve(response.data);
			}, function errorCallback(response) {
				console.log(response);
				reject();
			});
		});
	}
	
	this.deleteUser = function(id) {
		
		return new Promise((resolve, reject) => {
			$http({
				method : 'DELETE',
				url : host+endpoint+'/'+id
			}).then(function successCallback(response) {
				resolve(response.data);
			}, function errorCallback(response) {
				console.log(response);
				reject();
			});
		});
	}
});