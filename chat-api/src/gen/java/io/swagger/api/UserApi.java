package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.UserApiService;
import io.swagger.api.factories.UserApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.CreateUserRequest;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/user")


@io.swagger.annotations.Api(description = "the user API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-02T13:26:34.683Z")
public class UserApi  {
   private final UserApiService delegate = UserApiServiceFactory.getUserApi();

    @POST
    
    
    
    @io.swagger.annotations.ApiOperation(value = "Criar novo usuário", notes = "Criar novo usuário", response = void.class, tags={ "usuários", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "ok", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "falha", response = void.class) })
    public Response createUser(@ApiParam(value = "User credentials for authentication" ,required=true) CreateUserRequest loginRequest
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createUser(loginRequest,securityContext);
    }
}
