'use strict';

mostPopularListingsApp.service('ApiService', function (SessionService, $http) {

	var _pendingMessages = null;
	var _contacts = null;

	this.pendingMessages = function () { return _pendingMessages; };
	this.contacts = function () { return _contacts; };

	this.carregarMensagensPendentes = function () {
		var body = {"sessionid": SessionService.state().sessionid};
		return $http.post('http://localhost:8080/api-war-1.0/api/message/retrievePendingMessages', body,
				{headers: {"sessionid": sessionStorage.getItem('sessionid')}}
		).then(function(response) {
			console.log('[carregarMensagensPendentes]: ' + JSON.stringify(response.data));
			_pendingMessages = response.data;
		}, function(errorResponse) {
			console.log(JSON.stringify(errorResponse));
			_pendingMessages = null;
		});
	};

	this.carregarContatos = function () {
		return $http.get('http://localhost:8080/api-war-1.0/api/contacts?status=ZZZ&useridLike=ZZZ',
				{headers: {"sessionid": sessionStorage.getItem('sessionid')}}
		).then(function(response) {
			console.log('[carregarContatos]: ' + JSON.stringify(response.data));
			_contacts = response.data;
		}, function(errorResponse) {
			console.log(JSON.stringify(errorResponse));
			_contacts = [];
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
	};


	this.submitRegisterUser = function (userid, password, name, email) {
		var body = {
		  "userid": userid,
		  "password": password,
		  "name": name,
		  "email": email
		};
		return $http.post('http://localhost:8080/api-war-1.0/api/user', body
		).then(function(response) {
			console.log('[submitRegisterUser]: ' + JSON.stringify(response.data));
			alert('Usuário cadastrado com sucesso!');
		}, function(errorResponse) {
			console.log('[submitRegisterUser]: ' + JSON.stringify(errorResponse));
			alert('Erro ao cadastrar usuário: ' + errorResponse);
		});
	};

});
