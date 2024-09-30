package reservaresturante.reservaRestaurante.DTO;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import reservaresturante.reservaRestaurante.entities.Restaurante;
import reservaresturante.reservaRestaurante.entities.utils.Enuns.DiaDeFuncionamento;
import reservaresturante.reservaRestaurante.entities.utils.Enuns.TipoCozinha;
import reservaresturante.reservaRestaurante.entities.utils.Localizacao;

import java.time.LocalTime;
import java.util.Set;

@Setter
@Getter
public class RestauranteDTO {
    private ObjectId objectIdRestaurante;
    private String nome;
    private TipoCozinha tipoCozinha;
    private Localizacao localizacao;
    private Set<DiaDeFuncionamento> diasDeFuncionamento;
    private LocalTime horarioDeAbertura;
    private LocalTime horarioDeEncerramento;
    private int capacidade;

    public RestauranteDTO(ObjectId objectIdRestaurante, String nome, TipoCozinha tipoCozinha, Localizacao localizacao, Set<DiaDeFuncionamento> diasDeFuncionamento, LocalTime horarioDeAbertura, LocalTime horarioDeEncerramento, int capacidade) {
        this.objectIdRestaurante = objectIdRestaurante;
        this.nome = nome;
        this.tipoCozinha = tipoCozinha;
        this.localizacao = localizacao;
        this.diasDeFuncionamento = diasDeFuncionamento;
        this.horarioDeAbertura = horarioDeAbertura;
        this.horarioDeEncerramento = horarioDeEncerramento;
        this.capacidade = capacidade;
    }

    public RestauranteDTO(Restaurante entity) {
        this.objectIdRestaurante = entity.getObjectIdRestaurante();
        this.nome = entity.getNome();
        this.tipoCozinha = entity.getTipoCozinha();
        this.localizacao = entity.getLocalizacao();
        this.capacidade = entity.getCapacidade();
        this.horarioDeAbertura = entity.getHorarioDeAbertura();
        this.horarioDeEncerramento = entity.getHorarioDeEncerramento();
        this.diasDeFuncionamento = entity.getDiasDeFuncionamento();
    }
}
