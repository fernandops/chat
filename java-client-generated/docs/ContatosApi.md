# ContatosApi

All URIs are relative to *https://virtserver.swaggerhub.com/fernandops/ChatApp/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**listContacts**](ContatosApi.md#listContacts) | **GET** /contacts | Listar contatos aplicando filtros opcionais


<a name="listContacts"></a>
# **listContacts**
> List&lt;Contact&gt; listContacts(sessionid, status, useridLike)

Listar contatos aplicando filtros opcionais

Listar contatos aplicando filtros opcionais

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.ContatosApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

ContatosApi apiInstance = new ContatosApi();
SessionIdRequest sessionid = new SessionIdRequest(); // SessionIdRequest | 
String status = "status_example"; // String | Filtra pelo status do contato. Valores válidos são: Online / Offline
String useridLike = "useridLike_example"; // String | Filtra pela substring do userid do contato.
try {
    List<Contact> result = apiInstance.listContacts(sessionid, status, useridLike);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContatosApi#listContacts");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sessionid** | [**SessionIdRequest**](SessionIdRequest.md)|  |
 **status** | **String**| Filtra pelo status do contato. Valores válidos são: Online / Offline | [optional] [enum: Online, Offline]
 **useridLike** | **String**| Filtra pela substring do userid do contato. | [optional]

### Return type

[**List&lt;Contact&gt;**](Contact.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

