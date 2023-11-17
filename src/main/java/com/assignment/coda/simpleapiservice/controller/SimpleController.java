package com.assignment.coda.simpleapiservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class SimpleController {

    private final Logger logger = LoggerFactory.getLogger(SimpleController.class);

    @RequestMapping(
            value = "/simples",
            method = RequestMethod.POST,
            consumes = "text/plain")
    public String processPayload (@RequestBody String payload) {
        logger.info(payload);
        return payload;
    }
}
