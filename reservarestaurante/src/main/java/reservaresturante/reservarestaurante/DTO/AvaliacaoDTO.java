package reservaresturante.reservarestaurante.DTO;

import lombok.Getter;
import lombok.Setter;
import reservaresturante.reservarestaurante.entities.Avaliacao;
import reservaresturante.reservarestaurante.entities.Restaurante;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AvaliacaoDTO {

    private String avaliacaoId;
    private List<Integer> notas = new ArrayList<>();
    private String comentarios;
    private Long  restauranteId;
    private Long usuarioId;

    public AvaliacaoDTO(String avaliacaoId, List<Integer> notas, String comentarios, Long restauranteId, Long usuarioId) {
        this.avaliacaoId = avaliacaoId;
        this.notas = notas;
        this.comentarios = comentarios;
        this.restauranteId = restauranteId;
        this.usuarioId = usuarioId;
    }

    public AvaliacaoDTO(Avaliacao entity){
        this.avaliacaoId = entity.getAvaliacaoId();
        this.comentarios=entity.getComentarios();
        this.notas=entity.getNotas();
        this.restauranteId= entity.getRestauranteId();
        this.usuarioId=entity.getUsuarioId();
    }
}
