package com.assignment.coda.simpleapiservice.registry.service;

import com.assignment.coda.simpleapiservice.registry.dto.Instance;
import reactor.core.publisher.Mono;

/**
 * A client interface implemented by {@link RegistryClientImpl}
 * to provide a connection to registry-service
 */
public interface RegistryClient {

    /**
     * Register the input instance with registry-service by POST to the registry API asynchronously
     * @param instance an application instance of type {@link Instance} to be registered
     * @return registered result in {@link String}, wrapped in {@link Mono}
     */
    Mono<String> register(Instance instance);
}
