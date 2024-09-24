package reservaresturante.reservarestaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import reservaresturante.reservarestaurante.DTO.UsuarioDTO;
import reservaresturante.reservarestaurante.services.UsuarioService;

import java.net.URI;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping("/{usuarioId}")
    public ResponseEntity<UsuarioDTO> findByUsuarioId(@PathVariable Long usuarioId) {
        UsuarioDTO usuario = usuarioService.findByUsuarioId(usuarioId);
        return ResponseEntity.ok(usuario);
    }
    @PostMapping
    public ResponseEntity<UsuarioDTO> inserirUsuario(@RequestBody UsuarioDTO dto){
        dto = usuarioService.inserirUsuario(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getNome()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
