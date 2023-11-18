package com.assignment.coda.simpleapiservice.event;

import com.assignment.coda.simpleapiservice.service.RegistryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith({SpringExtension.class})
class ApplicationEventHandlerTest {

    @Mock
    private RegistryService registryServiceMock;

    @Mock
    private ServletWebServerInitializedEvent eventMock;

    @Mock
    private WebServer webServerMock;

    @InjectMocks
    private ApplicationEventHandler handler;

    @Test
    public void onApplicationEvent_getThePortAndRegisterWithRegistryService() {
        int port = 1234;

        when(eventMock.getWebServer()).thenReturn(webServerMock);
        when(webServerMock.getPort()).thenReturn(port);
        handler.onApplicationEvent(eventMock);

        Mockito.verify(registryServiceMock, times(1)).register(any(), eq(port));
    }
}