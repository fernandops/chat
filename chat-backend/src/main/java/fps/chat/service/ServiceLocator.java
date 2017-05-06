package fps.chat.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ServiceLocator {

	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManagerFactory getEMFactory() {
		if (entityManagerFactory == null) {
			synchronized (ServiceLocator.class) {
				entityManagerFactory = Persistence.createEntityManagerFactory("MyJPAJAXRS");
				new DataBaseInitializer(entityManagerFactory).populate();
			}
		}
		return entityManagerFactory;
	}

	public static EntityManager createEntityManager() {
		return getEMFactory().createEntityManager();
	}

	public static ContactService getContactService() {
		return new ContactService(getEMFactory());
	}
	public static UserService getUserService() {
		return new UserService(getEMFactory());
	}
	public static SessionService getSessionService() {
		return new SessionService(getEMFactory());
	}
	public static MessageService getMessageService() {
		return new MessageService(getEMFactory());
	}
}
