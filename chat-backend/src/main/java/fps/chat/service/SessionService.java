package fps.chat.service;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fps.chat.domain.Session;
import fps.chat.domain.User;

public class SessionService {

	private EntityManagerFactory emFactory;

	public SessionService(EntityManagerFactory emFactory) {
		this.emFactory = emFactory;
	}

	
	public Session createSession(User user) {
		EntityManager em = emFactory.createEntityManager();

		String sessionid = generateSessionId(user);
		Date now = new Date();
		Session session = null;
		
		em.getTransaction().begin();
		try {
			session = new Session();
			session.setUser(user);
			session.setSessionid(sessionid);
			session.setCreatedDate(now);
			session.setLastAccess(now);
			em.persist(session);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return session;
	}


	private String generateSessionId(User user) {
		//TODO melhorar formato
		return "SID=" + user.getUserid() + "_" + user.getPassword();
	}
}
