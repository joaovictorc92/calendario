package br.com.deveficiente.calendario.service;

import br.com.deveficiente.calendario.controller.form.EventoForm;
import br.com.deveficiente.calendario.model.ConvidadoEvento;
import br.com.deveficiente.calendario.model.Evento;
import br.com.deveficiente.calendario.model.Notificacao;
import br.com.deveficiente.calendario.model.Usuario;
import br.com.deveficiente.calendario.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    NotificacaoRepository notificacaoRepository;
    @Autowired
    EnviarEmailService enviarEmailService;

    public void executa(Usuario usuario, EventoForm eventoForm) {
        Evento evento = eventoForm.converter(agendaRepository, usuario);
        evento = eventoRepository.save(evento);
        List<ConvidadoEvento> convidadosEvento = new ArrayList<>();
        for (String u : eventoForm.getConvidados()) {
            Usuario convidado = usuarioRepository.findByLogin(u).get();
            ConvidadoEvento convidadoEvento = new ConvidadoEvento(evento, convidado);
            convidadosEvento.add(convidadoEvento);
            convidadoEventoRepository.save(convidadoEvento);

        }
        salvarNotificacoes(eventoForm, evento);
        enviarEmailService.enviar(convidadosEvento);
    }

    private void salvarNotificacoes(EventoForm eventoForm, Evento evento) {
        for (Notificacao notificacao : eventoForm.getNotificacoesParaSalvar(evento)) {
            notificacaoRepository.save(notificacao);
        }
    }

}
