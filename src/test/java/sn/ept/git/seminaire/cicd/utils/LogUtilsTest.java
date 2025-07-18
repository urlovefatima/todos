package sn.ept.git.seminaire.cicd.utils;

import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import static org.junit.jupiter.api.Assertions.*;

class LogUtilsTest {
    @Test
    void testPrivateConstructor() throws Exception {
        java.lang.reflect.Constructor<?> constructor = LogUtils.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        InvocationTargetException ex = assertThrows(InvocationTargetException.class, constructor::newInstance);
        assertTrue(ex.getCause() instanceof UnsupportedOperationException);
    }
    // Ajouter ici des tests pour chaque méthode statique de LogUtils
} 