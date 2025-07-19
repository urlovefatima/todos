package sn.ept.git.seminaire.cicd.entities;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class TodoTest {
    @Test
    void testGettersSettersEqualsHashCodeToString() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tomorrow = now.plusDays(1);
        Todo todo1 = new Todo();
        todo1.setId("id1");
        todo1.setTitle("title1");
        todo1.setDescription("desc1");
        todo1.setCompleted(true);
        todo1.setDateDebut(now);
        todo1.setDateFin(tomorrow);
        
        // Test getters/setters
        assertEquals("id1", todo1.getId());
        assertEquals("title1", todo1.getTitle());
        assertEquals("desc1", todo1.getDescription());
        assertTrue(todo1.isCompleted());
        assertEquals(now, todo1.getDateDebut());
        assertEquals(tomorrow, todo1.getDateFin());
    }

    @Test
    void testGettersAndSetters() {
        Todo todo = new Todo();
        todo.setId("id");
        todo.setTitle("title");
        todo.setDescription("desc");
        todo.setDateDebut(java.time.LocalDateTime.now());
        todo.setDateFin(java.time.LocalDateTime.now().plusDays(1));
        todo.setCompleted(true);
        assertEquals("id", todo.getId());
        assertEquals("title", todo.getTitle());
        assertEquals("desc", todo.getDescription());
        assertTrue(todo.isCompleted());
    }

    @Test
    void testEqualsHashCodeToString() {
        Todo todo1 = new Todo();
        todo1.setId("id");
        Todo todo2 = new Todo();
        todo2.setId("id");
        assertEquals(todo1, todo2);
        assertEquals(todo1.hashCode(), todo2.hashCode());
        assertNotNull(todo1.toString());
    }
} 