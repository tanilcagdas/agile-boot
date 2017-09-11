app.service('UserStoryService', function($http) {

	
	

	

	this.listAll = function(accessToken, iterations) {

		var req = {
			method : 'GET',
			url : baseUrl + path + '/webresources/userstory/list',
			headers : headers,
			data : {
				test : 'test'
			}
		}

		return $http(req);

	};

	var saveReq = {
		method : 'POST',
		url : baseUrl + path + '/webresources/userstory/save',
		headers : headers,
		data : {
			test : 'test'
		}
	}

	this.save = function(item) {

		saveReq.data = item;
		$http(saveReq).then(function(response) {
			// $scope.userstories = response.data;
			console.log(this.userstories)
			try {
				this.userstories.find(this.item);
			} catch (e) {
				console.log('couldnt find');
			}

		}, function errorCallback(response) {
			alert(response.status + " : " + response.statusText);
		});
	};



});
