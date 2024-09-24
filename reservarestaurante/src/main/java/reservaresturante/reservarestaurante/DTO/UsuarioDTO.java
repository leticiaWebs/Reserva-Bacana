package reservaresturante.reservarestaurante.DTO;

import lombok.Getter;
import lombok.Setter;
import reservaresturante.reservarestaurante.entities.Usuario;

@Getter
@Setter
public class UsuarioDTO {
    private Long usuarioId;
    private String nome;
    private String numeroTelefone;

    public UsuarioDTO(Long usuarioId, String nome, String numeroTelefone) {
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
    }
    public UsuarioDTO(Usuario entity){
        this.usuarioId= entity.getUsuarioId();
        this.nome = entity.getNome();
        this.numeroTelefone = entity.getNumeroTelefone();
    }
}
