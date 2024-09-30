package reservaresturante.reservaRestaurante.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import reservaresturante.reservaRestaurante.entities.Reserva;

import java.util.Optional;

@Repository
public interface ReservaRepository extends MongoRepository<Reserva, String> {
    Optional<Reserva> findByIdReserva(String idReserva);
}
