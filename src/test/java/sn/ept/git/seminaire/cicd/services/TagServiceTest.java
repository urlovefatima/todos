package sn.ept.git.seminaire.cicd.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import sn.ept.git.seminaire.cicd.data.TagDTOTestData;
import sn.ept.git.seminaire.cicd.entities.Tag;
import sn.ept.git.seminaire.cicd.exceptions.ItemExistsException;
import sn.ept.git.seminaire.cicd.exceptions.ItemNotFoundException;
import sn.ept.git.seminaire.cicd.mappers.TagMapper;
import sn.ept.git.seminaire.cicd.models.TagDTO;
import sn.ept.git.seminaire.cicd.repositories.TagRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TagServiceTest {
    @Mock
    TagRepository repository;
    @Mock
    TagMapper mapper;
    @InjectMocks
    TagService service;

    TagDTO dto;
    Tag entity;

    @BeforeEach
    void setUp() {
        dto = TagDTOTestData.defaultDTO();
        entity = new Tag();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
    }

    @Test
    void save_shouldSaveAndReturnDTO() {
        given(repository.findByName(dto.getName())).willReturn(Optional.empty());
        given(mapper.toEntity(any(TagDTO.class))).willReturn(entity);
        given(repository.saveAndFlush(entity)).willReturn(entity);
        given(mapper.toDTO(entity)).willReturn(dto);
        TagDTO result = service.save(dto);
        assertThat(result).isEqualTo(dto);
        verify(repository).findByName(dto.getName());
        verify(repository).saveAndFlush(entity);
    }

    @Test
    void save_shouldThrowIfNameExists() {
        given(repository.findByName(dto.getName())).willReturn(Optional.of(entity));
        assertThatThrownBy(() -> service.save(dto)).isInstanceOf(ItemExistsException.class);
    }

    @Test
    void delete_shouldDeleteIfExists() {
        given(repository.findById(dto.getId())).willReturn(Optional.of(entity));
        service.delete(dto.getId());
        verify(repository).deleteById(dto.getId());
    }

    @Test
    void delete_shouldThrowIfNotFound() {
        given(repository.findById(dto.getId())).willReturn(Optional.empty());
        assertThatThrownBy(() -> service.delete(dto.getId())).isInstanceOf(ItemNotFoundException.class);
    }

    @Test
    void findById_shouldReturnDTOIfExists() {
        given(repository.findById(dto.getId())).willReturn(Optional.of(entity));
        given(mapper.toDTO(entity)).willReturn(dto);
        TagDTO result = service.findById(dto.getId());
        assertThat(result).isEqualTo(dto);
    }

    @Test
    void findById_shouldThrowIfNotFound() {
        given(repository.findById(dto.getId())).willReturn(Optional.empty());
        assertThatThrownBy(() -> service.findById(dto.getId())).isInstanceOf(ItemNotFoundException.class);
    }

    @Test
    void findAll_shouldReturnPageOfDTOs() {
        Page<Tag> page = new PageImpl<>(List.of(entity));
        Page<TagDTO> dtoPage = new PageImpl<>(List.of(dto));
        given(repository.findAll(any(PageRequest.class))).willReturn(page);
        given(mapper.toDTO(any(Tag.class))).willReturn(dto);
        Page<TagDTO> result = service.findAll(PageRequest.of(0, 10));
        assertThat(result.getContent()).containsExactly(dto);
    }

    @Test
    void update_shouldUpdateAndReturnDTO() {
        TagDTO updated = TagDTOTestData.updatedDTO();
        Tag updatedEntity = new Tag();
        updatedEntity.setId(updated.getId());
        updatedEntity.setName(updated.getName());
        given(repository.findById(updated.getId())).willReturn(Optional.of(entity));
        given(repository.findByNameWithIdNotEquals(updated.getName(), updated.getId())).willReturn(Optional.empty());
        given(repository.saveAndFlush(any(Tag.class))).willReturn(updatedEntity);
        given(mapper.toDTO(updatedEntity)).willReturn(updated);
        TagDTO result = service.update(updated.getId(), updated);
        assertThat(result).isEqualTo(updated);
    }

    @Test
    void update_shouldThrowIfNotFound() {
        TagDTO updated = TagDTOTestData.updatedDTO();
        given(repository.findById(updated.getId())).willReturn(Optional.empty());
        assertThatThrownBy(() -> service.update(updated.getId(), updated)).isInstanceOf(ItemNotFoundException.class);
    }

    @Test
    void update_shouldThrowIfNameExists() {
        TagDTO updated = TagDTOTestData.updatedDTO();
        given(repository.findById(updated.getId())).willReturn(Optional.of(entity));
        given(repository.findByNameWithIdNotEquals(updated.getName(), updated.getId())).willReturn(Optional.of(entity));
        assertThatThrownBy(() -> service.update(updated.getId(), updated)).isInstanceOf(ItemExistsException.class);
    }

    @Test
    void deleteAll_shouldCallRepository() {
        service.deleteAll();
        verify(repository).deleteAll();
    }
} 