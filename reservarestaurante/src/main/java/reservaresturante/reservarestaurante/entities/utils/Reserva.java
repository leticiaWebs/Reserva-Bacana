package reservaresturante.reservarestaurante.entities.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Document(collection = "reserva")
public class Reserva {

    private Long id;
    private LocalDate dataReserva;
    private LocalTime reservasConfirmadas;
    private LocalTime horarioDeAbertura;
    private LocalTime horarioDeEncerramento;
    private int capacidade;
    //private boolean fazerReserva()

}
