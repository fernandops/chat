package io.swagger.api.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import fps.chat.domain.vo.ContactVO;
import fps.chat.service.ServiceLocator;
import io.swagger.api.ContactsApiService;
import io.swagger.api.NotFoundException;
import io.swagger.model.Contact;
import io.swagger.model.Contact.StatusEnum;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-05T23:06:23.817Z")
public class ContactsApiServiceImpl extends ContactsApiService {
    @Override
    public Response contactsOptions(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
//				.header("Access-Control-Allow-Headers", "sessionid")
				.header("Access-Control-Allow-Origin", "http://localhost:8000")
        		.build();
    }
    @Override
    public Response listContacts(String sessionid, String status, String useridLike, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
//    	return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    	/*if (securityContext.getUserPrincipal() == null) {
            return Response.status(Status.UNAUTHORIZED).build();
    	} else {*/
    		List<ContactVO> contacts = ServiceLocator.getContactService().listContacts(sessionid, status, useridLike);
    		List<Contact> contactsApi = convert(contacts);
    		return Response.ok().entity(contactsApi).build();
    	//}
    }

    //TODO Refatorar para não precisar disto
	private List<Contact> convert(List<ContactVO> contacts) {
		List<Contact> contactsApi = new ArrayList<>();
		for (ContactVO c : contacts) {
			 Contact contactApi = new Contact();
			 contactApi.setUserid(c.getUserid());
			 contactApi.setName(c.getName());
			 contactApi.setStatus(StatusEnum.valueOf(c.getStatus().toString()));
			 contactsApi.add(contactApi);
		}
		return contactsApi;
	}
}
