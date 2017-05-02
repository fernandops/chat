package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.ReceivedMessage;
import io.swagger.model.SendMessageRequest;
import io.swagger.model.Sessionid;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-02T13:26:34.683Z")
public abstract class MessageApiService {
    public abstract Response retrievePendingMessages(Sessionid sessionid,SecurityContext securityContext) throws NotFoundException;
    public abstract Response sendMessage(SendMessageRequest sessionid,SecurityContext securityContext) throws NotFoundException;
}
