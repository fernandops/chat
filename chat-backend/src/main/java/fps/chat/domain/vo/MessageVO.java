package fps.chat.domain.vo;

import java.util.Date;

import fps.chat.domain.Message;

public class MessageVO {

	private String id;
	private String sender;
	private String content;
	private Date date;

	public MessageVO(Message m) {
		this.id = m.getId().toString();
		this.sender = m.getSender().getName();
		this.content = m.getContent();
		this.date = m.getDate();
	}

	@Override
	public boolean equals(Object obj) {
		return id.equals(((MessageVO) obj).getId());
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}