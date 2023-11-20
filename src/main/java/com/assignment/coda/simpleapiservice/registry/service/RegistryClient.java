package com.assignment.coda.simpleapiservice.registry.service;

import com.assignment.coda.simpleapiservice.registry.model.Instance;
import reactor.core.publisher.Mono;

public interface RegistryClient {

    Mono<String> register(Instance instance);
}
