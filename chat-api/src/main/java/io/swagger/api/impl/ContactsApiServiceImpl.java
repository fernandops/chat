package io.swagger.api.impl;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import fps.chat.service.ServiceLocator;
import io.swagger.api.ApiResponseMessage;
import io.swagger.api.ContactsApiService;
import io.swagger.api.NotFoundException;
import io.swagger.model.SessionIdRequest;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-03T03:55:25.778Z")
public class ContactsApiServiceImpl extends ContactsApiService {
    @Override
    public Response listContacts(SessionIdRequest sessionid, String status, String useridLike, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
    	if (securityContext.getUserPrincipal() == null) {
            return Response.status(Status.UNAUTHORIZED).build();
    	} else {
    		int resp = ServiceLocator.getContactService().listContacts(sessionid.getSessionid(), status, useridLike);
    		return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    	}
    }
}
