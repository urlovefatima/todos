package sn.ept.git.seminaire.cicd.resources;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import sn.ept.git.seminaire.cicd.data.TagDTOTestData;
import sn.ept.git.seminaire.cicd.models.TagDTO;
import sn.ept.git.seminaire.cicd.services.TagService;

import java.net.URI;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.mock.web.MockHttpServletRequest;

@ExtendWith(MockitoExtension.class)
class TagResourceTest {
    @Mock
    TagService service;
    @InjectMocks
    TagResource resource;

    TagDTO dto;
    Page<TagDTO> page;
    Pageable pageable;

    @BeforeEach
    void setUp() {
        dto = TagDTOTestData.defaultDTO();
        page = new PageImpl<>(List.of(dto));
        pageable = PageRequest.of(0, 10);
    }

    @Test
    void findAll_shouldReturnPage() {
        given(service.findAll(pageable)).willReturn(page);
        ResponseEntity<Page<TagDTO>> response = resource.findAll(pageable);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(page);
    }

    @Test
    void findById_shouldReturnDTO() {
        given(service.findById(dto.getId())).willReturn(dto);
        ResponseEntity<TagDTO> response = resource.findById(dto.getId());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(dto);
    }

    @Test
    void create_shouldReturnCreated() {
        // Simule un contexte de requête web pour ServletUriComponentsBuilder
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        given(service.save(any(TagDTO.class))).willReturn(dto);
        ResponseEntity<TagDTO> response = resource.create(dto);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(dto);
        assertThat(response.getHeaders().getLocation()).isNotNull();
    }

    @Test
    void update_shouldReturnAccepted() {
        given(service.update(eq(dto.getId()), any(TagDTO.class))).willReturn(dto);
        ResponseEntity<TagDTO> response = resource.update(dto.getId(), dto);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
        assertThat(response.getBody()).isEqualTo(dto);
    }

    @Test
    void delete_shouldReturnNoContent() {
        ResponseEntity<TagDTO> response = resource.delete(dto.getId());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        verify(service).delete(dto.getId());
    }
} 