package sn.ept.git.seminaire.cicd.validators;

import org.junit.jupiter.api.Test;
import sn.ept.git.seminaire.cicd.models.TodoDTO;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class DateRangeValidatorTest {
    @Test
    void testIsValid() {
        DateRangeValidator validator = new DateRangeValidator();
        TodoDTO valid = new TodoDTO();
        valid.setDateDebut(LocalDateTime.now());
        valid.setDateFin(LocalDateTime.now().plusDays(1));
        assertTrue(validator.isValid(valid, null));
        TodoDTO invalid1 = new TodoDTO();
        invalid1.setDateDebut(null);
        invalid1.setDateFin(LocalDateTime.now());
        assertFalse(validator.isValid(invalid1, null));
        TodoDTO invalid2 = new TodoDTO();
        invalid2.setDateDebut(LocalDateTime.now());
        invalid2.setDateFin(null);
        assertFalse(validator.isValid(invalid2, null));
        TodoDTO invalid3 = new TodoDTO();
        invalid3.setDateDebut(LocalDateTime.now().plusDays(1));
        invalid3.setDateFin(LocalDateTime.now());
        assertFalse(validator.isValid(invalid3, null));
        assertFalse(validator.isValid(null, null));
    }
} 