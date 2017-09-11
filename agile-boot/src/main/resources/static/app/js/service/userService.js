app.service('UserService', function($http) {

	

	this.listAll = function(users) {

		var req = {
			method : 'GET',
			url : baseUrl + path + '/webresources/user/list',
			headers : headers,
		}

		return $http(req);
		
	};
	
	

	var saveReq = {
		method : 'POST',
		url : baseUrl + path + '/webresources/user/save',
		headers : headers,
		data : {
			test : 'test'
		}
	}

	this.save = function(item) {
		saveReq.data = item;
		return $http(saveReq);
	};

});
