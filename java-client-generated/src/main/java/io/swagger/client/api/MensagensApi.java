

package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import io.swagger.client.model.ReceivedMessage;
import io.swagger.client.model.SendMessageRequest;
import io.swagger.client.model.SessionIdRequest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MensagensApi {
    private ApiClient apiClient;

    public MensagensApi() {
        this(Configuration.getDefaultApiClient());
    }

    public MensagensApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for retrievePendingMessages */
    private com.squareup.okhttp.Call retrievePendingMessagesCall(SessionIdRequest sessionid, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = sessionid;
        
        // verify the required parameter 'sessionid' is set
        if (sessionid == null) {
            throw new ApiException("Missing the required parameter 'sessionid' when calling retrievePendingMessages(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/message/retrievePendingMessages".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "BasicAuth" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Obter mensagens pendentes e removê-las da fila de pendentes
     * Obter mensagens pendentes e removê-las da fila de pendentes. Observação: Foi usado POST devido à mudança de estado da fila de mensagens pendentes offline. 
     * @param sessionid  (required)
     * @return List&lt;ReceivedMessage&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<ReceivedMessage> retrievePendingMessages(SessionIdRequest sessionid) throws ApiException {
        ApiResponse<List<ReceivedMessage>> resp = retrievePendingMessagesWithHttpInfo(sessionid);
        return resp.getData();
    }

    /**
     * Obter mensagens pendentes e removê-las da fila de pendentes
     * Obter mensagens pendentes e removê-las da fila de pendentes. Observação: Foi usado POST devido à mudança de estado da fila de mensagens pendentes offline. 
     * @param sessionid  (required)
     * @return ApiResponse&lt;List&lt;ReceivedMessage&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<ReceivedMessage>> retrievePendingMessagesWithHttpInfo(SessionIdRequest sessionid) throws ApiException {
        com.squareup.okhttp.Call call = retrievePendingMessagesCall(sessionid, null, null);
        Type localVarReturnType = new TypeToken<List<ReceivedMessage>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Obter mensagens pendentes e removê-las da fila de pendentes (asynchronously)
     * Obter mensagens pendentes e removê-las da fila de pendentes. Observação: Foi usado POST devido à mudança de estado da fila de mensagens pendentes offline. 
     * @param sessionid  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call retrievePendingMessagesAsync(SessionIdRequest sessionid, final ApiCallback<List<ReceivedMessage>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = retrievePendingMessagesCall(sessionid, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<ReceivedMessage>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for sendMessage */
    private com.squareup.okhttp.Call sendMessageCall(SendMessageRequest sendMessageRequest, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = sendMessageRequest;
        
        // verify the required parameter 'sendMessageRequest' is set
        if (sendMessageRequest == null) {
            throw new ApiException("Missing the required parameter 'sendMessageRequest' when calling sendMessage(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/message".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "BasicAuth" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Enviar mensagem
     * Enviar mensagem
     * @param sendMessageRequest  (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void sendMessage(SendMessageRequest sendMessageRequest) throws ApiException {
        sendMessageWithHttpInfo(sendMessageRequest);
    }

    /**
     * Enviar mensagem
     * Enviar mensagem
     * @param sendMessageRequest  (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> sendMessageWithHttpInfo(SendMessageRequest sendMessageRequest) throws ApiException {
        com.squareup.okhttp.Call call = sendMessageCall(sendMessageRequest, null, null);
        return apiClient.execute(call);
    }

    /**
     * Enviar mensagem (asynchronously)
     * Enviar mensagem
     * @param sendMessageRequest  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call sendMessageAsync(SendMessageRequest sendMessageRequest, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = sendMessageCall(sendMessageRequest, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
}
