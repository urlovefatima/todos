package sn.ept.git.seminaire.cicd.utils;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import static org.junit.jupiter.api.Assertions.*;

class LogUtilsTest {
    @Test
    void testPrivateConstructor() throws Exception {
        Constructor<LogUtils> constructor = LogUtils.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        InvocationTargetException thrown = assertThrows(InvocationTargetException.class, constructor::newInstance);
        assertTrue(thrown.getCause() instanceof UnsupportedOperationException);
    }
    @Test
    void testLogStartConstant() {
        assertNotNull(LogUtils.LOG_START);
    }
} 