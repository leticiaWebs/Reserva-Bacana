package reservaresturante.reservarestaurante.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Document(collection = "reserva")
public class Reserva {

    private Long reservaId;
    private LocalDate dataReserva;
    private LocalTime horarioReserva;
    private LocalTime reservasConfirmadas;
    private LocalTime horarioDeAbertura;
    private LocalTime horarioDeEncerramento;
    private int capacidade;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurante", referencedColumnName = "restauranteId")
    private Long restauranteId;

}
