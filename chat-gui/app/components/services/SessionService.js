'use strict';

mostPopularListingsApp.service('SessionService', function ($http, $window, $location, $timeout) {

	var sessionState = {};

	this.state = function() { return sessionState; }
	
	this.login = function(userid, password, afterLoginCallback) {

		if (sessionState.processing) {
			throw "Aguardando login em andamento!";
		}

		sessionState.processing = true;
		
		var body = {"user": userid, "password": password};

		return $http.post('http://localhost:8080/api-war-1.0/api/session/login', body).then(function(response) {
	    	var sessionid = response.data;
	    	console.log(sessionid);
	    	//console.log(JSON.stringify(response.data));

	    	sessionState.sessionid = sessionid;
	    	sessionState.userid = userid;
	    	sessionState.processing = false;
			sessionStorage.setItem('sessionid', sessionid);

			console.log("Login realizado com sucesso: userid: '" + sessionState.userid + "'; sessionid: '" + sessionState.sessionid + "'");

			//console.log("Emitindo evento 'loginEvent'...");
			//$scope.$emit('loginEventEmit', 'logged');
			//$scope.$broadcast('loginEvent', 'logged');
			//$rootScope.$broadcast('loginEvent', 'logged');
			
			//$rootScope.sessionid = sessionid;
			
			if (afterLoginCallback != null) {
				console.log('Running login callback...');
				$timeout(function() {
					afterLoginCallback();
				}, 10);
			}
			
			// assigning sessionid to scope
	    	//return $scope.sessionid = sessionid;

		}, function(errorResponse) {
	    	console.log(JSON.stringify(errorResponse));

	    	sessionState.sessionid = null;
	    	sessionState.userid = null;
	    	sessionState = {};
			sessionStorage.removeItem('sessionid');
			//delete $rootScope.sessionid;

			// clearing sessionid
	    	//return $scope.sessionid = '';
		});
	}

	this.logout = function() {
		if (sessionState.processing) {
			throw "Aguardando login em andamento!";
		}
		// Logout front-end
		sessionStorage.removeItem('sessionid');
		delete $rootScope.sessionid;
		//TODO Criar serviço para logout no servidor
	}

	this.isLogged = function() {
		return (sessionState.userid != null);
	}
});
