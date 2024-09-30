package reservaresturante.reservarestaurante.service;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.transaction.annotation.Transactional;
import reservaresturante.reservarestaurante.DTO.ReservaDTO;
import reservaresturante.reservarestaurante.entities.Reserva;
import reservaresturante.reservarestaurante.repositories.ReservaRepository;
import reservaresturante.reservarestaurante.service.exceptions.ResourceNotFoundException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.bson.assertions.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ReservaServiceTest {
    @Mock
    private ReservaRepository reservaRepository;

    @InjectMocks
    private ReservaService reservaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Transactional
    public void testFindAll() {
        Reserva reserva1 = new Reserva();
        Reserva reserva2 = new Reserva();
        when(reservaRepository.findAll()).thenReturn(Arrays.asList(reserva1, reserva2));

        List<ReservaDTO> resultado = reservaService.findAll();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
    }

    @Test
    public void testGetReservaById() {
        Reserva reserva = new Reserva();
        when(reservaRepository.findByIdReserva("1")).thenReturn(Optional.of(reserva));
        Reserva resultado = reservaService.getReservaById("1");
        assertNotNull(resultado);
        verify(reservaRepository, times(1)).findByIdReserva("1");
    }

    @Test
    public void testGetReservaByIdNotFound() {
        when(reservaRepository.findByIdReserva("1")).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            reservaService.getReservaById("1");
        });

        assertEquals("Reserva não encontrada com o id: 1", exception.getMessage());
    }

    @Test
    @Transactional
    public void testInserirReserva() {
        // Dados de entrada
        ReservaDTO reservaDTO = new ReservaDTO(
                "1",
                LocalDate.now(),
                "Confirmada",
                LocalTime.now(),
                new ObjectId("507f1f77bcf86cd799439011")
        );

        Reserva reserva = new Reserva();
        reserva.setIdReserva(reservaDTO.getIdReserva());
        reserva.setDataReserva(reservaDTO.getDataReserva());
        reserva.setReservasConfirmadas(reservaDTO.getReservasConfirmadas());
        reserva.setHorarioReserva(reservaDTO.getHorarioReserva());
        reserva.setObjectIdRestaurante(reservaDTO.getObjectIdRestaurante());

        when(reservaRepository.save(any(Reserva.class))).thenReturn(reserva);
        ReservaDTO resultado = reservaService.inserirReserva(reservaDTO);

        assertNotNull(resultado);
        assertEquals(reservaDTO.getIdReserva(), resultado.getIdReserva());
        assertEquals(reservaDTO.getDataReserva(), resultado.getDataReserva());
        assertEquals(reservaDTO.getReservasConfirmadas(), resultado.getReservasConfirmadas());
        assertEquals(reservaDTO.getHorarioReserva(), resultado.getHorarioReserva());
        assertEquals(reservaDTO.getObjectIdRestaurante(), resultado.getObjectIdRestaurante());

        verify(reservaRepository, times(1)).save(any(Reserva.class));
    }


    @Test
    public void testUpdateReservasConfirmadasNotFound() {
        when(reservaRepository.findByIdReserva("1")).thenReturn(Optional.empty());

        ReservaDTO reservaDTO = new ReservaDTO(
                "1",
                LocalDate.now(),
                "Confirmada",
                LocalTime.now(),
                new ObjectId("507f1f77bcf86cd799439011")
        );

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            reservaService.updateReservasConfirmadas("1", reservaDTO);
        });

        assertEquals("Reserva não encontrada com o id: 1", exception.getMessage());
    }
}
