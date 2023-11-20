package com.assignment.coda.simpleapiservice.registry.event;

import com.assignment.coda.simpleapiservice.registry.service.RegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Handle application event to retrieve web server information
 */
@Service
public class ApplicationEventHandler {

    private RegistryService registryService;

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    public ApplicationEventHandler(RegistryService registryService) {
        this.registryService = registryService;
    }

    /**
     * Retrieve running port number and register the application with registry-service
     * @param event a {@link ServletWebServerInitializedEvent} generated after initialize
     *              the web server. It holds {@link org.springframework.boot.web.server.WebServer}
     *              information such as the running port number
     */
    @EventListener
    public void onApplicationEvent(final ServletWebServerInitializedEvent event) {
        int port = event.getWebServer().getPort();
        registryService.register(applicationName, port);
    }
}
