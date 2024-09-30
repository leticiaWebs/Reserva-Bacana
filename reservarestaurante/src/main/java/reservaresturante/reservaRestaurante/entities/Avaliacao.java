package reservaresturante.reservaRestaurante.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "avaliacoes")
public class Avaliacao {
    @Id
    private ObjectId objectIdAvaliacao;
    private double nota;
    private String comentarios;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurante", referencedColumnName = "objectIdRestaurante")
    private ObjectId objectIdRestaurante;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario", referencedColumnName = "objectIdUsuario")
    private ObjectId objectIdUsuario;

    public void adicionarNota(double nota) {
        if (nota >= 1 && nota <= 5) {
            this.nota = nota;  // Atribui a única nota
        } else {
            throw new IllegalArgumentException("Nota deve estar entre 1 e 5");
        }
    }

    public double calcularMedia(List<Avaliacao> avaliacoes) {
        if (avaliacoes.isEmpty()) {
            return 0.0;
        }
        double soma = 0;
        for (Avaliacao avaliacao : avaliacoes) {
            soma += avaliacao.nota; // Soma todas as notas
        }
        return soma / avaliacoes.size(); // Retorna a média
    }
}
