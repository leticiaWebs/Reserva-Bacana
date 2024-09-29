package reservaresturante.reservarestaurante.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import reservaresturante.reservarestaurante.entities.utils.Enuns.DiaDeFuncionamento;
import reservaresturante.reservarestaurante.entities.utils.Enuns.TipoCozinha;
import reservaresturante.reservarestaurante.entities.utils.Localizacao;

import java.time.LocalTime;
import java.util.Set;

@Getter
@Setter
@Document(collection = "resturante")
public class Restaurante {
    @Id
    @DBRef
    private ObjectId objectIdRestaurante;
    private String nome;
    private TipoCozinha tipoCozinha;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "localizacao", referencedColumnName = "id")
    private Localizacao localizacao;
    private Set<DiaDeFuncionamento> diasDeFuncionamento;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "America/Sao_Paulo")
    private LocalTime horarioDeAbertura;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "America/Sao_Paulo")
    private LocalTime horarioDeEncerramento;
    private int capacidade;

}
