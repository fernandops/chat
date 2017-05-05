package fps.chat.service;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fps.chat.domain.Message;
import fps.chat.domain.User;

public class DataBaseInitializer {

	private EntityManager em;

	public DataBaseInitializer(EntityManagerFactory entityManagerFactory) {
		this.em = entityManagerFactory.createEntityManager();
	}

	public void populate() {
		em.getTransaction().begin();
		try {
			_populate();
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
	private void _populate() {
		User joao = createUser("joao", "123", "João da Silva", "joao@silva.com");
		User maria = createUser("maria", "123", "Maria Maria", "maria@maria.com");
		User jose = createUser("jose", "123", "José Simão", "jose@simao.com");
		User q = createUser("q", "q", "q", "q@q.com");
		
		Message m = new Message();
		m.setSender(maria);
		m.setRecipient(joao);
		m.setDate(new Date());
		m.setContent("Oi João! ass: Maria");
		m.setStatus("pending");
		em.persist(m);
		
		joao.getContactsForward().add(maria);
		maria.getContactsForward().add(joao);
		maria.getContactsForward().add(jose);
		q.getContactsForward().add(jose);
		q.getContactsForward().add(maria);
		q.getContactsForward().add(joao);
	}

	private User createUser(String userid, String password, String name, String email) {
		User u = new User();
		u.setUserid(userid);
		u.setPassword(password);
		u.setName(name);
		u.setEmail(email);
		em.persist(u);
		return u;
	}

}
