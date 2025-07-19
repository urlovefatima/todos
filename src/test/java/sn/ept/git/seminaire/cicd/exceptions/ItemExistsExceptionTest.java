package sn.ept.git.seminaire.cicd.exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemExistsExceptionTest {
    @Test
    void testConstructor() {
        ItemExistsException ex = new ItemExistsException("message");
        assertEquals("message", ex.getMessage());
    }

    @Test
    void testConstructorsAndFormat() {
        ItemExistsException ex1 = new ItemExistsException();
        ItemExistsException ex2 = new ItemExistsException("msg");
        assertNotNull(ItemExistsException.format("template %s", "arg"));
    }

    @Test
    void testToStringAndHashCode() {
        ItemExistsException ex = new ItemExistsException("msg");
        assertNotNull(ex.toString());
        assertNotNull(ex.hashCode());
        assertEquals("msg", ex.getMessage());
    }
} 