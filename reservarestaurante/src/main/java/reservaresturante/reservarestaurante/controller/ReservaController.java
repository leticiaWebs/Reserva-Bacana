package reservaresturante.reservarestaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import reservaresturante.reservarestaurante.DTO.ReservaDTO;
import reservaresturante.reservarestaurante.services.ReservaService;

import java.net.URI;

@RestController
@RequestMapping(value = "/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping("/informacoesrestaurante")
    public ResponseEntity<ReservaDTO> inserirInformacoesRestaurante(@RequestBody ReservaDTO dto){
        dto = reservaService.inserirInformacoesRestaurante(dto);
        URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getRestauranteId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @PostMapping("/adicionarreserva")
    public ResponseEntity<ReservaDTO> inserirReserva(@RequestBody ReservaDTO dto){
        dto = reservaService.inserirReserva(dto);
        URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getReservaId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
