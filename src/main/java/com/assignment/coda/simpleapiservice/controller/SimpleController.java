package com.assignment.coda.simpleapiservice.controller;

import com.assignment.coda.simpleapiservice.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    private final Logger logger = LoggerFactory.getLogger(SimpleController.class);

    @RequestMapping(
            value = "/simples",
            method = RequestMethod.POST,
            consumes = "text/plain")
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
