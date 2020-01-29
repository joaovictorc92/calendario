package br.com.deveficiente.calendario.service;

import br.com.deveficiente.calendario.controller.form.EventoForm;
import br.com.deveficiente.calendario.model.ConvidadoEvento;
import br.com.deveficiente.calendario.model.Evento;
import br.com.deveficiente.calendario.model.Usuario;
import br.com.deveficiente.calendario.repository.AgendaRepository;
import br.com.deveficiente.calendario.repository.ConvidadoEventoRepository;
import br.com.deveficiente.calendario.repository.EventoRepository;
import br.com.deveficiente.calendario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Service
public class NovoEventoService {

    @Autowired
    EventoRepository eventoRepository;
    @Autowired
    ConvidadoEventoRepository convidadoEventoRepository;
    @Autowired
    AgendaRepository agendaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    public void executa(Usuario usuario, @RequestBody @Valid EventoForm eventoForm) {
        Evento evento = eventoForm.converter(agendaRepository, usuario);
        evento = eventoRepository.save(evento);

        for(String u: eventoForm.getConvidados()){
            Usuario convidado = usuarioRepository.findByLogin(u).get();
            ConvidadoEvento convidadoEvento = new ConvidadoEvento(evento,convidado);
            convidadoEventoRepository.save(convidadoEvento);

        }
    }

}
