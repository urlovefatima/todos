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

        Tag tag2 = new Tag();
        tag2.setId("id1");
        tag2.setName("name1");
        assertEquals(tag1, tag2);
        assertEquals(tag1.hashCode(), tag2.hashCode());
        assertNotNull(tag1.toString());
    }

    @Test
    void testAllSettersAndBranches() {
        Tag tag = new Tag();
        tag.setId("id");
        tag.setName("name");
        tag.setTodos(new java.util.HashSet<>());
        assertEquals("id", tag.getId());
        assertEquals("name", tag.getName());
        assertNotNull(tag.getTodos());
        assertNotNull(tag.toString());
        assertEquals(tag, tag);
        assertNotEquals(tag, new Tag());
        assertNotNull(tag.hashCode());
    }
} 