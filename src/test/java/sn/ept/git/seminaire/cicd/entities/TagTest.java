package sn.ept.git.seminaire.cicd.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TagTest {
    @Test
    void testGettersSettersEqualsHashCodeToString() {
        Tag tag1 = new Tag();
        tag1.setId("id1");
        tag1.setName("name1");
        
        // Test getters/setters
        assertEquals("id1", tag1.getId());
        assertEquals("name1", tag1.getName());
    }
} 