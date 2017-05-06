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
.controller('ContatosController', function($scope, $rootScope, $http, $timeout, StateService) {

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
			
			$scope.contacts = StateService.contacts;
			$scope.selectedContact = StateService.selectedContact;
			
			$scope.selectContact = function (_c) {
				$scope.selectedContact = _c;
				StateService.selectedContact = _c;
				console.log('Selecionado contato "' + _c.userid + '"');
			}
			
			$scope.$on('loginEvent', function (event, data) {
				console.log("[1] Recebido evento de Login realizado com sucesso! Carregando contatos...");
				$timeout(function() {
					console.log("[2] Recebido evento de Login realizado com sucesso! Carregando contatos...");
					carregarContatos();
					//$scope.$apply();
				});
			});
			$rootScope.$on('loginEvent', function (event, data) {
				console.log("[1] Recebido evento de Login realizado com sucesso! Carregando contatos...");
				$timeout(function() {
					console.log("[2] Recebido evento de Login realizado com sucesso! Carregando contatos...");
					carregarContatos();
					//$scope.$apply();
				});
			});
		}

		function carregarContatos() {
			return $http.get('http://localhost:8080/api-war-1.0/api/contacts?status=ZZZ&useridLike=ZZZ',
					{headers: {"sessionid": sessionStorage.getItem('sessionid')}}
			).then(function(response) {
				responseStatus = response.status;
				console.log(JSON.stringify(response.data));
				contacts = response.data;
				$scope.contacts = contacts;
				StateService.contacts = contacts;
				return $scope.contacts = contacts;
			}, function(errorResponse) {
				responseStatus = errorResponse.status;
				console.log(JSON.stringify(errorResponse));
				contacts = [];
				$scope.contacts = contacts;
				StateService.contacts = contacts;
				return $scope.contacts = contacts;
			});

			//TODO Não foi possível utilizar o gerador rest do Swagger para client javascript, portanto as chamadas estão sendo feitas manualmente.
			/*
			var ChatAppApi = require('chat_app_api');
			var apiInstance = new MensagensApi();

			var sessionid = new ChatAppApi.SessionIdRequest(); // SessionIdRequest | 

			var opts = { 
			  'status': "status_example", // String | Filtra pelo status do contato. Valores válidos são: Online / Offline
			  'useridLike': "useridLike_example" // String | Filtra pela substring do userid do contato.
			};

			var callback = function(error, data, response) {
			  if (error) {
			    console.error(error);
			  } else {
			    console.log('API called successfully. Returned data: ' + data);
			  }
			};
			apiInstance.listContacts(sessionid, opts, callback);*/
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

		this.message = "Login Time!";
		
		// // Adding small delay for IP address to be populated before loading the view
		var filterTextTimeout = $timeout(function() {
			loadUserIp();
        }, 500); // delay 500 ms		
});