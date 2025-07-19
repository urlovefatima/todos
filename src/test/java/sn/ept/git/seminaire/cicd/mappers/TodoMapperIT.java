package sn.ept.git.seminaire.cicd.mappers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sn.ept.git.seminaire.cicd.entities.Todo;
import sn.ept.git.seminaire.cicd.models.TodoDTO;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TodoMapperIT {
    @Autowired
    TodoMapper mapper;

    @Test
    void testSpringBeanIsInstrumented() {
        TodoDTO dto = new TodoDTO();
        dto.setId("id");
        dto.setTitle("title");
        Todo entity = mapper.toEntity(dto);
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getTitle(), entity.getTitle());
    }
} 