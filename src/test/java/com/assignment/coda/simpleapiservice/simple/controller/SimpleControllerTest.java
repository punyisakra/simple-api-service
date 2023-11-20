package com.assignment.coda.simpleapiservice.simple.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@ExtendWith(SpringExtension.class)
class SimpleControllerTest {

    @InjectMocks
    private SimpleController simpleController;

    @Test
    public void processPayload_validJson_returnSuccess() {
        String payload = "{\"test1\":1, \"test2\":2.0, \"test3\": \"tmp\", \"test4\": []}";

        ResponseEntity<String> response = simpleController.processPayload(payload);

        assertThat(response, notNullValue());
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is(payload));
    }

    @Test
    public void processPayload_invalidJson_returnBadRequest() {
        String payload = "abcd1234";

        ResponseEntity<String> response = simpleController.processPayload(payload);

        assertThat(response, notNullValue());
        assertThat(response.getStatusCode(), is(HttpStatus.BAD_REQUEST));
        assertThat(response.getBody(), is(payload));
    }
}