package sn.ept.git.seminaire.cicd.validators;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DateRangeValidatorTest {
    @Test
    void testConstructor() {
        assertDoesNotThrow(() -> new DateRangeValidator());
    }
    // Ajouter ici des tests pour la méthode isValid si besoin
} 