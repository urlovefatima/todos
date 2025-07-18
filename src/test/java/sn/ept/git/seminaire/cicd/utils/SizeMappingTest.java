package sn.ept.git.seminaire.cicd.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SizeMappingTest {
    @Test
    void testPrivateConstructor() throws Exception {
        java.lang.reflect.Constructor<?> constructor = SizeMapping.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        constructor.newInstance();
    }
    // Ajouter ici des tests pour chaque classe interne statique de SizeMapping
} 