// HomeController.js
// For distribution, all controllers
// are concatanated into single app.js file
// by using Gulp

'use strict';

angular.module('mostPopularListingsApp.login', ['ngRoute', 'ngWebSocket'])

// Routing configuration for this module
.config(['$routeProvider',function($routeprovider){
	$routeprovider.when('/login', {
		controller: 'LoginController',
		templateUrl: 'components/views/loginView.html'
	});
}])

// Controller definition for this module
.controller('LoginController', function($scope, $rootScope, $http, $timeout, $window, $location, SessionService, ApiService, WebSocketService) {

		// Global variables for this controller
		var responseStatus = '';

		//var sessionid = sessionStorage.getItem('sessionid');
		var sessionid = $rootScope.sessionid;

		// Just a housekeeping.
		// In the init method we are declaring all the
		// neccesarry settings and assignments to be run once
		// controller is invoked
		init();

		function init(){};


		$scope.submitLogout = function() {
			SessionService.login();
		}

		$scope.isLogged = function() {
			return SessionService.isLogged();
		}

		$scope.submitLogin = function() {
			var afterLogin = function () {
				ApiService.carregarMensagensPendentes();
				ApiService.carregarContatos();
				
				$location.path('#/contatos');
				
				WebSocketService.startConnection();
			};

			SessionService.login($scope.userid, $scope.password, afterLogin);
		};
		
		this.message = "Login Time!";
});