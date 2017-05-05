package fps.chat.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fps.chat.domain.Session;
import fps.chat.domain.vo.ContactVO;

public class ContactService {

	private EntityManagerFactory emFactory;

	public ContactService(EntityManagerFactory emFactory) {
		this.emFactory = emFactory;
	}

	public List<ContactVO> listContacts(String sessionid, String status, String useridLike) {
		EntityManager em = emFactory.createEntityManager();

		Session session = em.createQuery("select s from Session s where s.sessionid = :sessionid", Session.class)
				.setParameter("sessionid", sessionid).getSingleResult();
		
		List<ContactVO> contactsForward = em.createQuery("select new fps.chat.domain.vo.ContactVO(cf.userid, cf.name, 'OFFLINE') from User u join u.contactsForward cf", ContactVO.class).getResultList();
		List<ContactVO> contactsReverse = em.createQuery("select new fps.chat.domain.vo.ContactVO(cf.userid, cf.name, 'OFFLINE') from User u join u.contactsReverse cf", ContactVO.class).getResultList();

		Set<ContactVO> allContacts = new HashSet<>();
		allContacts.addAll(contactsForward);
		allContacts.addAll(contactsReverse);
		
		//TODO Melhorar performance
		List<ContactVO> allContactsList = new ArrayList<>(allContacts);
		for (ContactVO c : allContactsList) {
			List<String> stringList = em.createQuery("select 'x' from Session s where s.user.userid = :userid", String.class).setParameter("userid", c.getUserid()).getResultList();
			if (stringList.size() > 0) {
				c.setStatus("ONLINE");
			}
		}

		return allContactsList;
	}
}
