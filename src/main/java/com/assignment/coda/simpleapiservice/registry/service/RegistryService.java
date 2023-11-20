package com.assignment.coda.simpleapiservice.registry.service;

/**
 * A service interface implemented by {@link RegistryServiceImpl}
 * to handle registry's call logic
 */
public interface RegistryService {

    /**
     * Register the application's name and port number with the registry-service.
     * If the name and/or the port number is blank then the registry process is skipped.
     * @param name a {@link String} represented the running application's name
     * @param port a port number of the running application
     */
    void register(String name, int port);
}
