package sn.ept.git.seminaire.cicd.exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemNotFoundExceptionTest {
    @Test
    void testConstructor() {
        ItemNotFoundException ex = new ItemNotFoundException("message");
        assertEquals("message", ex.getMessage());
    }
    @Test
    void testDefaultConstructor() {
        ItemNotFoundException ex = new ItemNotFoundException();
        assertNotNull(ex.getMessage());
    }
    @Test
    void testFormat() {
        String formatted = ItemNotFoundException.format("Not found: %s", "test");
        assertEquals("Not found: test", formatted);
    }
} 