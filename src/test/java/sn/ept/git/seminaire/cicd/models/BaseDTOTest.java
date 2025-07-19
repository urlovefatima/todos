package sn.ept.git.seminaire.cicd.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BaseDTOTest {
    @Test
    void testConstructor() {
        assertDoesNotThrow(() -> new BaseDTO());
    }
    @Test
    void testGettersAndSetters() {
        BaseDTO dto = new BaseDTO();
        dto.setId("id");
        assertEquals("id", dto.getId());
    }
    @Test
    void testEqualsHashCodeToString() {
        BaseDTO dto1 = new BaseDTO();
        dto1.setId("id");
        BaseDTO dto2 = new BaseDTO();
        dto2.setId("id");
        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());
        assertNotNull(dto1.toString());
    }
    // Ajouter ici des tests pour les getters/setters si besoin
} 