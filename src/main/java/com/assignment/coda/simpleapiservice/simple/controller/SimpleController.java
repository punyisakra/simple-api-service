package com.assignment.coda.simpleapiservice.simple.controller;

import com.assignment.coda.simpleapiservice.simple.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple API Controller for handle simple HTTP request
 * */
@RestController
public class SimpleController {

    private final Logger logger = LoggerFactory.getLogger(SimpleController.class);

    /**
     * Simple POST API: accept json payload and return the exact copy of it.
     * Will return {@link org.springframework.http.HttpStatus HttpStatus} 400: Bad Request if
     * the input payload is an invalid json
     *
     * @param payload   the json payload of type {@link String}
     * @return the exact copy of the input payload, wrapped with HttpStatus
     * */
    @RequestMapping(
            value = "/simples",
            method = RequestMethod.POST,
            consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> processPayload(@RequestBody String payload) {
        logger.info("{} /simples, REQUEST PAYLOAD: {}", RequestMethod.POST, payload);
        ResponseEntity<String> response;
        response = JsonUtils.isValid(payload)
                ? ResponseEntity.ok(payload)
                : ResponseEntity.badRequest().body(payload);
        logger.info("RESPONSE: {}", response.getStatusCode());
        return response;
    }
}
