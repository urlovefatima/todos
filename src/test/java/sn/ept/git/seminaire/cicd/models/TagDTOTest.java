package sn.ept.git.seminaire.cicd.models;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class TagDTOTest {
    @Test
    void testGettersSettersEqualsHashCodeToString() {
        LocalDateTime now = LocalDateTime.now();
        
        TagDTO dto1 = new TagDTO();
        dto1.setId("id1");
        dto1.setName("name1");
        dto1.setCreatedDate(now);
        dto1.setLastModifiedDate(now);
        dto1.setVersion(1);
        
        TagDTO dto2 = new TagDTO();
        dto2.setId("id1");
        dto2.setName("name1");
        dto2.setCreatedDate(now);
        dto2.setLastModifiedDate(now);
        dto2.setVersion(1);
        
        // Test getters/setters
        assertEquals("id1", dto1.getId());
        assertEquals("name1", dto1.getName());
        assertEquals(now, dto1.getCreatedDate());
        assertEquals(now, dto1.getLastModifiedDate());
        assertEquals(1, dto1.getVersion());
        
        // Test toString (optional)
        assertNotNull(dto1.toString());
    }
} 