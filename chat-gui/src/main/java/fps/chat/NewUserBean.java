package fps.chat;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.UsuriosApi;
import io.swagger.client.model.CreateUserRequest;

@ManagedBean
@ViewScoped
public class NewUserBean {

	private String userid, password, name, email;
	
	public String createUser() throws ApiException {
		
		ApiClient apiClient = new ApiClient();
		
		System.out.println("HELLO WORLD! Basepath = " + apiClient .getBasePath());
//		apiClient.setBasePath("http://localhost:8081/fernandops/ChatApp/1.0.0");
		apiClient.setBasePath("http://localhost:8080/chat-gui-1.0/api");
		// http://localhost:8080/fernandops/ChatApp/1.0.0/swagger.json
		// http://localhost:8080/chat-gui-1.0/api/swagger.json
		System.out.println("         new Basepath = " + apiClient .getBasePath());
		
		CreateUserRequest loginRequest = new CreateUserRequest();
		loginRequest.setUserid(userid);
		loginRequest.setPassword(password);
		loginRequest.setName(name);
		loginRequest.setEmail(email);
		
		new UsuriosApi(apiClient).createUser(loginRequest);
		
		return "ok";
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
}
