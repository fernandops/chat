package fps.chat.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "userid" }) })
public class User {

	@Id @GeneratedValue
	private Long id;

	private String userid;

	private String password;

	private String name;

	private String email;

	@ManyToMany
	@JoinTable(name = "USER_CONTACT", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "CONTACT_ID") })
	private List<User> contactsForward = new ArrayList<>();

	@ManyToMany(mappedBy = "contactsForward")
//	@JoinTable(name = "USER_CONTACT", joinColumns = { @JoinColumn(name = "CONTACT_ID") }, inverseJoinColumns = {
//			@JoinColumn(name = "USER_ID") })
	private List<User> contactsReverse = new ArrayList<>();

	
	public List<User> getContacts() {
		Set<User> fullSet = new HashSet<>();
		fullSet.addAll(contactsForward);
		fullSet.addAll(contactsReverse);
		List<User> list = new ArrayList<>(fullSet);
		list.sort(null);
		return list;
	}

	public void setContacts(List<User> contacts) {
		throw new IllegalStateException();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<User> getContactsForward() {
		return contactsForward;
	}

	public void setContactsForward(List<User> contactsForward) {
		this.contactsForward = contactsForward;
	}

	public List<User> getContactsReverse() {
		return contactsReverse;
	}

	public void setContactsReverse(List<User> contactsReverse) {
		this.contactsReverse = contactsReverse;
	}
}
