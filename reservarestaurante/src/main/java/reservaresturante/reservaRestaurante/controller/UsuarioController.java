package reservaresturante.reservaRestaurante.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import reservaresturante.reservaRestaurante.DTO.UsuarioDTO;
import reservaresturante.reservaRestaurante.service.UsuarioService;

import java.net.URI;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{usuarioId}")
    public ResponseEntity<UsuarioDTO> findByUsuarioId(@PathVariable("usuarioId") ObjectId objectIdUsuario) {
        UsuarioDTO usuario = usuarioService.findByUsuarioId(objectIdUsuario);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> inserirUsuario(@RequestBody UsuarioDTO dto) {
        dto = usuarioService.inserirUsuario(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getNome()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
