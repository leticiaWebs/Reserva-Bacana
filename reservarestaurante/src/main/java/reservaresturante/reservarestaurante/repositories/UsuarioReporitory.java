package reservaresturante.reservarestaurante.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import reservaresturante.reservarestaurante.entities.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioReporitory  extends MongoRepository<Usuario, ObjectId> {
    Optional<Usuario> findByObjectIdUsuario(ObjectId objectIdUsuario);

}
