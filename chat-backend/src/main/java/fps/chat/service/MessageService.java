package fps.chat.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fps.chat.domain.Message;
import fps.chat.domain.Session;
import fps.chat.domain.User;
import fps.chat.domain.vo.MessageVO;

public class MessageService extends BaseService {

	private EntityManagerFactory emFactory;

	public MessageService(EntityManagerFactory emFactory) {
		this.emFactory = emFactory;
	}

	
	public Message sendMessage(String recipientId, String content, String sessionid) {
		EntityManager em = emFactory.createEntityManager();

		Message message = createMessage(em, recipientId, content, sessionid);
		
		javax.websocket.Session wsSession = ServiceLocator.getSessionService().getUserWebSocketMap().get(recipientId);
		if (wsSession != null && wsSession.isOpen()) {
			// Destinatário online. Enviar msg via WebSocket
			try {
				System.out.println("ENVIANDO WEBSOCKET...");
				wsSession.getBasicRemote().sendObject(new MessageVO(message));
				System.out.println("ENVIANDO WEBSOCKET!");
			} catch (Exception e) {
				throw new IllegalStateException("Erro enviando mensagem via WebSocket", e);
			}
			// Em seguida atualizar o status como entregue para evitar que seja entregue novamente durante login
			message.setStatus("read");
			message = em.merge(message);
		}
		return message;
	}
	private Message createMessage(EntityManager em, String recipientId, String content, String sessionid) {
		Session session = requireSession(em, sessionid);
		User sender = session.getUser();
		User recipient = requireUser(em, recipientId);

		Date now = new Date();
		Message message = null;
		
		em.getTransaction().begin();
		try {
			message = new Message();
			message.setSender(sender);
			message.setRecipient(recipient);
			message.setContent(content);
			message.setDate(now);
			message.setStatus("pending");
			em.persist(message);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
		return message;
	}


	public List<MessageVO> retrievePendingMessages(String sessionid) {
		EntityManager em = emFactory.createEntityManager();

		Session session = requireSession(em, sessionid);
		User recipient = session.getUser();

		List<MessageVO> messages = null;
		
		em.getTransaction().begin();
		try {
			messages = em.createQuery("select new fps.chat.domain.vo.MessageVO(m) from Message m where m.recipient = :recipient and m.status = :statusPending", MessageVO.class)
					.setParameter("recipient", recipient)
					.setParameter("statusPending", "pending")
					.getResultList();
			int i = em.createQuery("update Message set status = :newStatus where recipient = :recipient and status = :statusPending")
					.setParameter("recipient", recipient)
					.setParameter("statusPending", "pending")
					.setParameter("newStatus", "read")
					.executeUpdate();

			if (messages.size() != i) {
				throw new IllegalStateException("found and update pending messages are different!");
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
		return messages;
	}
}
