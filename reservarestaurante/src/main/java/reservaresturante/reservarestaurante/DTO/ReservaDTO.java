package reservaresturante.reservarestaurante.DTO;

import lombok.Getter;
import lombok.Setter;
import reservaresturante.reservarestaurante.entities.Reserva;
import reservaresturante.reservarestaurante.entities.Restaurante;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
public class ReservaDTO {

    private Long reservaId;
    private LocalDate dataReserva;
    private LocalTime reservasConfirmadas;
    private LocalTime horarioDeAbertura;
    private LocalTime horarioDeEncerramento;
    private int capacidade;
    private LocalTime horarioReserva;
    private Long restauranteId;

    public ReservaDTO(Long reservaId, LocalDate dataReserva, LocalTime reservasConfirmadas, LocalTime horarioDeAbertura, LocalTime horarioDeEncerramento, int capacidade, LocalTime horarioReserva, Long restauranteId) {
        this.reservaId = reservaId;
        this.dataReserva = dataReserva;
        this.reservasConfirmadas = reservasConfirmadas;
        this.horarioDeAbertura = horarioDeAbertura;
        this.horarioDeEncerramento = horarioDeEncerramento;
        this.capacidade = capacidade;
        this.horarioReserva = horarioReserva;
        this.restauranteId = restauranteId;
    }

    public ReservaDTO(Reserva entity){
        this.reservaId = entity.getReservaId();
        this.dataReserva = entity.getDataReserva();
        this.reservasConfirmadas = entity.getReservasConfirmadas();
        this.horarioDeAbertura = entity.getHorarioDeAbertura();
        this.horarioDeEncerramento = entity.getHorarioDeEncerramento();
        this.capacidade = entity.getCapacidade();
        this.horarioReserva = entity.getHorarioReserva();
        this.restauranteId = entity.getRestauranteId();
    }

}
