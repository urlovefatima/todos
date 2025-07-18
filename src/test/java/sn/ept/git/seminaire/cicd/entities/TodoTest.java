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
} 