package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.ContactsApiService;
import io.swagger.api.factories.ContactsApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.Contact;
import io.swagger.model.Sessionid1;

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
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-02T13:26:34.683Z")
public class ContactsApi  {
   private final ContactsApiService delegate = ContactsApiServiceFactory.getContactsApi();

    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Listar contatos aplicando filtros opcionais", notes = "Listar contatos aplicando filtros opcionais", response = Contact.class, responseContainer = "List", tags={ "contatos", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "ok", response = Contact.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "requisição inválida", response = Contact.class, responseContainer = "List") })
    public Response listOnlineContacts(@ApiParam(value = "" ,required=true) Sessionid1 sessionid
,@ApiParam(value = "Filtra pelo status do contato. Valores válidos são: Online / Offline", allowableValues="Online, Offline") @QueryParam("status") String status
,@ApiParam(value = "Filtra pela substring do userid do contato.") @QueryParam("useridLike") String useridLike
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.listOnlineContacts(sessionid,status,useridLike,securityContext);
    }
}
