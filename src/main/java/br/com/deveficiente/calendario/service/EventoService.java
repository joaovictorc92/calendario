package br.com.deveficiente.calendario.service;

import br.com.deveficiente.calendario.controller.form.EventoForm;
import br.com.deveficiente.calendario.model.ConvidadoEvento;
import br.com.deveficiente.calendario.model.Evento;
import br.com.deveficiente.calendario.model.Usuario;
import br.com.deveficiente.calendario.repository.AgendaRepository;
import br.com.deveficiente.calendario.repository.ConvidadoEventoRepository;
import br.com.deveficiente.calendario.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Service
public class EventoService {

    @Autowired
    EventoRepository eventoRepository;
    @Autowired
    ConvidadoEventoRepository convidadoEventoRepository;
    @Autowired
    AgendaRepository agendaRepository;

    public void salvarEvento(Usuario usuario, @RequestBody @Valid EventoForm eventoForm, List<Usuario> convidados) {
        Evento evento = eventoForm.converter(agendaRepository, usuario);
        evento = eventoRepository.save(evento);

        for(Usuario u: convidados){
            ConvidadoEvento convidadoEvento = new ConvidadoEvento(evento,u);
            convidadoEventoRepository.save(convidadoEvento);

        }
    }

}
