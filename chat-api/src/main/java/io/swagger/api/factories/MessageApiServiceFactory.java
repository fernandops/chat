package io.swagger.api.factories;

import io.swagger.api.MessageApiService;
import io.swagger.api.impl.MessageApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-06T07:34:56.998Z")
public class MessageApiServiceFactory {
    private final static MessageApiService service = new MessageApiServiceImpl();

    public static MessageApiService getMessageApi() {
        return service;
    }
}
