package io.swagger.api.factories;

import io.swagger.api.SessionApiService;
import io.swagger.api.impl.SessionApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-06T07:34:56.998Z")
public class SessionApiServiceFactory {
    private final static SessionApiService service = new SessionApiServiceImpl();

    public static SessionApiService getSessionApi() {
        return service;
    }
}
