package sn.ept.git.seminaire.cicd.exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemNotFoundExceptionTest {
    @Test
    void testConstructor() {
        ItemNotFoundException ex = new ItemNotFoundException("message");
        assertEquals("message", ex.getMessage());
    }
} 