
app.controller('employeeController', function($scope, $window, employeeService) {
	
	$scope.users = [];
	
	$scope.saveUser = function(){
		var user = convertUser($scope.model);
		employeeService.saveUser(user).then((data) => {
			console.log(data);
			loadUsers();
		});
	}
	
	var loadUsers = function(){
		employeeService.getUsers().then((data) => {
			$scope.$apply(function () {
				$scope.users = data;
				cleanUser();
			});
		});
	}
	
	var cleanUser = function(){
		$scope.model = {
				'name':'',
				'cpf':'',
				'username':'',
				'password':'',
				'role':'',
				'birthdate':'',
				'salary':'',
		}
	}
	
	var convertUser = function(user){
		
		var date = new Date(user.birthdate);
		var formattedDate = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate()+'T00:00:00';
		
		return {
				'name':user.name,
				'cpf':user.cpf,
				'username':user.username,
				'password':user.password,
				'role':user.role,
				'birthdate':formattedDate,
				'salary':user.salary,
		}
	}
	
	loadUsers();
});