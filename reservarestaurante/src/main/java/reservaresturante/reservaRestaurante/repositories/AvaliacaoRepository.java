package reservaresturante.reservaRestaurante.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import reservaresturante.reservaRestaurante.entities.Avaliacao;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends MongoRepository<Avaliacao, ObjectId> {

    List<Avaliacao> findByObjectIdRestaurante(String objectIdRestaurante);

    List<Avaliacao> findByObjectIdUsuario(ObjectId objectIdUsuario);
}
