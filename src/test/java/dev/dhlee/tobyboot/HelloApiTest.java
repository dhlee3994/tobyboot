package dev.dhlee.tobyboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class HelloApiTest {

    @Test
    void helloApi() {
        TestRestTemplate restTemplate = new TestRestTemplate();

        ResponseEntity<String> response =
                restTemplate.getForEntity("http://localhost:8080/hello?name={name}", String.class, "Spring");

        // status code 200
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // header(Content-type) text/plain
        assertTrue(response.getHeaders()
                .getFirst(HttpHeaders.CONTENT_TYPE)
                .startsWith(MediaType.TEXT_PLAIN_VALUE));

        // body Hello Spring
        assertEquals("*Hello Spring*", response.getBody());
    }

    @Test
    void failsHelloApi() {
        TestRestTemplate restTemplate = new TestRestTemplate();

        ResponseEntity<String> response =
                restTemplate.getForEntity("http://localhost:8080/hello?name=", String.class);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
}
