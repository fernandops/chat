// HomeController.js
// For distribution, all controllers
// are concatanated into single app.js file
// by using Gulp

'use strict';

angular.module('mostPopularListingsApp.login', ['ngRoute'])

// Routing configuration for this module
.config(['$routeProvider',function($routeprovider){
	$routeprovider.when('/login', {
		controller: 'LoginController',
		templateUrl: 'components/views/loginView.html'
	});
}])

// Controller definition for this module
.controller('LoginController', function($scope, $rootScope, $http, $timeout, $window) {

		// Global variables for this controller
		var responseStatus = '';
		var userIp = 'not yet retrieved';
		var sessionid = sessionStorage.getItem('sessionid');

		// Just a housekeeping.
		// In the init method we are declaring all the
		// neccesarry settings and assignments to be run once
		// controller is invoked
		init();

		function init(){};

		// Get requestors IP address from httpbin.org
		function loadUserIp(){

			// Before serving login page we are doing example http request
			// to web API to verify if login service is up and running.
			// Using httpbin.org as mock in this case - it returns requestors IP address

			return $http.get('http://httpbin.org/ip').
		  		then(function(response) {
		    	// this callback will be called asynchronously
		    	// when the response is available
		    	responseStatus = response.status;
		    	userIp = response.data.origin;
		    	console.log(userIp);
		    	console.log(JSON.stringify(response.data));

		    	// assigning userIp to scope
		    	return $scope.userip = userIp;

		    }, function(errorResponse) {
		    	// called asynchronously if an error occurs
		    	// or server returns response with an error status.
		    	responseStatus = errorResponse.status;
		    	console.log(JSON.stringify(errorresponse));

		    	// assigning userIp to scope
		    	return $scope.userip = userIp;
		    });

		};

		$scope.submitLogout = function() {
			// Logout front-end
			sessionStorage.removeItem('sessionid');
			//TODO Criar serviço para logout no servidor
		}

		$scope.submitLogin = function() {

			var body = {"user": $scope.userid, "password": $scope.password};

			return $http.post('http://localhost:8080/api-war-1.0/api/session/login', body).then(function(response) {
		    	// this callback will be called asynchronously
		    	// when the response is available
		    	responseStatus = response.status;
		    	sessionid = response.data;
		    	console.log(sessionid);
		    	console.log(JSON.stringify(response.data));
	
				sessionStorage.setItem('sessionid', sessionid);

				console.log("Login realizado com sucesso, emitindo evento 'loginEvent'...");
				$scope.$emit('loginEvent', 'logged');
				//$scope.$broadcast('loginEvent', 'logged');
				//$rootScope.$broadcast('loginEvent', 'logged');
				
				// TODO Não redirecionar pois a atualização com a lista de contatos não está carregando corretamente
				//$window.location.href = '#/contatos';
				
				// assigning sessionid to scope
		    	return $scope.sessionid = sessionid;

			}, function(errorResponse) {
		    	// called asynchronously if an error occurs
		    	// or server returns response with an error status.
		    	responseStatus = errorResponse.status;
		    	console.log(JSON.stringify(errorResponse));
	
				sessionStorage.removeItem('sessionid');

				// clearing sessionid
		    	return $scope.sessionid = '';
			});
		};
		
		this.message = "Login Time!";
		
		// // Adding small delay for IP address to be populated before loading the view
		var filterTextTimeout = $timeout(function() {
			loadUserIp();            
        }, 500); // delay 500 ms		
});