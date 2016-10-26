
app.controller('employeeController', function($scope, $window, $filter, employeeService) {
	
	var vm = $scope;
	$scope.users = [];
	
	$scope.isEdit = false;
	
	vm.saveUser = function(){
		var user = convertUser($scope.model);
		employeeService.saveUser(user).then((data) => {
			console.log(data);
			loadUsers();
		});
	}
	
	vm.detailsUser = function(id){
		employeeService.getUser(id).then((data) => {
			$scope.$apply(function () {
				cleanUser();
				
				$scope.isEdit = true;
				$scope.model = data;
				var date = new Date($scope.model.birthdate);
				$scope.model.birthdate = new Date(date.getFullYear(), date.getMonth(), date.getDate());
				$scope.model.password = '';
			});
		});
		
	}
	
	vm.editUser = function(){
		var map = [];
		
		map.push({attr:'name',value:$scope.model.name});
		map.push({attr:'username',value:$scope.model.username});
		map.push({attr:'salary',value:$scope.model.salary});
		map.push({attr:'role',value:$scope.model.role});
		map.push({attr:'birthdate',value: getDate($scope.model.birthdate)});
		if($scope.model.password && $scope.model.password != ''){
			map.push({attr:'password',value:$scope.model.password});
		}
		
		employeeService.editUser($scope.model.cpf, map).then(() => {
			$scope.$apply(function () {
				cleanUser();
				loadUsers();
			});
		});
	}
	
	vm.cancelEditUser = function(){		
		cleanUser();
	}
	
	vm.deleteUser = function(id){
		
		if(confirm('Deseja realmente deletar?')){
			employeeService.deleteUser(id).then(() => {
				$scope.$apply(function () {
					cleanUser();
					loadUsers();
				});
			});
		}
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
		$scope.isEdit = false;
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
		var formattedDate = getDate(user.birthdate);
		
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
	
	function getDate(date){
		var date = new Date(date);
		return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate()+'T00:00:00';
	}
	
	loadUsers();
});