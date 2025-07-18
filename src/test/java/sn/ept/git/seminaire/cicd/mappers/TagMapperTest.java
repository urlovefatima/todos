package sn.ept.git.seminaire.cicd.mappers;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import sn.ept.git.seminaire.cicd.entities.Tag;
import sn.ept.git.seminaire.cicd.models.TagDTO;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TagMapperTest {
    TagMapper mapper = Mappers.getMapper(TagMapper.class);

    @Test
    void testToEntityAndToDTO() {
        TagDTO dto = new TagDTO();
        dto.setId("id");
        dto.setName("name");
        Tag entity = mapper.toEntity(dto);
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getName(), entity.getName());
        TagDTO dto2 = mapper.toDTO(entity);
        assertEquals(entity.getId(), dto2.getId());
        assertEquals(entity.getName(), dto2.getName());
    }

    @Test
    void testNullAndEmptyList() {
        assertNull(mapper.toEntity((TagDTO) null));
        assertNull(mapper.toDTO((Tag) null));
        assertTrue(mapper.toDTOlist((List<Tag>) null).isEmpty());
        assertTrue(mapper.toDTOlist(Collections.emptyList()).isEmpty());
    }
} 