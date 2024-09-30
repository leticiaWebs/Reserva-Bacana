package reservaresturante.reservaRestaurante.entities;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "usuario")
public class Usuario {
    @Id
    private ObjectId objectIdUsuario;
    private String numeroTelefone;
    private String nome;

}
