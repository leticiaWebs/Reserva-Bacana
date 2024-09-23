package reservaresturante.reservarestaurante.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reservaresturante.reservarestaurante.DTO.AvaliacaoDTO;
import reservaresturante.reservarestaurante.entities.Avaliacao;
import reservaresturante.reservarestaurante.repositories.AvaliacaoRepository;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Transactional
    public AvaliacaoDTO inserirAvaliacao(AvaliacaoDTO avaliacaoDTO){
        Avaliacao entity = new Avaliacao();
        entity.setAvaliacaoId(avaliacaoDTO.getAvaliacaoId());
        entity.setComentarios(avaliacaoDTO.getComentarios());
        entity.setNotas(avaliacaoDTO.getNotas());
        entity.setRestauranteId(avaliacaoDTO.getRestauranteId());
        entity.setUsuarioId(avaliacaoDTO.getUsuarioId());
        avaliacaoRepository.save(entity);
        return new AvaliacaoDTO(entity);

    }

}
