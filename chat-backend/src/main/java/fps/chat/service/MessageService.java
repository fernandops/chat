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
			boolean isRecipientOnline = false;
			if (isRecipientOnline) {
				//TODO ENTREGAR IMEDIATAMENTE SE O DESTINATARIO ESTIVER ONLINE!
				message.setStatus("read");
			}
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
