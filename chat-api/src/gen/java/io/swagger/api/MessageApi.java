package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.MessageApiService;
import io.swagger.api.factories.MessageApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.ReceivedMessage;
import io.swagger.model.SendMessageRequest;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/message")


@io.swagger.annotations.Api(description = "the message API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-06T07:34:56.998Z")
public class MessageApi  {
   private final MessageApiService delegate = MessageApiServiceFactory.getMessageApi();

    @POST
    @Path("/retrievePendingMessages")
    
    
    @io.swagger.annotations.ApiOperation(value = "Obter mensagens pendentes e removê-las da fila de pendentes", notes = "Obter mensagens pendentes e removê-las da fila de pendentes. Observação: Foi usado POST devido à mudança de estado da fila de mensagens pendentes offline. ", response = ReceivedMessage.class, responseContainer = "List", authorizations = {
        @io.swagger.annotations.Authorization(value = "BasicAuth")
    }, tags={ "mensagens", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = ReceivedMessage.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 204, message = "no messages", response = ReceivedMessage.class, responseContainer = "List") })
    public Response retrievePendingMessages(@ApiParam(value = "" ,required=true)@HeaderParam("sessionid") String sessionid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.retrievePendingMessages(sessionid,securityContext);
    }
    @POST
    
    
    
    @io.swagger.annotations.ApiOperation(value = "Enviar mensagem", notes = "Enviar mensagem", response = void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "BasicAuth")
    }, tags={ "mensagens", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "requisição inválida", response = void.class) })
    public Response sendMessage(@ApiParam(value = "" ,required=true) SendMessageRequest sendMessageRequest
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.sendMessage(sendMessageRequest,securityContext);
    }
}
