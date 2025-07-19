package sn.ept.git.seminaire.cicd.resources;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DefaultResource.class)
class DefaultResourceIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void indexEndpointShouldReturnWelcomeMsg() throws Exception {
        mockMvc.perform(get("/cicd/api/"))
                .andExpect(status().isOk())
                .andExpect(content().string(DefaultResource.WELCOME_MSG));
    }

    @Test
    void healthEndpointShouldReturnUp() throws Exception {
        mockMvc.perform(get("/cicd/api/health"))
                .andExpect(status().isOk())
                .andExpect(content().string(DefaultResource.HEALTH_MSG));
    }
} 