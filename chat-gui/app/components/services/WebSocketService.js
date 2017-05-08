'use strict';

mostPopularListingsApp.service('WebSocketService', function ($http, $window, $location, $timeout, $websocket, SessionService) {

	var ws;

	this.startConnection = function() {

		// Open a WebSocket connection
		ws = $websocket("ws://localhost:8080/api-war-1.0/webSocketServer");

		ws.onOpen(function () {
			console.log('connection open, sending sessionid');
			// para ler resposta da 1a mensagem (envio do sessionid)
			ws.onMessage(function(message) {
				console.log("received protocol Message: " + message.data);
				if (message.data == 'OK') {
					// remover callback atual e inserir o de leitura de mensagens de usuário
					ws.onMessageCallbacks.length = 0;
					ws.onMessage(function(message){
						console.log("received user Message: " + message.data);
						alert("Recebida nova mensagem: " + message.data);
					});
				} else {
					throw message.data;
				}
			});
			// envia sessionid
			ws.send(SessionService.state().sessionid);
		});

		/*ws.onMessage(function(message) {
			console.log("dataStream Message: " + message);
			alert("Recebida nova mensagem: " + message);
		});*/
	};
});
