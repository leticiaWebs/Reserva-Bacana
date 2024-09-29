package reservaresturante.reservarestaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reservaresturante.reservarestaurante.DTO.ReservaDTO;
import reservaresturante.reservarestaurante.entities.Reserva;
import reservaresturante.reservarestaurante.services.ReservaService;

import java.util.List;

@RestController
@RequestMapping(value = "/reservas")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public ResponseEntity<List<ReservaDTO>> findAll() {
        List<ReservaDTO> reservas = reservaService.findAll();
        return ResponseEntity.ok(reservas);
    }

    @GetMapping(value = "/{idReserva}")
    public Reserva getReservaById(@PathVariable String idReserva) {
        return reservaService.getReservaById(idReserva);
    }

    // Endpoint para inserir uma nova reserva
    @PostMapping
    public ResponseEntity<ReservaDTO> inserirReserva(@RequestBody ReservaDTO reservaDTO) {
        ReservaDTO novaReserva = reservaService.inserirReserva(reservaDTO);
        return ResponseEntity.ok(novaReserva);
    }
    @PutMapping (value = "/{idReserva}")
    public ResponseEntity<ReservaDTO> insert (@PathVariable String idReserva, @RequestBody ReservaDTO dto) {
        dto = reservaService.updateReservasConfirmadas(idReserva, dto);
        return ResponseEntity.ok().body(dto);
    }


}

