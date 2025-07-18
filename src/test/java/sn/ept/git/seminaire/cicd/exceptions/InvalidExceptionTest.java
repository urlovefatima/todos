package sn.ept.git.seminaire.cicd.exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InvalidExceptionTest {
    @Test
    void testConstructor() {
        InvalidException ex = new InvalidException("message");
        assertEquals("message", ex.getMessage());
    }
} 