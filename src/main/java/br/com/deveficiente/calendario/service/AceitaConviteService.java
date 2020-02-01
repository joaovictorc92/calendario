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

    public ResponseEntity executa(Long codConvidadoEvento){
        ConvidadoEvento convidadoEvento = convidadoEventoRepository.findById(codConvidadoEvento).get();
        if(LocalDateTime.now().isAfter(convidadoEvento.getEvento().getInicio())){
            return ResponseEntity.notFound().build();
        }
        //AQUI PRECISEI VERIFICAR NULO PARA SABER SE ELE JA ACEITOU CONVITE, GOSTARIA DE SUGESTÕES
        if(convidadoEvento.getDataAceitaConvite() == null) {
            convidadoEvento.setDataAceitaConvite(LocalDateTime.now());
            convidadoEventoRepository.save(convidadoEvento);
            Evento evento = new Evento(convidadoEvento);
            eventoRepository.save(evento);
        }
        return ResponseEntity.ok().build();
    }
}
