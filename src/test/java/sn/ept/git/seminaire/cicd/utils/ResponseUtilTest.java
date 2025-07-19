package sn.ept.git.seminaire.cicd.utils;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

class ResponseUtilTest {
    @Test
    void testPrivateConstructor() throws Exception {
        Constructor<ResponseUtil> constructor = ResponseUtil.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        constructor.newInstance(); // Doit juste passer sans exception
    }

    // Ajoute ici un test pour chaque méthode statique de ResponseUtil si elle existe
    // Exemple :
    // @Test
    // void testSomeStaticMethod() {
    //     assertNotNull(ResponseUtil.someStaticMethod(...));
    // }

    @Test
    void testWrapOrNotFoundPresent() {
        Optional<String> opt = Optional.of("data");
        ResponseEntity<String> response = ResponseUtil.wrapOrNotFound(opt);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("data", response.getBody());
    }

    @Test
    void testWrapOrNotFoundAbsent() {
        Optional<String> opt = Optional.empty();
        assertThrows(ResponseStatusException.class, () -> ResponseUtil.wrapOrNotFound(opt));
    }

    @Test
    void testWrapOrNotFoundWithStatus() {
        Optional<String> opt = Optional.of("data");
        ResponseEntity<String> response = ResponseUtil.wrapOrNotFound(opt, HttpStatus.CREATED);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("data", response.getBody());
    }

    @Test
    void testWrapOrNotFoundWithStatusAndReason() {
        Optional<String> opt = Optional.of("data");
        ResponseEntity<String> response = ResponseUtil.wrapOrNotFound(opt, HttpStatus.ACCEPTED, "reason");
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals("data", response.getBody());
    }

    @Test
    void testWrapOrNotFoundWithReason() {
        Optional<String> opt = Optional.of("data");
        ResponseEntity<String> response = ResponseUtil.wrapOrNotFound(opt, "reason");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("data", response.getBody());
    }

    @Test
    void testWrapOrNotFoundWithHeaderAndStatus() {
        Optional<String> opt = Optional.of("data");
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Test", "test");
        ResponseEntity<String> response = ResponseUtil.wrapOrNotFound(opt, headers, HttpStatus.ACCEPTED);
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals("test", response.getHeaders().getFirst("X-Test"));
        assertEquals("data", response.getBody());
    }

    @Test
    void testWrapOrNotFoundWithHeaderStatusReason() {
        Optional<String> opt = Optional.of("data");
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Test", "test");
        ResponseEntity<String> response = ResponseUtil.wrapOrNotFound(opt, headers, HttpStatus.ACCEPTED, "reason");
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals("test", response.getHeaders().getFirst("X-Test"));
        assertEquals("data", response.getBody());
    }

    @Test
    void testWrapOrNotFoundAbsentWithHeaderStatusReason() {
        Optional<String> opt = Optional.empty();
        HttpHeaders headers = new HttpHeaders();
        assertThrows(ResponseStatusException.class, () -> ResponseUtil.wrapOrNotFound(opt, headers, HttpStatus.ACCEPTED, "reason"));
    }
} 