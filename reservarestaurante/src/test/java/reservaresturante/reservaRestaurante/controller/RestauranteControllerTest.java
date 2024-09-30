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
import reservaresturante.reservaRestaurante.DTO.RestauranteDTO;
import reservaresturante.reservaRestaurante.entities.utils.Enuns.DiaDeFuncionamento;
import reservaresturante.reservaRestaurante.entities.utils.Enuns.TipoCozinha;
import reservaresturante.reservaRestaurante.entities.utils.Localizacao;
import reservaresturante.reservaRestaurante.service.RestauranteService;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestauranteController.class)
public class RestauranteControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestauranteService restauranteService;

    @Autowired
    private ObjectMapper objectMapper;

    private RestauranteDTO restauranteDTO;

    @BeforeEach
    void setUp() {
        restauranteDTO = new RestauranteDTO(
                new ObjectId(),
                "Restaurante Teste",
                TipoCozinha.ITALIANA,
                new Localizacao("12345-678", "Rua Teste", 123, "Cidade Teste", "Estado Teste"),
                Set.of(DiaDeFuncionamento.SEGUNDA, DiaDeFuncionamento.TERCA),
                LocalTime.of(12, 0),
                LocalTime.of(22, 0),
                100
        );
    }

    @Test
    void findByLocalizacao_Cep() throws Exception {
        List<RestauranteDTO> restaurantes = Arrays.asList(restauranteDTO);
        when(restauranteService.findByCep("12345-678")).thenReturn(restaurantes);

        mockMvc.perform(get("/restaurante/cep/12345-678")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Restaurante Teste"))
                .andExpect(jsonPath("$[0].localizacao.cep").value("12345-678"));
    }

    @Test
    void findByNome() throws Exception {
        List<RestauranteDTO> restaurantes = Arrays.asList(restauranteDTO);
        when(restauranteService.findByNome("Restaurante Teste")).thenReturn(restaurantes);

        mockMvc.perform(get("/restaurante/nome/Restaurante Teste")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Restaurante Teste"));
    }

    @Test
    void findByTipoCozinha() throws Exception {
        List<RestauranteDTO> restaurantes = Arrays.asList(restauranteDTO);
        when(restauranteService.findByTipoCozinha(TipoCozinha.ITALIANA)).thenReturn(restaurantes);

        mockMvc.perform(get("/restaurante/tipoCozinha/Italiana")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].tipoCozinha").value("ITALIANA"));
    }

    @Test
    void inserirRestaurante() throws Exception {
        when(restauranteService.inserirRestaurante(any(RestauranteDTO.class))).thenReturn(restauranteDTO);

        mockMvc.perform(post("/restaurante")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(restauranteDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("Restaurante Teste"))
                .andExpect(jsonPath("$.tipoCozinha").value("ITALIANA"));
    }

}

