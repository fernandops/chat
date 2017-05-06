package fps.chat.service;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fps.chat.domain.Message;
import fps.chat.domain.Session;
import fps.chat.domain.User;

public class MessageService extends BaseService {

	private EntityManagerFactory emFactory;

	public MessageService(EntityManagerFactory emFactory) {
		this.emFactory = emFactory;
	}

	
	public Message sendMessage(String recipientId, String content, String sessionid) {
		EntityManager em = emFactory.createEntityManager();

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
			//TODO ENTREGAR IMEDIATAMENTE SE O DESTINATARIO ESTIVER ONLINE!
			message.setStatus("STATUS?!");
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
}
