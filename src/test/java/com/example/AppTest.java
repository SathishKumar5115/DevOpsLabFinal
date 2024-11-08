// src/test/java/com/example/AppTest.java
package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void testGetMessage() {
        assertEquals("Hello, Jenkins Pipeline! v3", App.getMessage());
    }
}
