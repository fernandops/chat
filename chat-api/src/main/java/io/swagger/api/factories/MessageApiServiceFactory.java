package io.swagger.api.factories;

import io.swagger.api.MessageApiService;
import io.swagger.api.impl.MessageApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-05T23:06:23.817Z")
public class MessageApiServiceFactory {
    private final static MessageApiService service = new MessageApiServiceImpl();

    public static MessageApiService getMessageApi() {
        return service;
    }
}
