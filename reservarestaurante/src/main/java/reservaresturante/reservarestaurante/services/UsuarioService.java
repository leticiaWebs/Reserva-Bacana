package reservaresturante.reservarestaurante.services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reservaresturante.reservarestaurante.DTO.UsuarioDTO;
import reservaresturante.reservarestaurante.entities.Usuario;
import reservaresturante.reservarestaurante.repositories.UsuarioReporitory;
import reservaresturante.reservarestaurante.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioReporitory usuarioReporitory;

    @Transactional(readOnly = true)
    public UsuarioDTO findByUsuarioId(ObjectId objectIdUsuario) {
        Usuario usuario = usuarioReporitory.findByObjectIdUsuario(objectIdUsuario)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado: " + objectIdUsuario));
        return new UsuarioDTO(usuario);
    }

    @Transactional
    public UsuarioDTO inserirUsuario(UsuarioDTO usuarioDTO){
        Usuario entity = new Usuario();
        entity.setObjectIdUsuario(usuarioDTO.getObjectIdUsuario());
        entity.setNome(usuarioDTO.getNome());
        entity.setNumeroTelefone(usuarioDTO.getNumeroTelefone());
        usuarioReporitory.save(entity);
        return new UsuarioDTO(entity);
    }

}
