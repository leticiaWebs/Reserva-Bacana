package reservaresturante.reservarestaurante.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import reservaresturante.reservarestaurante.DTO.AvaliacaoDTO;
import reservaresturante.reservarestaurante.DTO.RestauranteDTO;
import reservaresturante.reservarestaurante.repositories.AvaliacaoRepository;
import reservaresturante.reservarestaurante.services.AvaliacaoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;



    @PostMapping
    public ResponseEntity<AvaliacaoDTO> inserirAvaliacao(@RequestBody AvaliacaoDTO dto) {
        dto = avaliacaoService.inserirAvaliacao(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getAvaliacaoId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
