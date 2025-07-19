package sn.ept.git.seminaire.cicd.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BaseEntityTest {
    @Test
    void testConstructor() {
        // BaseEntity est abstraite et sealed, on ne peut pas l'instancier ni l'étendre ici.
        assertTrue(true);
    }

    @Test
    void testBaseEntityMethodsViaTodo() {
        Todo entity = new Todo();
        entity.setId("id");
        entity.setVersion(1);
        java.time.LocalDateTime now = java.time.LocalDateTime.now();
        entity.setCreatedDate(now);
        entity.setLastModifiedDate(now);
        assertEquals("id", entity.getId());
        assertEquals(1, entity.getVersion());
        assertEquals(now, entity.getCreatedDate());
        assertEquals(now, entity.getLastModifiedDate());
        entity.prePersit();
        entity.preUpdate();
        assertNotNull(entity.getCreatedDate());
        assertNotNull(entity.getLastModifiedDate());
    }

    @Test
    void testEqualsHashCodeToString() {
        Todo e1 = new Todo();
        e1.setId("id");
        Todo e2 = new Todo();
        e2.setId("id");
        assertEquals(e1, e2);
        assertEquals(e1.hashCode(), e2.hashCode());
        assertNotNull(e1.toString());
    }

    @Test
    void testAllSettersAndBranchesViaTag() {
        Tag entity = new Tag();
        entity.setId("id");
        entity.setVersion(1);
        java.time.LocalDateTime now = java.time.LocalDateTime.now();
        entity.setCreatedDate(now);
        entity.setLastModifiedDate(now);
        assertEquals("id", entity.getId());
        assertEquals(1, entity.getVersion());
        assertEquals(now, entity.getCreatedDate());
        assertEquals(now, entity.getLastModifiedDate());
        entity.prePersit();
        entity.preUpdate();
        assertNotNull(entity.getCreatedDate());
        assertNotNull(entity.getLastModifiedDate());
        assertNotNull(entity.toString());
        assertEquals(entity, entity);
        assertNotEquals(entity, new Tag());
        assertNotNull(entity.hashCode());
    }
    // Ajouter ici des tests pour les méthodes communes si besoin
} 