// HomeController.js
// For distribution, all controllers
// are concatanated into single app.js file
// by using Gulp

'use strict';

angular.module('mostPopularListingsApp.contatos', ['ngRoute'])

// Routing configuration for this module
.config(['$routeProvider',function($routeprovider){
	$routeprovider.when('/contatos', {
		controller: 'ContatosController',
		templateUrl: 'components/views/contatosView.html'
	});
}])

// Controller definition for this module
.controller('ContatosController', function($scope, $rootScope, $http, $timeout, StateService, SessionService, ApiService) {
		// Global variables for this controller
		var responseStatus = '';
		var userIp = 'not yet retrieved';
		var campo = 'not yet retrieved';
		var contacts = [];

		// Just a housekeeping.
		// In the init method we are declaring all the
		// neccesarry settings and assignments to be run once
		// controller is invoked
		init();

		function init(){
			
			$scope.contacts = ApiService.contacts();
			$scope.pendingMessages = ApiService.pendingMessages();

			if (SessionService.isLogged() && ($scope.pendingMessages == null || $scope.contacts == null)) {
				
				$scope.$on('$destroy', function() {
					console.log('destroy: Child1 is no longer necessary');
					$scope.destroyed = true;
				});

				var f = function() {
					console.log('timer process!');
					if ($scope.pendingMessages == null) {
						$scope.pendingMessages = ApiService.pendingMessages;
					}
					if ($scope.contacts == null) {
						$scope.contacts = ApiService.contacts;
					}
					if (SessionService.isLogged() && !$scope.destroyed && ($scope.pendingMessages == null || $scope.contacts == null)) {
						console.log('scheduling timer process... [l]')
						$timeout(f, 1500);
					} else {
						if (!SessionService.isLogged()) {
							console.log('NOT scheduling timer process: user not logged in!');
						} else if ($scope.destroyed) {
							console.log('NOT scheduling timer process: controller was destroyed!');
						} else {
							console.log('NOT scheduling timer process: no more pendings');
						}
					}
				};
				
				console.log('scheduling timer process... [i]')
				$timeout(f, 1500);
			}

			$scope.selectContact = function (_c) {
				$scope.selectedContact = _c;
				StateService.selectedContact = _c;
				console.log('Selecionado contato "' + _c.userid + '"');
			}
			
			$scope.readMessage = function (_m, index) {
				console.log('Reading message "' + _m + '"');
				// show msg
				var msg = '[' + _m.sender + ' às ' + _m.date + ']: ' + _m.content;
				alert(msg);
				// remove from local list
				$scope.pendingMessages.splice(index, 1);
			}
		}

		$scope.isLogged = function() {
			return SessionService.isLogged();
		}

		function carregarMensagensPendentes() {
			$scope.pendingMessages = ApiService.pendingMessages;
		}


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
		    	console.log(JSON.stringify(errorResponse));

		    	// assigning userIp to scope
		    	return $scope.userip = userIp;
		    });

		};

		$scope.submitEnviarMensagem = function() {

			var body = {
			  "recipient": $scope.selectedContact.userid,
			  "content": $scope.content,
			  "sessionid": sessionStorage.getItem('sessionid')
			};

			return $http.post('http://localhost:8080/api-war-1.0/api/message', body,
					{headers: {"sessionid": sessionStorage.getItem('sessionid')}}
			).then(function(response) {
		    	responseStatus = response.status;
		    	console.log(JSON.stringify(response.data));
				console.log("Mensagem enviada!");
			}, function(errorResponse) {
		    	responseStatus = errorResponse.status;
		    	console.log(JSON.stringify(errorResponse));
			});
		};

		this.message = "Login Time!";
		
		// // Adding small delay for IP address to be populated before loading the view
		var filterTextTimeout = $timeout(function() {
			loadUserIp();
        }, 500); // delay 500 ms		
});