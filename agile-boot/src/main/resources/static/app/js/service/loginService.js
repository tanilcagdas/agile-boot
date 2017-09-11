app.service('LoginService', function($http) {


	this.login = function(callback, errorCallback) {
		var LOGIN_URL = "http://localhost:8080/oauth/token";

		var postData = {
			grant_type: "password",
			client_id: "restapp",
			client_secret: "restapp",
			username: "admin",
			password: "password"
		};

		$http.post(LOGIN_URL, postData, {
			headers: {
				"Access-Control-Allow-Origin": "*",
				'Access-Control-Allow-Credentials': true,
				"Authorization": "Basic " + btoa("restapp" + ":" + "restapp"),
				'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
			},
			transformRequest: function(obj) {
				var str = [];
				for (var p in obj) {
					str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
				}
				return str.join("&");
			}
		}).then(function(response) {

			callback(response.data);

		}, function(err) {
			errorCallback(err);
		});
	}; 

});
