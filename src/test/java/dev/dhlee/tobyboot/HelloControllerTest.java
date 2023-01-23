package dev.dhlee.tobyboot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HelloControllerTest {

    @Test
    void helloController() {
        HelloController helloController = new HelloController(name -> name);

        String ret = helloController.hello("Test");

        assertEquals("Test", ret);
    }

    @Test
    void failsHelloController() {
        HelloController helloController = new HelloController(name -> name);

        assertThrows(IllegalArgumentException.class, () -> helloController.hello(null));
        assertThrows(IllegalArgumentException.class, () -> helloController.hello(""));
    }
}
