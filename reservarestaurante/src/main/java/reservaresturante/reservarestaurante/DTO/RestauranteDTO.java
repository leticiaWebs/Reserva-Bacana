package reservaresturante.reservarestaurante.DTO;

import lombok.Getter;
import lombok.Setter;
import reservaresturante.reservarestaurante.entities.Restaurante;
import reservaresturante.reservarestaurante.entities.utils.Enuns.TipoCozinha;
import reservaresturante.reservarestaurante.entities.utils.Localizacao;

@Setter
@Getter
public class RestauranteDTO {

    private Long restauranteId;
    private String nome;
    private TipoCozinha tipoCozinha;
    private Localizacao localizacao;

    public RestauranteDTO(Long restauranteId, String nome, TipoCozinha tipoCozinha, Localizacao localizacao) {
        this.restauranteId = restauranteId;
        this.nome = nome;
        this.tipoCozinha = tipoCozinha;
        this.localizacao = localizacao;
    }
    public RestauranteDTO(Restaurante entity){
        this.restauranteId = entity.getRestauranteId();
        this.nome = entity.getNome();
        this.tipoCozinha = entity.getTipoCozinha();
        this.localizacao = entity.getLocalizacao();
    }
}
