package fps.chat.websockets;

import java.io.IOException;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import fps.chat.service.ServiceLocator;
 
/** 
 * @ServerEndpoint gives the relative name for the end point
 * This will be accessed via ws://localhost:8080/EchoChamber/echo
 * Where "localhost" is the address of the host,
 * "EchoChamber" is the name of the package
 * and "echo" is the address to access this class from the server
 */
@ServerEndpoint(value = "/webSocketServer", encoders = MyEncoder.class)
public class WebSocketServer {
	
	Map<String, Session> getUserWebSocketMap() {
		return ServiceLocator.getSessionService().getUserWebSocketMap();
	}
    /**
     * @OnOpen allows us to intercept the creation of a new session.
     * The session class allows us to send data to the user.
     * In the method onOpen, we'll let the user know that the handshake was 
     * successful.
     */
    @OnOpen
    public void onOpen(Session session){
        System.out.println(session.getId() + " has opened a connection"); 
        session.getUserProperties().put("state", "waiting sessionid");
    }
 
    /**
     * When a user sends a message to the server, this method will intercept the message
     * and allow us to react to it. For now the message is read as a String.
     */
    @OnMessage
    public void onMessage(String message, Session session){
		try {
			_onMessage(message, session);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
    }
    private void _onMessage(String message, Session session) throws IOException{
    	if ("waiting sessionid".equals(session.getUserProperties().get("state"))) {
    		fps.chat.domain.Session s = ServiceLocator.getSessionService().findBySessionId(message);
    		if (s == null) {
    			session.getBasicRemote().sendText("sessionid informado não encontrado");
    		} else {
//    			session.getUserProperties().put("sessionid", s.getSessionid());
    			session.getUserProperties().put("userid", s.getUser().getUserid());
//    			session.getUserProperties().put("state", "connected");
    			getUserWebSocketMap().put(s.getUser().getUserid(), session);
    			session.getBasicRemote().sendText("OK");
    		}
    	} else {
    		throw new IllegalStateException();
    	}
    }
 
    /**
     * The user closes the connection.
     * 
     * Note: you can't send messages to the client from this method
     */
    @OnClose
    public void onClose(Session session){
		String userid = (String) session.getUserProperties().get("userid");
		if (userid != null) {
			Session wsSession = getUserWebSocketMap().get(userid);
			if (wsSession != null && !wsSession.getId().equals(session.getId())) {
				System.out.println("[WARN] wsSessionId do map '" +wsSession.getId()+"' é diferente da sessão atual '" + session.getId() + "'");
			}
			getUserWebSocketMap().remove(userid);
		}
        System.out.println("Session " +session.getId()+" has ended");
    }
}