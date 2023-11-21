# simple-api-service
Simple API Service for handling simple HTTP request, consisting of 2 modules: simple and registry. </br></br>

### Simple Module
Handle HTTP request for Simple API

### Registry Module
Handle logic to register the **simple-api-service** to **registry-service**

</br>

## System Flow
### Handle /simples HTTP request

```mermaid
sequenceDiagram
    participant routing-service
    participant simple-api-service
    routing-service->>simple-api-service: POST: /simples {<payload>}
    simple-api-service->>routing-service: HTTP Response 200: OK {<payload>}
```

### Register service to registry

```mermaid
sequenceDiagram
    participant simple-api-service
    participant registry-service
    participant routing-service
    simple-api-service->>simple-api-service: handle application event when initialized
    simple-api-service->>registry-service: POST: /registries {application name, port}
    registry-service->>registry-service: add application to registry list
    registry-service->>routing-service: publish "add" event
    registry-service->>simple-api-service: HTTP Response 200: OK {"success"}
```

For more information on other flows and services, see also [registry-service](https://github.com/punyisakra/registry-service) and [routing-service](https://github.com/punyisakra/routing-service)
