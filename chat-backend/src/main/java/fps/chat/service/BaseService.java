package fps.chat.service;

import javax.persistence.EntityManager;

import fps.chat.domain.Session;
import fps.chat.domain.User;

public class BaseService {

	protected Session requireSession(EntityManager em, String sessionid) {
		Session session = em.createQuery("select s from Session s where s.sessionid = :sessionid", Session.class)
				.setParameter("sessionid", sessionid).getSingleResult();
		return session;
	}

	protected User requireUser(EntityManager em, String userid) {
		User session = em.createQuery("select u from User u where u.userid = :userid", User.class)
				.setParameter("userid", userid).getSingleResult();
		return session;
	}
}
