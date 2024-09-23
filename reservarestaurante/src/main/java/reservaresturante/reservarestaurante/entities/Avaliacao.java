package reservaresturante.reservarestaurante.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import reservaresturante.reservarestaurante.entities.Restaurante;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Document(collection = "avaliacoes")
public class Avaliacao {
    @Id
    private String avaliacaoId;
    private List<Integer> notas = new ArrayList<>();
    private String comentarios;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurante", referencedColumnName = "restauranteId")
    private Long restauranteId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario", referencedColumnName = "usuarioId")
    private Long usuarioId;

    public void adicionarNota(int nota) {
        if (nota >= 1 && nota <= 5) {
            notas.add(nota);  // Adiciona a nota se for válida
        }
    }
    public double calcularMedia(){
        if(notas.isEmpty()) {
            return 0.0;
        }
        double soma =0;
        for(int nota : notas){
            soma+=nota;
        }
        return soma/notas.size();
    }
}
