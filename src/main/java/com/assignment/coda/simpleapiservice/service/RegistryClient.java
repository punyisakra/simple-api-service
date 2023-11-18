package com.assignment.coda.simpleapiservice.service;

import com.assignment.coda.simpleapiservice.model.Instance;
import reactor.core.publisher.Mono;

public interface RegistryClient {

    Mono<String> register(Instance instance);
}
