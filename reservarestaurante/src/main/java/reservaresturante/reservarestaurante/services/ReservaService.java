package reservaresturante.reservarestaurante.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reservaresturante.reservarestaurante.DTO.ReservaDTO;
import reservaresturante.reservarestaurante.entities.Reserva;
import reservaresturante.reservarestaurante.entities.Restaurante;
import reservaresturante.reservarestaurante.repositories.ReservaRepository;
import reservaresturante.reservarestaurante.repositories.RestauranteRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private RestauranteRepository restauranteRepository;

    @Transactional
    public ReservaDTO inserirInformacoesRestaurante(ReservaDTO reservaDTO){
        Reserva entity = new Reserva();
        entity.setRestauranteId(reservaDTO.getRestauranteId());
        entity.setHorarioDeAbertura(reservaDTO.getHorarioDeAbertura());
        entity.setHorarioDeEncerramento(reservaDTO.getHorarioDeEncerramento());
        entity.setCapacidade(reservaDTO.getCapacidade());
        reservaRepository.save(entity);
        return new ReservaDTO(entity);
    }

  @Transactional
    public ReservaDTO inserirReserva(ReservaDTO reservaDTO){
        Reserva entity = new Reserva();
        entity.setRestauranteId(reservaDTO.getRestauranteId());
        entity.setReservaId(reservaDTO.getReservaId());
        entity.setDataReserva(reservaDTO.getDataReserva());
        entity.setHorarioReserva(reservaDTO.getHorarioReserva());
        reservaRepository.save(entity);
        return new ReservaDTO(entity);
  }
}
