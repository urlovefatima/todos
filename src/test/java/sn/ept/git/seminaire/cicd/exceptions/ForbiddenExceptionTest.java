package sn.ept.git.seminaire.cicd.exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ForbiddenExceptionTest {
    @Test
    void testConstructor() {
        ForbiddenException ex = new ForbiddenException("message");
        assertEquals("message", ex.getMessage());
    }
} 