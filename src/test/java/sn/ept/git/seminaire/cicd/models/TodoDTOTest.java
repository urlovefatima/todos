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

    @Test
    void testGettersAndSetters() {
        TodoDTO dto = new TodoDTO();
        dto.setId("id");
        dto.setTitle("title");
        dto.setDescription("desc");
        dto.setDateDebut(java.time.LocalDateTime.now());
        dto.setDateFin(java.time.LocalDateTime.now().plusDays(1));
        dto.setCompleted(true);
        assertEquals("id", dto.getId());
        assertEquals("title", dto.getTitle());
        assertEquals("desc", dto.getDescription());
        assertTrue(dto.isCompleted());
    }

    @Test
    void testEqualsHashCodeToString() {
        TodoDTO dto1 = new TodoDTO();
        dto1.setId("id");
        TodoDTO dto2 = new TodoDTO();
        dto2.setId("id");
        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());
        assertNotNull(dto1.toString());
    }
} 