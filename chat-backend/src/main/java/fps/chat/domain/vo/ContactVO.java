package fps.chat.domain.vo;

public class ContactVO {

	private String userid;
	private String name;
	private String status;

	public ContactVO(String userid, String name, String status) {
		this.userid = userid;
		this.name = name;
		this.status = status;
	}

	@Override
	public boolean equals(Object obj) {
		return userid.equals(((ContactVO) obj).getUserid());
	}

	@Override
	public int hashCode() {
		return userid.hashCode();
	}
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
