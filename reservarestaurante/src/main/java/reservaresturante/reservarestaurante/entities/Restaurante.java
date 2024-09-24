package reservaresturante.reservarestaurante.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import reservaresturante.reservarestaurante.entities.utils.Enuns.TipoCozinha;
import reservaresturante.reservarestaurante.entities.utils.Localizacao;

@Getter
@Setter
@Document(collection = "resturante")
public class Restaurante {
    @Id
    @DBRef
    private Long restauranteId;
    private String nome;
    private TipoCozinha tipoCozinha;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "localizacao", referencedColumnName = "id")
    private Localizacao localizacao;

}
