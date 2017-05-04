package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.Contact;
import io.swagger.model.SessionIdRequest;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-03T03:55:25.778Z")
public abstract class ContactsApiService {
    public abstract Response listContacts(SessionIdRequest sessionid,String status,String useridLike,SecurityContext securityContext) throws NotFoundException;
}
