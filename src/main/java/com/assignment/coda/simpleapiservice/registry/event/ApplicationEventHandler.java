package com.assignment.coda.simpleapiservice.registry.event;

import com.assignment.coda.simpleapiservice.registry.service.RegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ApplicationEventHandler {

    private RegistryService registryService;

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    public ApplicationEventHandler(RegistryService registryService) {
        this.registryService = registryService;
    }

    @EventListener
    public void onApplicationEvent(final ServletWebServerInitializedEvent event) {
        int port = event.getWebServer().getPort();
        registryService.register(applicationName, port);
    }
}
