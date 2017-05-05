package fps.chat;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.ContatosApi;
import io.swagger.client.model.Contact;
import io.swagger.client.model.SessionIdRequest;

@ManagedBean
@ViewScoped
public class ContactsBean {

	public List<Contact> getOnlineContacts() throws ApiException {
		
		ApiClient apiClient = new ApiClient();
		
		System.out.println("HELLO WORLD! Basepath = " + apiClient .getBasePath());
//		apiClient.setBasePath("http://localhost:8081/fernandops/ChatApp/1.0.0");
		apiClient.setBasePath("http://localhost:8080/chat-gui-1.0/api");
		// http://localhost:8080/fernandops/ChatApp/1.0.0/swagger.json
		// http://localhost:8080/chat-gui-1.0/api/swagger.json
		System.out.println("         new Basepath = " + apiClient .getBasePath());
		
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String sessionid = (String) request.getSession().getAttribute("sessionid");

		SessionIdRequest sessionIdRequest = new SessionIdRequest();
		sessionIdRequest.setSessionid(sessionid);
		
		return new ContatosApi(apiClient).listContacts(sessionIdRequest, "Online", null);
	}
}
