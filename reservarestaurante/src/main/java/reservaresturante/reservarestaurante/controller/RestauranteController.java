package reservaresturante.reservarestaurante.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import reservaresturante.reservarestaurante.DTO.RestauranteDTO;
import reservaresturante.reservarestaurante.entities.Restaurante;
import reservaresturante.reservarestaurante.entities.utils.Enuns.TipoCozinha;
import reservaresturante.reservarestaurante.repositories.RestauranteRepository;
import reservaresturante.reservarestaurante.service.RestauranteService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/restaurante")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    private RestauranteRepository restauranteRepository;

    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<List<RestauranteDTO>> findByLocalizacao_Cep(@PathVariable String cep) {
        List<RestauranteDTO> restaurantes = restauranteService.findByCep(cep);
        return ResponseEntity.ok(restaurantes);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<RestauranteDTO>> findByNome(@PathVariable String nome) {
        List<RestauranteDTO> restaurante = restauranteService.findByNome(nome);
        return ResponseEntity.ok(restaurante);
    }

  @GetMapping("tipoCozinha/{tipoCozinha}")
  public ResponseEntity<List<RestauranteDTO>> findByTipoCozinha(@PathVariable TipoCozinha tipoCozinha) {
      List<RestauranteDTO> restaurante = restauranteService.findByTipoCozinha(tipoCozinha);
      return ResponseEntity.ok().body(restaurante);
  }

    @PostMapping
    public ResponseEntity<RestauranteDTO> inserirRestaurante(@RequestBody RestauranteDTO dto) {
        dto = restauranteService.inserirRestaurante(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getNome()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}
