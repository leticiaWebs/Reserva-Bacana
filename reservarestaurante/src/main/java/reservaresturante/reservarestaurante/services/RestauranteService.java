package reservaresturante.reservarestaurante.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reservaresturante.reservarestaurante.DTO.RestauranteDTO;
import reservaresturante.reservarestaurante.entities.Restaurante;
import reservaresturante.reservarestaurante.entities.utils.Enuns.TipoCozinha;
import reservaresturante.reservarestaurante.repositories.RestauranteRepository;
import reservaresturante.reservarestaurante.services.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Transactional
    public List<RestauranteDTO> findAll(){
        List<Restaurante> list = restauranteRepository.findAll();
        return list.stream().map(RestauranteDTO::new).collect(Collectors.toList());
    }
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
    @Transactional(readOnly = true)
    public List<RestauranteDTO> findByTipoCozinha(TipoCozinha tipoCozinha) {
        List<Restaurante> restaurantes = restauranteRepository.findByTipoCozinha(tipoCozinha);
        if (restaurantes.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum restaurante encontrado com a cozinha: " + tipoCozinha);
        }
        return restaurantes.stream()
                .map(RestauranteDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public RestauranteDTO inserirRestaurante(RestauranteDTO restauranteDTO) {
        Restaurante entity = new Restaurante();
        entity.setObjectIdRestaurante(restauranteDTO.getObjectIdRestaurante());
        entity.setNome(restauranteDTO.getNome());
        entity.setTipoCozinha(restauranteDTO.getTipoCozinha());
        entity.setLocalizacao(restauranteDTO.getLocalizacao());
        entity.setCapacidade(restauranteDTO.getCapacidade());
        entity.setDiasDeFuncionamento(restauranteDTO.getDiasDeFuncionamento());
        entity.setHorarioDeAbertura(restauranteDTO.getHorarioDeAbertura());
        entity.setHorarioDeEncerramento(restauranteDTO.getHorarioDeEncerramento());
        restauranteRepository.save(entity);
        return new RestauranteDTO(entity);

    }

}
