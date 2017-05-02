package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.InventoryItem;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-02T13:26:34.683Z")
public abstract class InventoryApiService {
    public abstract Response addInventory(InventoryItem inventoryItem,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchInventory(String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
}
