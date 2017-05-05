package fps.chat;

import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import fps.chat.domain.Session;
import fps.chat.domain.User;
import fps.chat.service.ServiceLocator;

@ManagedBean
@ViewScoped
public class LoginBean {

	private Logger log = Logger.getLogger(LoginBean.class.getName());
	private String username, password;
	private boolean rememberMe;
	
	public String login() {
		Subject currentUser = SecurityUtils.getSubject();
		try {
			if (currentUser.isAuthenticated()) {
				logout();
			}
	        if (!currentUser.isAuthenticated()) { 
	            try {
	            	UsernamePasswordToken userToken = new UsernamePasswordToken(username, password); 
	                userToken.setRememberMe(rememberMe); 
	                currentUser.login(userToken); 
	                
	                ExternalContext fc = FacesContext.getCurrentInstance().getExternalContext();
	                HttpSession servletSession = (HttpSession) fc.getSession(true);

	                User user = ServiceLocator.getUserService().getUser(username, password.toCharArray());
	                Session session = ServiceLocator.getSessionService().createSession(user);

	                String sessionid = session.getSessionid();

	            	log.info("Created session '" + session.getSessionid() + "' with id " + session.getId());
	            	
	                servletSession.setAttribute("sessionid", sessionid);
	                
	            } catch (Exception e) { 
	            	e.printStackTrace();
	            } 
	        } 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}
	
	public String logout() {
		Subject currentUser = SecurityUtils.getSubject();
		try {
		    currentUser.logout();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
}
