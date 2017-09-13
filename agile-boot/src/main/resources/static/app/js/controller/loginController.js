app.controller('loginCtrl', function($location, $scope, LoginService) {

	$scope.username = "";
	$scope.password = "" ;
	$scope.login = function(item) {

		user = {
				"name":$scope.username,
				"password" : $scope.password
		}
	LoginService.login(user, function(response) {
		access_token = response.access_token;
		headers = {
        "Authorization": 'bearer'+access_token
      };
		console.log(access_token);
		username = $scope.username;
		$location.path('/userstory');

	}, function errorCallback(response) {
		alert(response.status + " : " + response.statusText);
	});

};

});