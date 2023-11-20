package com.assignment.coda.simpleapiservice.registry.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * Represent a running application instance, used for
 * registering its name and port with the registry-service
 * */
@Component
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class Instance {
    /**
     * Name of the running instance
     */
    private String name;

    /**
     * Port of the running instance
     */
    private String port;
}
