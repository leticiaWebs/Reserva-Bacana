package reservaresturante.reservarestaurante.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reservaresturante.reservarestaurante.entities.Avaliacao;
import reservaresturante.reservarestaurante.entities.Reserva;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepository extends MongoRepository<Reserva, Long> {
    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END " +
            "FROM Reserva r WHERE r.dataReserva = :dataReserva AND r.restauranteId = :restauranteId")
    boolean existsByDataReservaAndRestaurante(@Param("dataReserva") LocalDate dataReserva,
                                              @Param("restauranteId") Long restauranteId);
    List<Reserva> findByRestauranteId(String restauranteId);
}
