package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.Contact;
import io.swagger.client.model.SessionIdRequest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ContatosApi
 */
public class ContatosApiTest {

    private final ContatosApi api = new ContatosApi();

    
    /**
     * Listar contatos aplicando filtros opcionais
     *
     * Listar contatos aplicando filtros opcionais
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listContactsTest() throws ApiException {
        SessionIdRequest sessionid = null;
        String status = null;
        String useridLike = null;
        // List<Contact> response = api.listContacts(sessionid, status, useridLike);

        // TODO: test validations
    }
    
}
