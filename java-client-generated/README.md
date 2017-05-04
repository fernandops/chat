# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.AdminsApi;

import java.io.File;
import java.util.*;

public class AdminsApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        
        // Configure HTTP basic authorization: BasicAuth
        HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
        BasicAuth.setUsername("YOUR USERNAME");
        BasicAuth.setPassword("YOUR PASSWORD");

        AdminsApi apiInstance = new AdminsApi();
        InventoryItem inventoryItem = new InventoryItem(); // InventoryItem | Inventory item to add
        try {
            apiInstance.addInventory(inventoryItem);
        } catch (ApiException e) {
            System.err.println("Exception when calling AdminsApi#addInventory");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://virtserver.swaggerhub.com/fernandops/ChatApp/1.0.0*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AdminsApi* | [**addInventory**](docs/AdminsApi.md#addInventory) | **POST** /inventory | adds an inventory item
*AutenticaoApi* | [**login**](docs/AutenticaoApi.md#login) | **POST** /session/login | Realizar login
*ContatosApi* | [**listContacts**](docs/ContatosApi.md#listContacts) | **GET** /contacts | Listar contatos aplicando filtros opcionais
*DevelopersApi* | [**searchInventory**](docs/DevelopersApi.md#searchInventory) | **GET** /inventory | searches inventory
*MensagensApi* | [**retrievePendingMessages**](docs/MensagensApi.md#retrievePendingMessages) | **POST** /message/retrievePendingMessages | Obter mensagens pendentes e removê-las da fila de pendentes
*MensagensApi* | [**sendMessage**](docs/MensagensApi.md#sendMessage) | **POST** /message | Enviar mensagem
*UsuriosApi* | [**createUser**](docs/UsuriosApi.md#createUser) | **POST** /user | Criar novo usuário


## Documentation for Models

 - [Contact](docs/Contact.md)
 - [CreateUserRequest](docs/CreateUserRequest.md)
 - [InventoryItem](docs/InventoryItem.md)
 - [LoginRequest](docs/LoginRequest.md)
 - [LoginSuccessResponse](docs/LoginSuccessResponse.md)
 - [Manufacturer](docs/Manufacturer.md)
 - [ReceivedMessage](docs/ReceivedMessage.md)
 - [SendMessageRequest](docs/SendMessageRequest.md)
 - [SessionIdRequest](docs/SessionIdRequest.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### BasicAuth

- **Type**: HTTP basic authentication

### api_key

- **Type**: API key
- **API key parameter name**: api_key
- **Location**: HTTP header

### petstore_auth

- **Type**: OAuth
- **Flow**: implicit
- **Authorizatoin URL**: http://petstore.swagger.io/oauth/dialog
- **Scopes**: 
  - write:pets: modify pets in your account
  - read:pets: read your pets


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

you@your-company.com

