package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.CreateUserRequest;

import java.util.List;
import java.util.logging.Logger;

import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import fps.chat.domain.User;
import fps.chat.service.ServiceLocator;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-03T03:55:25.778Z")
public class UserApiServiceImpl extends UserApiService {
	
	private Logger log = Logger.getLogger(UserApiServiceImpl.class.getName());
	
    @Override
    public Response createUser(CreateUserRequest newUserReq, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
//    	return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    	if (newUserReq == null) {
    		throw new WebApplicationException("Request body null");
    	}
    	User user = ServiceLocator.getUserService().createUser(newUserReq.getUserid(), newUserReq.getPassword(), newUserReq.getName(), newUserReq.getEmail());
    	log.info("Created user '" + user.getUserid() + "' with id " + user.getId());
    	return Response.ok().entity(user).build();
    }
}
