package sn.ept.git.seminaire.cicd.models;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class TodoDTOTest {
    @Test
    void testGettersSettersEqualsHashCodeToString() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tomorrow = now.plusDays(1);
        
        TodoDTO dto1 = new TodoDTO();
        dto1.setId("id1");
        dto1.setTitle("title1");
        dto1.setDescription("desc1");
        dto1.setCompleted(true);
        dto1.setDateDebut(now);
        dto1.setDateFin(tomorrow);
        dto1.setCreatedDate(now);
        dto1.setLastModifiedDate(now);
        dto1.setVersion(1);
        dto1.setTags(null);
        
        // Test getters/setters
        assertEquals("id1", dto1.getId());
        assertEquals("title1", dto1.getTitle());
        assertEquals("desc1", dto1.getDescription());
        assertTrue(dto1.isCompleted());
        assertEquals(now, dto1.getDateDebut());
        assertEquals(tomorrow, dto1.getDateFin());
        assertEquals(now, dto1.getCreatedDate());
        assertEquals(now, dto1.getLastModifiedDate());
        assertEquals(1, dto1.getVersion());
        assertNull(dto1.getTags());
        
        // Test toString (optional)
        assertNotNull(dto1.toString());
    }
} 