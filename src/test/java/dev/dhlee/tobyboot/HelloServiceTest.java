package dev.dhlee.tobyboot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloServiceTest {

    @Test
    void simpleHelloService() {
        SimpleHelloService simpleHelloService = new SimpleHelloService();

        String ret = simpleHelloService.sayHello("Test");

        assertEquals("Hello Test", ret);
    }

    @Test
    void helloDecorator() {
        final HelloDecorator decorator = new HelloDecorator(name -> name);

        final String ret = decorator.sayHello("Test");

        assertEquals("*Test*", ret);
    }
}