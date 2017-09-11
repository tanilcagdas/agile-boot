app.controller('loginCtrl', function($location, $scope, LoginService) {

	
	$scope.login = function(item) {

	LoginService.login(function(response) {
		access_token = response.access_token;
		headers = {
        "Authorization": 'bearer'+access_token
      };
		console.log(access_token);
		$location.path('/userstory');

	}, function errorCallback(response) {
		alert(response.status + " : " + response.statusText);
	});

};

});