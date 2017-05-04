package fps.chat;

import javax.persistence.NoResultException;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.Realm;

import fps.chat.domain.User;
import fps.chat.service.ServiceLocator;

public class MeuRealm implements Realm {

	@Override
	public String getName() {
		return "ChatApp";
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		if (token.getPrincipal() == null || token.getCredentials() == null) {
			return false;
		}
		return true;
	}

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String tokenPrincipal = (String) token.getPrincipal();
		char[] tokenCredencial = (char[]) token.getCredentials();

		if (tokenPrincipal == null || tokenCredencial == null) {
			throw new IllegalArgumentException();
		}

		User user = null;
		try {
			user = ServiceLocator.getUserService().getUser(tokenPrincipal, tokenCredencial);
		} catch (NoResultException e) {
//			throw new UnknownAccountException("usuário não cadastrado");
			if (user == null)
			return null;
		}

		return new SimpleAuthenticationInfo(tokenPrincipal, tokenCredencial, getName());

		/*String credencial = user.getPassword();

		AuthenticationInfo info = new SimpleAuthenticationInfo(tokenPrincipal, credencial, getName());
		SimpleCredentialsMatcher cmatcher = new SimpleCredentialsMatcher();
		
		boolean credentialsMatch = cmatcher.doCredentialsMatch(token, info);
		if (credentialsMatch) {
			return info;
		}
		
		throw new AuthenticationException();*/
	}
}