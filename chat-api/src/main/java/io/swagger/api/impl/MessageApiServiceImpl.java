package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.ReceivedMessage;
import io.swagger.model.SendMessageRequest;
import io.swagger.model.SessionIdRequest;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import fps.chat.service.ServiceLocator;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-05T23:06:23.817Z")
public class MessageApiServiceImpl extends MessageApiService {
    @Override
    public Response retrievePendingMessages(SessionIdRequest sessionid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response sendMessage(SendMessageRequest sendMessageRequest, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
//        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    	ServiceLocator.getMessageService().sendMessage(sendMessageRequest.getRecipient(), sendMessageRequest.getContent(), sendMessageRequest.getSessionid());
        return Response.ok().build();
    }
}
