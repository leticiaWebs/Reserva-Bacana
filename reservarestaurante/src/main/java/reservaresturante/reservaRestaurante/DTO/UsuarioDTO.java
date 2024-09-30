package reservaresturante.reservaRestaurante.DTO;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import reservaresturante.reservaRestaurante.entities.Usuario;

@Getter
@Setter
public class UsuarioDTO {
    private ObjectId objectIdUsuario;
    private String nome;
    private String numeroTelefone;

    public UsuarioDTO(ObjectId objectIdUsuario, String nome, String numeroTelefone) {
        this.objectIdUsuario = objectIdUsuario;
        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
    }

    public UsuarioDTO(Usuario entity){
        this.objectIdUsuario= entity.getObjectIdUsuario();
        this.nome = entity.getNome();
        this.numeroTelefone = entity.getNumeroTelefone();
    }
}
