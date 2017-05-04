package fps.chat.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import fps.chat.domain.User;

public class UserService {

	private EntityManagerFactory emFactory;

	public UserService(EntityManagerFactory emFactory) {
		this.emFactory = emFactory;
	}

	public User createUser(String userid, String password, String name, String email) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		User user = null;
		try {
			user = new User();
			user.setUserid(userid);
			user.setPassword(password);
			user.setName(name);
			user.setEmail(email);
			em.persist(user);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return user;
	}

	public User getUser(String userid, char[] password) {
		EntityManager em = emFactory.createEntityManager();
		TypedQuery<User> query = em
				.createQuery("select u from User u where u.userid = :userid and u.password = :password", User.class)
				.setParameter("userid", userid).setParameter("password", new String(password));
		User user = query.getSingleResult();
		return user;
	}
}
