package reservaresturante.reservarestaurante.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "usuario")
public class Usuario {
    private Long usuarioId;
    private String numeroTelefone;
    private String nome;

}
