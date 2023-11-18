package com.assignment.coda.simpleapiservice.service;

import com.assignment.coda.simpleapiservice.model.Instance;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistryServiceImpl implements RegistryService {

    private final Logger logger = LoggerFactory.getLogger(RegistryServiceImpl.class);

    private RegistryClient registryClient;

    @Autowired
    public RegistryServiceImpl(RegistryClient registryClient) {
        this.registryClient = registryClient;
    }

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