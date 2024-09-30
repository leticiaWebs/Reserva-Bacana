package reservaresturante.reservaRestaurante.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import reservaresturante.reservaRestaurante.DTO.ReservaDTO;
import reservaresturante.reservaRestaurante.service.ReservaService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReservaController.class)
public class ReservaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservaService reservaService;

    @Autowired
    private ObjectMapper objectMapper;

    private ReservaDTO reservaDTO;

    @BeforeEach
    void setUp() {
        reservaDTO = new ReservaDTO();
        reservaDTO.setIdReserva("1");
        reservaDTO.setDataReserva(LocalDate.of(2024, 9, 30));
        reservaDTO.setReservasConfirmadas("Sim");
        reservaDTO.setHorarioReserva(LocalTime.of(19, 0));
        reservaDTO.setObjectIdRestaurante(new ObjectId());
    }

    @Test
    void findAll() throws Exception {
        List<ReservaDTO> reservas = Arrays.asList(reservaDTO);
        when(reservaService.findAll()).thenReturn(reservas);

        mockMvc.perform(get("/reservas")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idReserva").value("1"))
                .andExpect(jsonPath("$[0].reservasConfirmadas").value("Sim"));
    }

    @Test
    void inserirReserva() throws Exception {
        when(reservaService.inserirReserva(any(ReservaDTO.class))).thenReturn(reservaDTO);

        mockMvc.perform(post("/reservas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reservaDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idReserva").value("1"))
                .andExpect(jsonPath("$.reservasConfirmadas").value("Sim"));
    }

    @Test
    void updateReservasConfirmadas() throws Exception {
        when(reservaService.updateReservasConfirmadas(any(String.class), any(ReservaDTO.class))).thenReturn(reservaDTO);

        mockMvc.perform(put("/reservas/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reservaDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idReserva").value("1"))
                .andExpect(jsonPath("$.reservasConfirmadas").value("Sim"));
    }
}
