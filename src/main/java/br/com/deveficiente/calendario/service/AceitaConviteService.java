package br.com.deveficiente.calendario.service;

import br.com.deveficiente.calendario.model.ConvidadoEvento;
import br.com.deveficiente.calendario.model.Evento;
import br.com.deveficiente.calendario.repository.ConvidadoEventoRepository;
import br.com.deveficiente.calendario.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AceitaConviteService {

    @Autowired
    private ConvidadoEventoRepository convidadoEventoRepository;
    @Autowired
    private EventoRepository eventoRepository;

    public ResponseEntity executa(Long codConvidadoEvento) {
        ConvidadoEvento convidadoEvento = convidadoEventoRepository.findById(codConvidadoEvento).get();
        if (convidadoEvento.getEvento().passouDoHorario()) {
            return ResponseEntity.notFound().build();
        }
        if (!convidadoEvento.jaAceitouConvite()) {
            convidadoEvento.aceitarConvite();
            //convidadoEventoRepository.save(convidadoEvento);
            Evento evento = new Evento(convidadoEvento.getEvento().getTitulo(),
                    convidadoEvento.getEvento().getInicio(),
                    convidadoEvento.getEvento().getFim(),
                    convidadoEvento.getEvento().getDescricao(),
                    convidadoEvento.getEvento().getAgenda(),
                    convidadoEvento.getConvidado()
            );
            eventoRepository.save(evento);
        }
        return ResponseEntity.ok().build();
    }
}
