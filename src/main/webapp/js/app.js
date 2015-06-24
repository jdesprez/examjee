var app = angular.module("geektic", [ 'ngRoute' ]);

app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/hello', {
		templateUrl : 'hello.html',
		controller : 'HelloCtrl'
	}).when('/geeks', {
		templateUrl : 'geeks.html',
		controller : 'GeeksCtrl'
	}).when('/geeks/:geekid', {
		templateUrl : 'geekdetails.html',
		controller : 'GeekCtrl'
	}).otherwise({
		redirectTo : '/hello'
	});
} ]);

app.controller('HelloCtrl', function($scope, $http) {
	$http.get('/api/hello').success(function(helloMessage) {
		$scope.helloMessage = helloMessage;
	});
});

// var geek = angular.module('geeklist', [ 'ngRoute' ]);

app.controller('GeeksCtrl', function($scope, $http) {
	$http.get('/api/listgeeks').success(function(listGeeksDisplay) {
		$scope.geeks = listGeeksDisplay
	})
});

app.controller('GeekCtrl', [
		'$scope',
		'$routeParams',
		'$http',
		function($scope, $routeParams, $http) {
			$http.get('api/geek/' + $routeParams.geekid).success(
					function(listGeeksDisplay) {
						$scope.geek = listGeeksDisplay
					})
		} ]);

//app.controller('GeekCtrl',[ '$scope', '$routeParams', '$http',
//function($scope, $routeParams, $http) {
//$scope.geekid = $routeParams.geekid
//
//$http.get('api/listci').success(function(listGeeksDisplay) {
//$scope.centreinterets = listGeeksDisplay
//})
//					
//}
//]);