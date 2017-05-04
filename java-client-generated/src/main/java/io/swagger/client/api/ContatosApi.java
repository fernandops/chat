

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

import io.swagger.client.model.Contact;
import io.swagger.client.model.SessionIdRequest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContatosApi {
    private ApiClient apiClient;

    public ContatosApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ContatosApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for listContacts */
    private com.squareup.okhttp.Call listContactsCall(SessionIdRequest sessionid, String status, String useridLike, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = sessionid;
        
        // verify the required parameter 'sessionid' is set
        if (sessionid == null) {
            throw new ApiException("Missing the required parameter 'sessionid' when calling listContacts(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/contacts".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (status != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "status", status));
        if (useridLike != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "useridLike", useridLike));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Listar contatos aplicando filtros opcionais
     * Listar contatos aplicando filtros opcionais
     * @param sessionid  (required)
     * @param status Filtra pelo status do contato. Valores válidos são: Online / Offline (optional)
     * @param useridLike Filtra pela substring do userid do contato. (optional)
     * @return List&lt;Contact&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Contact> listContacts(SessionIdRequest sessionid, String status, String useridLike) throws ApiException {
        ApiResponse<List<Contact>> resp = listContactsWithHttpInfo(sessionid, status, useridLike);
        return resp.getData();
    }

    /**
     * Listar contatos aplicando filtros opcionais
     * Listar contatos aplicando filtros opcionais
     * @param sessionid  (required)
     * @param status Filtra pelo status do contato. Valores válidos são: Online / Offline (optional)
     * @param useridLike Filtra pela substring do userid do contato. (optional)
     * @return ApiResponse&lt;List&lt;Contact&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Contact>> listContactsWithHttpInfo(SessionIdRequest sessionid, String status, String useridLike) throws ApiException {
        com.squareup.okhttp.Call call = listContactsCall(sessionid, status, useridLike, null, null);
        Type localVarReturnType = new TypeToken<List<Contact>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Listar contatos aplicando filtros opcionais (asynchronously)
     * Listar contatos aplicando filtros opcionais
     * @param sessionid  (required)
     * @param status Filtra pelo status do contato. Valores válidos são: Online / Offline (optional)
     * @param useridLike Filtra pela substring do userid do contato. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call listContactsAsync(SessionIdRequest sessionid, String status, String useridLike, final ApiCallback<List<Contact>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = listContactsCall(sessionid, status, useridLike, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Contact>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
