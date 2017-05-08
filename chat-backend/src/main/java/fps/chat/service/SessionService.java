package fps.chat.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

import fps.chat.domain.Session;
import fps.chat.domain.User;

public class SessionService {

	private static Map<String, javax.websocket.Session> userWebSocketMap = new HashMap<>();
	
	public Map<String, javax.websocket.Session> getUserWebSocketMap() {
		return userWebSocketMap;
	}


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
			int deleteCount = em.createQuery("delete from Session where user = :user").setParameter("user", user).executeUpdate();
			System.out.println("Deleted " + deleteCount + " rows before new login");
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
			throw new RuntimeException(e);
		}
		return session;
	}


	private String generateSessionId(User user) {
		//TODO problema de segurança com este formato do token
		return "SID=" + user.getUserid() + "_" + user.getPassword();
	}


	public Session findBySessionId(String sessionid) {
		EntityManager em = emFactory.createEntityManager();

		try {
			return em.createQuery("select s from Session s where s.sessionid = :sessionid", Session.class)
					.setParameter("sessionid", sessionid).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
