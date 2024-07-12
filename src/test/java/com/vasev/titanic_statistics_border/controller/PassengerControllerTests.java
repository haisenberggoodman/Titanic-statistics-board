package com.vasev.titanic_statistics_border.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PassengerControllerTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetAllPassengers() {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/passengers", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    }

    @Test
    public void testGetPassengerStats() {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/passengers/stats", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    }
}