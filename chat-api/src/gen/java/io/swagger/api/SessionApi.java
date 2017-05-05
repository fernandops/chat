package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.SessionApiService;
import io.swagger.api.factories.SessionApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.LoginRequest;
import io.swagger.model.LoginSuccessResponse;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/session")


@io.swagger.annotations.Api(description = "the session API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-05T23:06:23.817Z")
public class SessionApi  {
   private final SessionApiService delegate = SessionApiServiceFactory.getSessionApi();

    @POST
    @Path("/login")
    
    
    @io.swagger.annotations.ApiOperation(value = "Realizar login", notes = "Realizar login", response = LoginSuccessResponse.class, tags={ "autenticação", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "ok", response = LoginSuccessResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Dados de acesso inválidos", response = LoginSuccessResponse.class) })
    public Response login(@ApiParam(value = "User credentials for authentication" ,required=true) LoginRequest loginRequest
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.login(loginRequest,securityContext);
    }
    @OPTIONS
    @Path("/login")
    
    
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = void.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "BasicAuth")
    }, tags={ "autenticação", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = void.class) })
    public Response sessionLoginOptions(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.sessionLoginOptions(securityContext);
    }
}
