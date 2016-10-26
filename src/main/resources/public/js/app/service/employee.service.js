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
	
	this.getUser = function(id) {
		
		return new Promise((resolve, reject) => {
			$http({
				method : 'GET',
				url : host+endpoint+'/'+id
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
	
	this.editUser = function(id, map) {
		
		return new Promise((resolve, reject) => {
			
			var json = '[';
			map.forEach(function(item, index){
				json += '{ "op": "add", "path": "/'+item.attr+'", "value": "'+item.value+'" }';
				
				if(map[(map.length-1)].attr != map[index].attr)
					json += ',';
			});
			
			json += ']';
			
			console.log(json);
			
			$http({
				method : 'PUT',
				data: json,
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