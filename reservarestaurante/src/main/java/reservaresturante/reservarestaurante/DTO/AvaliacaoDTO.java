package reservaresturante.reservarestaurante.DTO;

import lombok.Getter;
import lombok.Setter;
import reservaresturante.reservarestaurante.entities.Avaliacao;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AvaliacaoDTO {

    private String avaliacaoId;
    private double nota;
    private String comentarios;
    private Long  restauranteId;
    private Long usuarioId;

    public AvaliacaoDTO(String avaliacaoId, double nota, String comentarios, Long restauranteId, Long usuarioId) {
        this.avaliacaoId = avaliacaoId;
        this.nota = nota;
        this.comentarios = comentarios;
        this.restauranteId = restauranteId;
        this.usuarioId = usuarioId;
    }

    public AvaliacaoDTO(Avaliacao entity){
        this.avaliacaoId = entity.getAvaliacaoId();
        this.comentarios=entity.getComentarios();
        this.nota = entity.getNota();
        this.restauranteId= entity.getRestauranteId();
        this.usuarioId=entity.getUsuarioId();
    }
}
