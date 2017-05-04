# MensagensApi

All URIs are relative to *https://virtserver.swaggerhub.com/fernandops/ChatApp/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**retrievePendingMessages**](MensagensApi.md#retrievePendingMessages) | **POST** /message/retrievePendingMessages | Obter mensagens pendentes e removê-las da fila de pendentes
[**sendMessage**](MensagensApi.md#sendMessage) | **POST** /message | Enviar mensagem


<a name="retrievePendingMessages"></a>
# **retrievePendingMessages**
> List&lt;ReceivedMessage&gt; retrievePendingMessages(sessionid)

Obter mensagens pendentes e removê-las da fila de pendentes

Obter mensagens pendentes e removê-las da fila de pendentes. Observação: Foi usado POST devido à mudança de estado da fila de mensagens pendentes offline. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.MensagensApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

MensagensApi apiInstance = new MensagensApi();
SessionIdRequest sessionid = new SessionIdRequest(); // SessionIdRequest | 
try {
    List<ReceivedMessage> result = apiInstance.retrievePendingMessages(sessionid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MensagensApi#retrievePendingMessages");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sessionid** | [**SessionIdRequest**](SessionIdRequest.md)|  |

### Return type

[**List&lt;ReceivedMessage&gt;**](ReceivedMessage.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="sendMessage"></a>
# **sendMessage**
> sendMessage(sendMessageRequest)

Enviar mensagem

Enviar mensagem

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.MensagensApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

MensagensApi apiInstance = new MensagensApi();
SendMessageRequest sendMessageRequest = new SendMessageRequest(); // SendMessageRequest | 
try {
    apiInstance.sendMessage(sendMessageRequest);
} catch (ApiException e) {
    System.err.println("Exception when calling MensagensApi#sendMessage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sendMessageRequest** | [**SendMessageRequest**](SendMessageRequest.md)|  |

### Return type

null (empty response body)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

