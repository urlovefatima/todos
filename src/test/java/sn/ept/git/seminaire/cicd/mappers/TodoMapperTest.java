package sn.ept.git.seminaire.cicd.mappers;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import sn.ept.git.seminaire.cicd.entities.Todo;
import sn.ept.git.seminaire.cicd.models.TodoDTO;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TodoMapperTest {
    TodoMapper mapper = Mappers.getMapper(TodoMapper.class);

    @Test
    void testToEntityAndToDTO() {
        TodoDTO dto = new TodoDTO();
        dto.setId("id");
        dto.setTitle("title");
        Todo entity = mapper.toEntity(dto);
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getTitle(), entity.getTitle());
        TodoDTO dto2 = mapper.toDTO(entity);
        assertEquals(entity.getId(), dto2.getId());
        assertEquals(entity.getTitle(), dto2.getTitle());
    }

    @Test
    void testNullAndEmptyList() {
        assertNull(mapper.toEntity((TodoDTO) null));
        assertNull(mapper.toDTO((Todo) null));
        assertTrue(mapper.toDTOlist((List<Todo>) null).isEmpty());
        assertTrue(mapper.toDTOlist(Collections.emptyList()).isEmpty());
    }
} 