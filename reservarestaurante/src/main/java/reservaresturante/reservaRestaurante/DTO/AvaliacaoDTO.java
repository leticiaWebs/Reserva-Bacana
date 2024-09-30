package reservaresturante.reservaRestaurante.DTO;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import reservaresturante.reservaRestaurante.entities.Avaliacao;

@Getter
@Setter
public class AvaliacaoDTO {

    private ObjectId objectIdAvaliacao;
    private double nota;
    private String comentarios;
    private ObjectId objectIdRestaurante;
    private ObjectId objectIdUsuario;

    public AvaliacaoDTO(ObjectId objectIdAvaliacao, double nota, String comentarios, ObjectId objectIdRestaurante, ObjectId objectIdUsuario) {
        this.objectIdAvaliacao = objectIdAvaliacao;
        this.nota = nota;
        this.comentarios = comentarios;
        this.objectIdRestaurante = objectIdRestaurante;
        this.objectIdUsuario = objectIdUsuario;
    }

    public AvaliacaoDTO(Avaliacao entity) {
        this.objectIdAvaliacao = entity.getObjectIdAvaliacao();
        this.comentarios = entity.getComentarios();
        this.nota = entity.getNota();
        this.objectIdRestaurante = entity.getObjectIdRestaurante();
        this.objectIdUsuario = entity.getObjectIdUsuario();
    }

    public AvaliacaoDTO() {

    }
}
