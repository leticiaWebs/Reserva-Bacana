package reservaresturante.reservaRestaurante.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import reservaresturante.reservaRestaurante.entities.Reserva;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
public class ReservaDTO {
    private String idReserva;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataReserva;
    private String reservasConfirmadas;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime horarioReserva;
    private ObjectId objectIdRestaurante;

    public ReservaDTO(String idReserva, LocalDate dataReserva, String reservasConfirmadas, LocalTime horarioReserva, ObjectId objectIdRestaurante) {
        this.idReserva = idReserva;
        this.dataReserva = dataReserva;
        this.reservasConfirmadas = reservasConfirmadas;
        this.horarioReserva = horarioReserva;
        this.objectIdRestaurante = objectIdRestaurante;
    }

    public ReservaDTO(Reserva entity) {
        this.idReserva = entity.getIdReserva();
        this.dataReserva = entity.getDataReserva();
        this.reservasConfirmadas = entity.getReservasConfirmadas();
        this.horarioReserva = entity.getHorarioReserva();
        this.objectIdRestaurante = entity.getObjectIdRestaurante();
    }

    public ReservaDTO() {

    }
}
