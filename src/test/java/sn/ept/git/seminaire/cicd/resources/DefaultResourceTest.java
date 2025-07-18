package sn.ept.git.seminaire.cicd.resources;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

class DefaultResourceTest {
    @Test
    void testIndex() {
        DefaultResource resource = new DefaultResource();
        ResponseEntity<String> response = resource.index();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(DefaultResource.WELCOME_MSG, response.getBody());
    }
    @Test
    void testHealth() {
        DefaultResource resource = new DefaultResource();
        ResponseEntity<String> response = resource.health();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(DefaultResource.HEALTH_MSG, response.getBody());
    }
}