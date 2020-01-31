package br.com.deveficiente.calendario.controller;

import br.com.deveficiente.calendario.controller.form.EventoForm;
import br.com.deveficiente.calendario.controller.validacao.ConvidadosPrecisamEstarCadastrados;
import br.com.deveficiente.calendario.controller.validacao.DataFinalDepoisInicialEvento;
import br.com.deveficiente.calendario.controller.validacao.VerificaConflitoHorarioEvento;
import br.com.deveficiente.calendario.model.Usuario;
import br.com.deveficiente.calendario.repository.AgendaRepository;
import br.com.deveficiente.calendario.repository.ConvidadoEventoRepository;
import br.com.deveficiente.calendario.repository.EventoRepository;
import br.com.deveficiente.calendario.repository.UsuarioRepository;
import br.com.deveficiente.calendario.service.NovoEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private NovoEventoService novoEventoService;
    @Autowired
    private EventoRepository eventoRepository;

    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(new DataFinalDepoisInicialEvento(),
                new ConvidadosPrecisamEstarCadastrados(usuarioRepository),
                new VerificaConflitoHorarioEvento(eventoRepository));

    }

    @PostMapping
    public ResponseEntity cadastrar(@AuthenticationPrincipal Usuario usuario, @RequestBody @Valid EventoForm eventoForm) {
        novoEventoService.executa(usuario, eventoForm);
        return ResponseEntity.ok("Evento cadastrado com sucesso");
    }


}
