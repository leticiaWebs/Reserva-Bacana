package reservaresturante.reservaRestaurante.entities.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "localizacao")
public class Localizacao {
    private String cep;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;


}
