package com.assignment.coda.simpleapiservice.service;

import com.assignment.coda.simpleapiservice.model.Instance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class RegistryClientImpl implements RegistryClient {

    private final Logger logger = LoggerFactory.getLogger(RegistryClientImpl.class);

    private final WebClient webClient;

    @Autowired
    public RegistryClientImpl(WebClient webClient) {
        this.webClient = webClient;
    }

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
