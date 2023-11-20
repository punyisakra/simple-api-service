package com.assignment.coda.simpleapiservice.registry.service;

import com.assignment.coda.simpleapiservice.registry.dto.Instance;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * A service class providing an implementation to {@link RegistryService}
 * to handle registry's call logic
 */
@Service
public class RegistryServiceImpl implements RegistryService {

    private final Logger logger = LoggerFactory.getLogger(RegistryServiceImpl.class);

    private RegistryClient registryClient;

    @Autowired
    public RegistryServiceImpl(RegistryClient registryClient) {
        this.registryClient = registryClient;
    }

    /**
     * Register the application's name and port number with the registry-service.
     * If the name and/or the port number is blank then the registry process is skipped.
     * @param name a {@link String} represented the running application's name
     * @param port a port number of the running application
     */
    @Override
    public void register(String name, int port) {
        if (Strings.isBlank(name) || port == 0) {
            logger.warn("Invalid instance name and/or port number. "
                    + "Cannot register with the registry-service with name:{}, port:{}", name, port);
            return;
        }

        Instance instance = new Instance(name, String.valueOf(port));
        registryClient.register(instance).subscribe(result -> {
           if (result.equals("success")) {
               logger.info("Register success");
           }
           else {
               logger.info("Register failed from registry-service");
           }
        });
    }
}