package reservaresturante.reservarestaurante.service;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.transaction.annotation.Transactional;
import reservaresturante.reservarestaurante.DTO.RestauranteDTO;
import reservaresturante.reservarestaurante.entities.Restaurante;
import reservaresturante.reservarestaurante.entities.utils.Enuns.DiaDeFuncionamento;
import reservaresturante.reservarestaurante.entities.utils.Enuns.TipoCozinha;
import reservaresturante.reservarestaurante.entities.utils.Localizacao;
import reservaresturante.reservarestaurante.repositories.RestauranteRepository;
import reservaresturante.reservarestaurante.service.exceptions.ResourceNotFoundException;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RestauranteServiceTest {
    @Mock
    private RestauranteRepository restauranteRepository;

    @InjectMocks
    private RestauranteService restauranteService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Transactional
    public void testFindAll() {
        Restaurante restaurante1 = new Restaurante();
        Restaurante restaurante2 = new Restaurante();
        when(restauranteRepository.findAll()).thenReturn(Arrays.asList(restaurante1, restaurante2));
        List<RestauranteDTO> resultado = restauranteService.findAll();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
    }

    @Test
    public void testFindByCep() {
        Restaurante restaurante = new Restaurante();
        when(restauranteRepository.findByLocalizacao_Cep("12345-678")).thenReturn(Arrays.asList(restaurante));

        List<RestauranteDTO> resultado = restauranteService.findByCep("12345-678");

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
    }

    @Test
    public void testFindByCepNotFound() {
        when(restauranteRepository.findByLocalizacao_Cep("12345-678")).thenReturn(Arrays.asList());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            restauranteService.findByCep("12345-678");
        });

        assertEquals("Nenhum restaurante encontrado com o CEP: 12345-678", exception.getMessage());
    }

    @Test
    public void testFindByNome() {
        Restaurante restaurante = new Restaurante();
        when(restauranteRepository.findByNome("Restaurante Teste")).thenReturn(Arrays.asList(restaurante));

        List<RestauranteDTO> resultado = restauranteService.findByNome("Restaurante Teste");

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
    }

    @Test
    public void testFindByNomeNotFound() {
        when(restauranteRepository.findByNome("Restaurante Teste")).thenReturn(Arrays.asList());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            restauranteService.findByNome("Restaurante Teste");
        });

        assertEquals("Nenhum restaurante encontrado com o nome: Restaurante Teste", exception.getMessage());
    }

    @Test
    public void testFindByTipoCozinha() {
        Restaurante restaurante = new Restaurante();
        when(restauranteRepository.findByTipoCozinha(TipoCozinha.ITALIANA)).thenReturn(Arrays.asList(restaurante));
        List<RestauranteDTO> resultado = restauranteService.findByTipoCozinha(TipoCozinha.ITALIANA);

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
    }


    @Test
    @Transactional
    public void testInserirRestaurante() {
        RestauranteDTO restauranteDTO = new RestauranteDTO(
                new ObjectId("507f1f77bcf86cd799439011"),
                "Restaurante Teste",
                TipoCozinha.ITALIANA,
                new Localizacao("12345-678", "Rua Teste", 1234, "campo limpo ", "Estado Teste"),
                Set.of(DiaDeFuncionamento.SEGUNDA, DiaDeFuncionamento.TERCA),
                LocalTime.of(10, 0),
                LocalTime.of(22, 0),
                100
        );

        Restaurante restaurante = new Restaurante();
        restaurante.setObjectIdRestaurante(restauranteDTO.getObjectIdRestaurante());
        restaurante.setNome(restauranteDTO.getNome());
        restaurante.setTipoCozinha(restauranteDTO.getTipoCozinha());
        restaurante.setLocalizacao(restauranteDTO.getLocalizacao());
        restaurante.setCapacidade(restauranteDTO.getCapacidade());
        restaurante.setDiasDeFuncionamento(restauranteDTO.getDiasDeFuncionamento());
        restaurante.setHorarioDeAbertura(restauranteDTO.getHorarioDeAbertura());
        restaurante.setHorarioDeEncerramento(restauranteDTO.getHorarioDeEncerramento());

        when(restauranteRepository.save(any(Restaurante.class))).thenReturn(restaurante);

        RestauranteDTO resultado = restauranteService.inserirRestaurante(restauranteDTO);

        assertNotNull(resultado);
        assertEquals(restauranteDTO.getObjectIdRestaurante(), resultado.getObjectIdRestaurante());
        assertEquals(restauranteDTO.getNome(), resultado.getNome());
        assertEquals(restauranteDTO.getTipoCozinha(), resultado.getTipoCozinha());
        assertEquals(restauranteDTO.getLocalizacao(), resultado.getLocalizacao());
        assertEquals(restauranteDTO.getCapacidade(), resultado.getCapacidade());
        assertEquals(restauranteDTO.getDiasDeFuncionamento(), resultado.getDiasDeFuncionamento());
        assertEquals(restauranteDTO.getHorarioDeAbertura(), resultado.getHorarioDeAbertura());
        assertEquals(restauranteDTO.getHorarioDeEncerramento(), resultado.getHorarioDeEncerramento());

        verify(restauranteRepository, times(1)).save(any(Restaurante.class));
    }
}

