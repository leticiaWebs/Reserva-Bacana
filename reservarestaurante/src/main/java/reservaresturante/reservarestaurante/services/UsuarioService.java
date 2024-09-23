package reservaresturante.reservarestaurante.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reservaresturante.reservarestaurante.DTO.UsuarioDTO;
import reservaresturante.reservarestaurante.entities.Usuario;
import reservaresturante.reservarestaurante.repositories.UsuarioReporitory;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioReporitory usuarioReporitory;

    @Transactional
    public UsuarioDTO inserirUsuario(UsuarioDTO usuarioDTO){
        Usuario entity = new Usuario();
        entity.setUsuarioId(usuarioDTO.getUsuarioId());
        entity.setNome(usuarioDTO.getNome());
        usuarioReporitory.save(entity);
        return new UsuarioDTO(entity);
    }
}
