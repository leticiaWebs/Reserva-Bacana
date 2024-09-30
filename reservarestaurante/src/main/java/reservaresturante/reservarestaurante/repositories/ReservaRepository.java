package reservaresturante.reservarestaurante.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import reservaresturante.reservarestaurante.entities.Reserva;

import java.util.Optional;

@Repository
public interface ReservaRepository extends MongoRepository<Reserva, String> {
    Optional<Reserva> findByIdReserva(String idReserva);
}
