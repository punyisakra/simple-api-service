package com.assignment.coda.simpleapiservice.registry.service;

import com.assignment.coda.simpleapiservice.registry.model.Instance;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.argThat;

@ExtendWith(SpringExtension.class)
class RegistryServiceTest {

    @Mock
    private RegistryClient registryClientMock;

    @InjectMocks
    private RegistryServiceImpl registryService;

    @Test
    void register_validNameAndPort_callRegistryClient() {
        String name = "tmp-name";
        int port = 1234;

        Mockito.when(registryClientMock.register(Mockito.any(Instance.class))).thenReturn(Mono.just("success"));
        registryService.register(name, port);

        Mockito.verify(registryClientMock, Mockito.times(1))
                .register(argThat(i -> i.getPort().equals(String.valueOf(port)) && i.getName().equals(name)));
    }

    @Test
    void register_invalidName_callRegistryClient() {
        String name = "";
        int port = 1234;

        Mockito.when(registryClientMock.register(Mockito.any(Instance.class))).thenReturn(Mono.just("failed"));
        registryService.register(name, port);

        Mockito.verify(registryClientMock, Mockito.times(0))
                .register(argThat(i -> i.getPort().equals(String.valueOf(port)) && i.getName().equals(name)));
    }

    @Test
    void register_invalidPort_callRegistryClient() {
        String name = "name";
        int port = 0;

        Mockito.when(registryClientMock.register(Mockito.any(Instance.class))).thenReturn(Mono.just("failed"));
        registryService.register(name, port);

        Mockito.verify(registryClientMock, Mockito.times(0))
                .register(argThat(i -> i.getPort().equals(String.valueOf(port)) && i.getName().equals(name)));
    }
}