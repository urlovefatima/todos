package sn.ept.git.seminaire.cicd.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ResponseUtilTest {
    @Test
    void testPrivateConstructor() throws Exception {
        java.lang.reflect.Constructor<?> constructor = ResponseUtil.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        constructor.newInstance();
    }
    // Ajouter ici des tests pour chaque méthode statique de ResponseUtil
} 