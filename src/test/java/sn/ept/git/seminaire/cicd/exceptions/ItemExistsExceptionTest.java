package sn.ept.git.seminaire.cicd.exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemExistsExceptionTest {
    @Test
    void testConstructor() {
        ItemExistsException ex = new ItemExistsException("message");
        assertEquals("message", ex.getMessage());
    }
} 