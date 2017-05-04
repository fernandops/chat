package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.ReceivedMessage;
import io.swagger.client.model.SendMessageRequest;
import io.swagger.client.model.SessionIdRequest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for MensagensApi
 */
public class MensagensApiTest {

    private final MensagensApi api = new MensagensApi();

    
    /**
     * Obter mensagens pendentes e removê-las da fila de pendentes
     *
     * Obter mensagens pendentes e removê-las da fila de pendentes. Observação: Foi usado POST devido à mudança de estado da fila de mensagens pendentes offline. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void retrievePendingMessagesTest() throws ApiException {
        SessionIdRequest sessionid = null;
        // List<ReceivedMessage> response = api.retrievePendingMessages(sessionid);

        // TODO: test validations
    }
    
    /**
     * Enviar mensagem
     *
     * Enviar mensagem
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void sendMessageTest() throws ApiException {
        SendMessageRequest sendMessageRequest = null;
        // api.sendMessage(sendMessageRequest);

        // TODO: test validations
    }
    
}
