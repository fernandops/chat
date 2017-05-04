# AutenticaoApi

All URIs are relative to *https://virtserver.swaggerhub.com/fernandops/ChatApp/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**login**](AutenticaoApi.md#login) | **POST** /session/login | Realizar login


<a name="login"></a>
# **login**
> LoginSuccessResponse login(loginRequest)

Realizar login

Realizar login

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AutenticaoApi;


AutenticaoApi apiInstance = new AutenticaoApi();
LoginRequest loginRequest = new LoginRequest(); // LoginRequest | User credentials for authentication
try {
    LoginSuccessResponse result = apiInstance.login(loginRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AutenticaoApi#login");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **loginRequest** | [**LoginRequest**](LoginRequest.md)| User credentials for authentication |

### Return type

[**LoginSuccessResponse**](LoginSuccessResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

