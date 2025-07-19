package sn.ept.git.seminaire.cicd.utils;

import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import static org.junit.jupiter.api.Assertions.*;

class ConstantesTest {
    @Test
    void testPrivateConstructor() throws Exception {
        java.lang.reflect.Constructor<?> constructor = Constantes.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        InvocationTargetException ex = assertThrows(InvocationTargetException.class, constructor::newInstance);
        assertTrue(ex.getCause() instanceof UnsupportedOperationException);
    }

    @Test
    void testAllConstantes() {
        assertNotNull(Constantes.SYSTEM_NAME);
        assertNotNull(Constantes.SYSTEM_ID);
        assertNotNull(Constantes.TYPE_VALIDATION);
        assertNotNull(Constantes.TYPE_SYSTEM);
        assertNotNull(Constantes.TYPE_PERMISSION);
    }
} 