package reservaresturante.reservarestaurante.entities.utils.Enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public enum TipoCozinha {
    CONFEITARIA("confeitaria"),
    PADARIA("padaria"),
    SORVETERIA("sorveteria"),
    CHINESA("chinesa"),
    ITALIANA("italiana"),
    INDIANA("indiana"),
    PORTUGUESA("portuguesa"),
    PEIXES("peixes"),
    VEGANO("vegano"),
    FRANCESA("francesa"),
    MEXICANA("mexicana"),
    CONTEMPORANEA("comtemporanea");

    private final String descricao;


    TipoCozinha(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

}
