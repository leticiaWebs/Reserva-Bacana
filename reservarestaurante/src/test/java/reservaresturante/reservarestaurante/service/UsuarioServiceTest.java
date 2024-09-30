package reservaresturante.reservarestaurante.service;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import reservaresturante.reservarestaurante.DTO.UsuarioDTO;
import reservaresturante.reservarestaurante.entities.Usuario;
import reservaresturante.reservarestaurante.repositories.UsuarioRepository;
import reservaresturante.reservarestaurante.service.exceptions.ResourceNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UsuarioServiceTest {
    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Transactional(readOnly = true)
    public void testFindByUsuarioId() {
        Usuario usuario = new Usuario();
        usuario.setObjectIdUsuario(new ObjectId("507f1f77bcf86cd799439011"));
        usuario.setNome("Teste");
        usuario.setNumeroTelefone("123456789");

        when(usuarioRepository.findByObjectIdUsuario(any(ObjectId.class))).thenReturn(Optional.of(usuario));

        UsuarioDTO resultado = usuarioService.findByUsuarioId(new ObjectId("507f1f77bcf86cd799439011"));

        assertNotNull(resultado);
        assertEquals("Teste", resultado.getNome());
        assertEquals("123456789", resultado.getNumeroTelefone());
        verify(usuarioRepository, times(1)).findByObjectIdUsuario(any(ObjectId.class));
    }

    @Test
    public void testFindByUsuarioIdNotFound() {
        when(usuarioRepository.findByObjectIdUsuario(any(ObjectId.class))).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            usuarioService.findByUsuarioId(new ObjectId("507f1f77bcf86cd799439011"));
        });

        assertEquals("Usuário não encontrado: 507f1f77bcf86cd799439011", exception.getMessage());
    }

    @Test
    @Transactional
    public void testInserirUsuario() {
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                new ObjectId("507f1f77bcf86cd799439011"),
                "Teste",
                "123456789"
        );

        Usuario usuario = new Usuario();
        usuario.setObjectIdUsuario(usuarioDTO.getObjectIdUsuario());
        usuario.setNome(usuarioDTO.getNome());
        usuario.setNumeroTelefone(usuarioDTO.getNumeroTelefone());

        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);
        UsuarioDTO resultado = usuarioService.inserirUsuario(usuarioDTO);

        assertNotNull(resultado);
        assertEquals(usuarioDTO.getObjectIdUsuario(), resultado.getObjectIdUsuario());
        assertEquals(usuarioDTO.getNome(), resultado.getNome());
        assertEquals(usuarioDTO.getNumeroTelefone(), resultado.getNumeroTelefone());
        verify(usuarioRepository, times(1)).save(any(Usuario.class));
    }

}
