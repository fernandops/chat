package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.ReceivedMessage;
import io.swagger.model.SendMessageRequest;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-06T07:34:56.998Z")
public abstract class MessageApiService {
    public abstract Response retrievePendingMessages(String sessionid,SecurityContext securityContext) throws NotFoundException;
    public abstract Response sendMessage(SendMessageRequest sendMessageRequest,SecurityContext securityContext) throws NotFoundException;
}
