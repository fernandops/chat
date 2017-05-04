package fps.chat.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ContactService {

	private EntityManagerFactory emFactory;

	public ContactService(EntityManagerFactory emFactory) {
		this.emFactory = emFactory;
	}

	public int listContacts(String sessionid, String status, String useridLike) {
		EntityManager em = emFactory.createEntityManager();
//		em.createQuery(qlString);
		// TODO Auto-generated method stub
		return 0;
	}

}
