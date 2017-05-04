# UsuriosApi

All URIs are relative to *https://virtserver.swaggerhub.com/fernandops/ChatApp/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createUser**](UsuriosApi.md#createUser) | **POST** /user | Criar novo usuário


<a name="createUser"></a>
# **createUser**
> createUser(loginRequest)

Criar novo usuário

Criar novo usuário

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UsuriosApi;


UsuriosApi apiInstance = new UsuriosApi();
CreateUserRequest loginRequest = new CreateUserRequest(); // CreateUserRequest | User credentials for authentication
try {
    apiInstance.createUser(loginRequest);
} catch (ApiException e) {
    System.err.println("Exception when calling UsuriosApi#createUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **loginRequest** | [**CreateUserRequest**](CreateUserRequest.md)| User credentials for authentication |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

