package reservaresturante.reservarestaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import reservaresturante.reservarestaurante.DTO.RestauranteDTO;
import reservaresturante.reservarestaurante.entities.Restaurante;
import reservaresturante.reservarestaurante.services.RestauranteService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/restaurante")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }
    @GetMapping("/cep/{cep}")
    public ResponseEntity<List<RestauranteDTO>> findByLocalizacao_Cep(@PathVariable String cep) {
        List<RestauranteDTO> restaurantes = restauranteService.findByCep(cep);
        return ResponseEntity.ok(restaurantes);
    }
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<RestauranteDTO>> findByNome(@PathVariable String nome){
        List<RestauranteDTO> restaurante = restauranteService.findByNome(nome);
        return ResponseEntity.ok(restaurante);
    }


    @PostMapping
    public ResponseEntity<RestauranteDTO> inserirRestaurante(@RequestBody RestauranteDTO dto) {
        dto = restauranteService.inserirRestaurante(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getNome()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}
