package reservaresturante.reservarestaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import reservaresturante.reservarestaurante.DTO.AvaliacaoDTO;
import reservaresturante.reservarestaurante.service.AvaliacaoService;

import java.net.URI;

@RestController
@RequestMapping(value = "/avaliacao")
public class AvaliacaoController {
    @Autowired
    private AvaliacaoService avaliacaoService;

    @PostMapping
    public ResponseEntity<AvaliacaoDTO> inserirAvaliacao(@RequestBody AvaliacaoDTO dto) {
        dto = avaliacaoService.inserirAvaliacao(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getObjectIdAvaliacao()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
