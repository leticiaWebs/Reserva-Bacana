package reservaresturante.reservarestaurante.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import reservaresturante.reservarestaurante.entities.Restaurante;
import reservaresturante.reservarestaurante.entities.utils.Enuns.TipoCozinha;

import java.util.List;

@Repository
public interface RestauranteRepository extends MongoRepository<Restaurante, ObjectId> {
    List<Restaurante> findByLocalizacao_Cep(String cep);

    List<Restaurante> findByNome(String nome);

    List<Restaurante> findByTipoCozinha(TipoCozinha tipoCozinha);
}
