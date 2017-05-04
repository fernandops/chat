package io.swagger.api.impl;

import java.util.logging.Logger;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import fps.chat.domain.Session;
import fps.chat.domain.User;
import fps.chat.service.ServiceLocator;
import io.swagger.api.NotFoundException;
import io.swagger.api.SessionApiService;
import io.swagger.model.LoginRequest;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-03T03:55:25.778Z")
public class SessionApiServiceImpl extends SessionApiService {

	private Logger log = Logger.getLogger(SessionApiServiceImpl.class.getName());

//    @Context
//    private HttpServletRequest request;

    @Override
    public Response login(LoginRequest loginRequest, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
//        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    	if (loginRequest == null) {
    		throw new WebApplicationException("Request body null");
    	}
    	String userid = loginRequest.getUser();
    	String password = loginRequest.getPassword();
    	
    	if (userid == null || password == null) {
    		throw new IllegalArgumentException();
    	}

    	User user = ServiceLocator.getUserService().getUser(userid, password.toCharArray());
    	Session session = ServiceLocator.getSessionService().createSession(user);
    	
    	
    	log.info("Created session '" + session.getSessionid() + "' with id " + session.getId());
    	return Response.ok().entity(session.getSessionid()).build();
    }
}
