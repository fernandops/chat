package io.swagger.api.factories;

import io.swagger.api.MessageApiService;
import io.swagger.api.impl.MessageApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-03T03:55:25.778Z")
public class MessageApiServiceFactory {
    private final static MessageApiService service = new MessageApiServiceImpl();

    public static MessageApiService getMessageApi() {
        return service;
    }
}
