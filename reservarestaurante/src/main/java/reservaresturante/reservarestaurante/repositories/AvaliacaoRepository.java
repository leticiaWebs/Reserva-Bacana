package reservaresturante.reservarestaurante.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import reservaresturante.reservarestaurante.entities.Avaliacao;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends MongoRepository<Avaliacao, Long> {
    List<Avaliacao> findByRestauranteId(String restauranteId);
    List<Avaliacao> findByUsuarioId(String usuarioId);
}
