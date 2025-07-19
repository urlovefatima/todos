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
        
        TagDTO dto3 = new TagDTO();
        dto3.setId("id1");
        dto3.setName("name1");
        dto3.setCreatedDate(now);
        dto3.setLastModifiedDate(now);
        dto3.setVersion(1);
        assertEquals(dto1, dto3);
        assertEquals(dto1.hashCode(), dto3.hashCode());
        assertNotNull(dto1.toString());
    }

    @Test
    void testAllSettersAndBranches() {
        TagDTO dto = new TagDTO();
        dto.setId("id");
        dto.setName("name");
        assertEquals("id", dto.getId());
        assertEquals("name", dto.getName());
        assertNotNull(dto.toString());
        assertEquals(dto, dto);
        assertNotEquals(dto, new TagDTO());
        assertNotNull(dto.hashCode());
    }
} 