package reservaresturante.reservaRestaurante.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import reservaresturante.reservaRestaurante.DTO.AvaliacaoDTO;
import reservaresturante.reservaRestaurante.service.AvaliacaoService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AvaliacaoController.class)
public class AvaliacaoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AvaliacaoService avaliacaoService;

    @Autowired
    private ObjectMapper objectMapper;

    private AvaliacaoDTO avaliacaoDTO;

    @BeforeEach
    void setUp() {
        avaliacaoDTO = new AvaliacaoDTO();
        avaliacaoDTO.setObjectIdAvaliacao(new ObjectId());
        avaliacaoDTO.setNota(4.5);
        avaliacaoDTO.setComentarios("Ótimo restaurante!");
        avaliacaoDTO.setObjectIdRestaurante(new ObjectId());
        avaliacaoDTO.setObjectIdUsuario(new ObjectId());
    }

    @Test
    void inserirAvaliacao() throws Exception {
        when(avaliacaoService.inserirAvaliacao(any(AvaliacaoDTO.class))).thenReturn(avaliacaoDTO);

        mockMvc.perform(post("/avaliacao")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(avaliacaoDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.comentarios").value("Ótimo restaurante!"))
                .andExpect(jsonPath("$.nota").value(4.5));
    }
}


