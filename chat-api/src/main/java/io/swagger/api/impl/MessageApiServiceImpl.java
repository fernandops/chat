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

import fps.chat.domain.vo.MessageVO;
import fps.chat.service.ServiceLocator;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-06T07:34:56.998Z")
public class MessageApiServiceImpl extends MessageApiService {
    @Override
    public Response retrievePendingMessages(String sessionid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
//      return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();	
    	List<MessageVO> messages = ServiceLocator.getMessageService().retrievePendingMessages(sessionid);
      	return Response.ok().entity(messages).build();
    }
    @Override
    public Response sendMessage(SendMessageRequest sendMessageRequest, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
//        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    	ServiceLocator.getMessageService().sendMessage(sendMessageRequest.getRecipient(), sendMessageRequest.getContent(), sendMessageRequest.getSessionid());
        return Response.ok().build();
    }
}
