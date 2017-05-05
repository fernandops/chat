package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.ContactsApiService;
import io.swagger.api.factories.ContactsApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.Contact;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/contacts")


@io.swagger.annotations.Api(description = "the contacts API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-05T23:06:23.817Z")
public class ContactsApi  {
   private final ContactsApiService delegate = ContactsApiServiceFactory.getContactsApi();

    @OPTIONS
    
    
    
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "BasicAuth")
    }, tags={ "contatos", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = void.class) })
    public Response contactsOptions(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.contactsOptions(securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Listar contatos aplicando filtros opcionais", notes = "Listar contatos aplicando filtros opcionais", response = Contact.class, responseContainer = "List", authorizations = {
        @io.swagger.annotations.Authorization(value = "BasicAuth")
    }, tags={ "contatos", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "ok", response = Contact.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "requisição inválida", response = Contact.class, responseContainer = "List") })
    public Response listContacts(@ApiParam(value = "" ,required=true)@HeaderParam("sessionid") String sessionid
,@ApiParam(value = "Filtra pelo status do contato. Valores válidos são: Online / Offline", allowableValues="Online, Offline") @QueryParam("status") String status
,@ApiParam(value = "Filtra pela substring do userid do contato.") @QueryParam("useridLike") String useridLike
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.listContacts(sessionid,status,useridLike,securityContext);
    }
}
