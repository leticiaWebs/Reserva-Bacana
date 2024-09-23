package reservaresturante.reservarestaurante.DTO;

import lombok.Getter;
import lombok.Setter;
import reservaresturante.reservarestaurante.entities.Usuario;
import reservaresturante.reservarestaurante.entities.Avaliacao;

@Getter
@Setter
public class UsuarioDTO {
    private Long usuarioId;
    private String nome;

    public UsuarioDTO(Long usuarioId, String nome) {
        this.usuarioId = usuarioId;
        this.nome = nome;
    }
    public UsuarioDTO(Usuario entity){
        this.usuarioId= entity.getUsuarioId();
        this.nome = entity.getNome();
    }
}
