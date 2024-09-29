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
        entity.setObjectIdAvaliacao(avaliacaoDTO.getObjectIdAvaliacao());
        entity.setComentarios(avaliacaoDTO.getComentarios());
        entity.setNota(avaliacaoDTO.getNota());
        entity.setObjectIdRestaurante(avaliacaoDTO.getObjectIdRestaurante());
        entity.setObjectIdUsuario(avaliacaoDTO.getObjectIdUsuario());
        avaliacaoRepository.save(entity);
        return new AvaliacaoDTO(entity);

    }

}
