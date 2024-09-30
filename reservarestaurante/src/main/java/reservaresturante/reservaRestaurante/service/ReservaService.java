package reservaresturante.reservaRestaurante.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reservaresturante.reservaRestaurante.DTO.ReservaDTO;
import reservaresturante.reservaRestaurante.entities.Reserva;
import reservaresturante.reservaRestaurante.repositories.ReservaRepository;
import reservaresturante.reservaRestaurante.service.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    @Transactional
    public List<ReservaDTO> findAll() {
        List<Reserva> list = reservaRepository.findAll();
        return list.stream().map(ReservaDTO::new).collect(Collectors.toList());

    }

    public Reserva getReservaById(String idReserva) {
        Optional<Reserva> reserva = reservaRepository.findByIdReserva(idReserva);
        if (reserva.isPresent()) {
            return reserva.get();
        } else {
            throw new RuntimeException("Reserva não encontrada com o id: " + idReserva);
        }
    }

    @Transactional
    public ReservaDTO inserirReserva(ReservaDTO reservaDTO) {
        Reserva entity = new Reserva();
        entity.setIdReserva(reservaDTO.getIdReserva());
        entity.setDataReserva(reservaDTO.getDataReserva());
        entity.setReservasConfirmadas(reservaDTO.getReservasConfirmadas());
        entity.setHorarioReserva(reservaDTO.getHorarioReserva());
        entity.setObjectIdRestaurante(reservaDTO.getObjectIdRestaurante());
        reservaRepository.save(entity);
        return new ReservaDTO(entity);
    }

    public ReservaDTO updateReservasConfirmadas(String idReserva, ReservaDTO dto) {
        Optional<Reserva> optionalReserva = reservaRepository.findByIdReserva(idReserva);
        if (optionalReserva.isPresent()) {
            Reserva entity = optionalReserva.get();
            entity.setDataReserva(dto.getDataReserva());
            entity.setReservasConfirmadas(dto.getReservasConfirmadas());
            entity.setHorarioReserva(dto.getHorarioReserva());
            entity = reservaRepository.save(entity);
            return new ReservaDTO(entity);
        } else {
            throw new ResourceNotFoundException("Reserva não encontrada com o id: " + idReserva);
        }
    }
}
