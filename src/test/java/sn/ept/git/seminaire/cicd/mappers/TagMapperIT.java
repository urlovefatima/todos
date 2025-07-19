package sn.ept.git.seminaire.cicd.mappers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sn.ept.git.seminaire.cicd.entities.Tag;
import sn.ept.git.seminaire.cicd.models.TagDTO;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TagMapperIT {
    @Autowired
    TagMapper mapper;

    @Test
    void testSpringBeanIsInstrumented() {
        TagDTO dto = new TagDTO();
        dto.setId("id");
        dto.setName("name");
        Tag entity = mapper.toEntity(dto);
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getName(), entity.getName());
    }
} 