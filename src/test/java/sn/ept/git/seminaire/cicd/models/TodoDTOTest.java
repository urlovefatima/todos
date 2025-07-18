package sn.ept.git.seminaire.cicd.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TodoDTOTest {
    @Test
    void testConstructor() {
        assertDoesNotThrow(() -> new TodoDTO());
    }
    // Ajouter ici des tests pour les getters/setters si besoin
} 