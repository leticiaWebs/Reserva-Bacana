package reservaresturante.reservarestaurante.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reservaresturante.reservarestaurante.DTO.RestauranteDTO;
import reservaresturante.reservarestaurante.entities.Restaurante;
import reservaresturante.reservarestaurante.repositories.RestauranteRepository;
import reservaresturante.reservarestaurante.services.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public RestauranteService(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    @Transactional(readOnly = true)
    public List<RestauranteDTO> findByCep(String cep) {
        List<Restaurante> restaurantes = restauranteRepository.findByLocalizacao_Cep(cep);
        if (restaurantes.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum restaurante encontrado com o CEP: " + cep);
        }
        return restaurantes.stream()
                .map(RestauranteDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<RestauranteDTO>findByNome(String nome){
        List<Restaurante> restaurantes = restauranteRepository.findByNome(nome);
        if(restaurantes.isEmpty()){
            throw new ResourceNotFoundException("Nenhum restaurante encontrado com o nome: " + nome);
        }
        return restaurantes.stream()
                .map(RestauranteDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public RestauranteDTO inserirRestaurante(RestauranteDTO restauranteDTO) {
        Restaurante entity = new Restaurante();
        entity.setRestauranteId(restauranteDTO.getRestauranteId());
        entity.setNome(restauranteDTO.getNome());
        entity.setTipoCozinha(restauranteDTO.getTipoCozinha());
        entity.setLocalizacao(restauranteDTO.getLocalizacao());
        restauranteRepository.save(entity);
        return new RestauranteDTO(entity);

    }

}
