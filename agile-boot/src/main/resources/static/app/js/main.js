var baseUrl = window.location.origin;
var path = window.location.pathname.substring(0, window.location.pathname
		.indexOf("/", 2));

//baseUrl = "http://localhost:8080";
path =    "";
var access_token = "";
var headers = {};
var username = "";


/**
 * Main AngularJS Web Application
 */
var app = angular.module('webApp', [
  'ngRoute'  ,
  'ngAnimate',
  'ui.bootstrap'
  
]);

/**
 * Configure the Routes
 */
app.config(['$routeProvider','$httpProvider', function ($routeProvider, $httpProvider) {
  $routeProvider
    // Home
    .when("/", {templateUrl: "partials/login.html", controller: "loginCtrl"})
    // Pages
    .when("/iteration", {templateUrl: "partials/iteration.html", controller: "iterationCtrl"})
    .when("/userstory", {templateUrl: "partials/userstory.html", controller: "userstoryCtrl"})
    .when("/users", {templateUrl: "partials/users.html", controller: "userCtrl"})
 
    // Blog

    // else 404
    .otherwise("/404", {templateUrl: "partials/404.html", controller: "PageCtrl"});
  
  $httpProvider.interceptors.push('myHttpInterceptor');
}]);

/**
app.config(function($modalProvider) {
	  angular.extend($modalProvider.defaults, {
	    html: true
	  });
	})
/**
 * Controls the Blog
 */
app.controller('BlogCtrl', function (/* $scope, $location, $http */) {
  console.log("Blog Controller reporting for duty.");
});

/**
 * Controls all other Pages
 */
app.controller('PageCtrl', function (/* $scope, $location, $http */) {
  console.log("Page Controller reporting for duty.");

  // Activates the Carousel
//  $('.carousel').carousel({
//    interval: 5000
//  });

  // Activates Tooltips for Social Links
//  $('.tooltip-social').tooltip({
//    selector: "a[data-toggle=tooltip]"
//  })
});


//register the interceptor as a service
//app.factory('myHttpInterceptor', function($q, dependency1, dependency2) {
app.factory('myHttpInterceptor', function($q) {
  return {
    // optional method
    'request': function(config) {
      // do something on success
      return config;
    },

    // optional method
   'requestError': function(rejection) {
      // do something on error
      if (canRecover(rejection)) {
        return responseOrNewPromise
      }
      return $q.reject(rejection);
    },



    // optional method
    'response': function(response) {
      // do something on success
      return response;
    },

    // optional method
   'responseError': function(rejection) {
      // do something on error
      if (canRecover(rejection)) {
        return responseOrNewPromise
      }
      return $q.reject(rejection);
    }
  };
});

//$httpProvider.interceptors.push('myHttpInterceptor');
//
//
//// alternatively, register the interceptor via an anonymous factory
//$httpProvider.interceptors.push(function($q, dependency1, dependency2) {
//  return {
//   'request': function(config) {
//       // same as above
//    },
//
//    'response': function(response) {
//       // same as above
//    }
//  };
//});




