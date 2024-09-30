package reservaresturante.reservaRestaurante.service;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import reservaresturante.reservaRestaurante.DTO.AvaliacaoDTO;
import reservaresturante.reservaRestaurante.entities.Avaliacao;
import reservaresturante.reservaRestaurante.repositories.AvaliacaoRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AvaliacaoServiceTest {

    @Mock
    private AvaliacaoRepository avaliacaoRepository;

    @InjectMocks
    private AvaliacaoService avaliacaoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Transactional
    public void testInserirAvaliacao() {
        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO(
                new ObjectId("507f1f77bcf86cd799439011"),
                4.5,
                "Ótimo restaurante!",
                new ObjectId("507f1f77bcf86cd799439012"),
                new ObjectId("507f1f77bcf86cd799439013")
        );

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setObjectIdAvaliacao(avaliacaoDTO.getObjectIdAvaliacao());
        avaliacao.setComentarios(avaliacaoDTO.getComentarios());
        avaliacao.setNota(avaliacaoDTO.getNota());
        avaliacao.setObjectIdRestaurante(avaliacaoDTO.getObjectIdRestaurante());
        avaliacao.setObjectIdUsuario(avaliacaoDTO.getObjectIdUsuario());

        when(avaliacaoRepository.save(any(Avaliacao.class))).thenReturn(avaliacao);

        AvaliacaoDTO resultado = avaliacaoService.inserirAvaliacao(avaliacaoDTO);

        assertNotNull(resultado);
        assertEquals(avaliacaoDTO.getObjectIdAvaliacao(), resultado.getObjectIdAvaliacao());
        assertEquals(avaliacaoDTO.getComentarios(), resultado.getComentarios());
        assertEquals(avaliacaoDTO.getNota(), resultado.getNota());
        assertEquals(avaliacaoDTO.getObjectIdRestaurante(), resultado.getObjectIdRestaurante());
        assertEquals(avaliacaoDTO.getObjectIdUsuario(), resultado.getObjectIdUsuario());

        verify(avaliacaoRepository, times(1)).save(any(Avaliacao.class));
    }
}

