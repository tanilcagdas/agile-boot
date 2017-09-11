app.service('IterationService', function($http) {

	

	this.listAll = function(iterations) {
		var req = {
			method : 'GET',
			url : baseUrl + path + '/webresources/iteration/list',
			headers : headers,
			data : {
				test : 'test'
			}
		}
		return $http(req);
		
	};
	
	

	var saveReq = {
		method : 'POST',
		url : baseUrl + path + '/webresources/iteration/save',
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
