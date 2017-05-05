var vvvvv; // http://localhost:8080/chat-gui-1.0/api/session/login

var listarContatos = function() {
	var settings = {
	  "async": true,
	  "crossDomain": true,
	  "url": "http://localhost:8080/chat-gui-1.0/api/contacts?status=Online&useridLike=",
	  "method": "GET",
	  "headers": {
	    "accept": "application/json",
	    "sessionid": "SID=q_q",
	    "cache-control": "no-cache",
	    "postman-token": "2e4f6299-f6f6-1ab0-9dc8-461df8087480"
	  }
	}

	$.ajax(settings).done(function (response) {
	  console.log(response);
	});
}
