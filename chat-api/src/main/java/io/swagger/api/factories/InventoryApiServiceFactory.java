package io.swagger.api.factories;

import io.swagger.api.InventoryApiService;
import io.swagger.api.impl.InventoryApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-05T23:06:23.817Z")
public class InventoryApiServiceFactory {
    private final static InventoryApiService service = new InventoryApiServiceImpl();

    public static InventoryApiService getInventoryApi() {
        return service;
    }
}
