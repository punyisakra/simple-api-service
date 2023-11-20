package com.assignment.coda.simpleapiservice.registry.service;

import com.assignment.coda.simpleapiservice.registry.dto.Instance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * A client class providing an implementation to {@link RegistryClient}
 * to connect to registry-service
 */
@Service
public class RegistryClientImpl implements RegistryClient {

    private final Logger logger = LoggerFactory.getLogger(RegistryClientImpl.class);

    private final WebClient webClient;

    @Autowired
    public RegistryClientImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    /**
     * Register the input instance with registry-service by POST to the registry API asynchronously
     * @param instance an application instance of type {@link Instance} to be registered
     * @return registered result in {@link String}, wrapped in {@link Mono}
     */
    @Override
    public Mono<String> register(Instance instance) {
        logger.info("Register this instance with registry-service: {}", instance);
        return webClient.post()
                .uri("/registries")
                .body(Mono.just(instance), Instance.class)
                .retrieve()
                .bodyToMono(String.class);
    }
}
