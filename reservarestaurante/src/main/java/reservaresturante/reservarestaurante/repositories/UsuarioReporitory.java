package reservaresturante.reservarestaurante.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import reservaresturante.reservarestaurante.entities.Usuario;

@Repository
public interface UsuarioReporitory  extends MongoRepository<Usuario, Long> {

}
