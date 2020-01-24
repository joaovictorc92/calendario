package br.com.deveficiente.calendario.controller;

import br.com.deveficiente.calendario.controller.form.UsuarioForm;
import br.com.deveficiente.calendario.model.Agenda;
import br.com.deveficiente.calendario.model.Usuario;
import br.com.deveficiente.calendario.repository.AgendaRepository;
import br.com.deveficiente.calendario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private AgendaRepository agendaRepository;

    @Transactional
    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid UsuarioForm usuarioForm) {
        Usuario usuario = usuarioForm.converter();
        usuario = usuarioRepository.save(usuario);
        Agenda agenda = new Agenda(usuario.getNome(), "Agenda "+ usuario.getNome(), usuario);
        agendaRepository.save(agenda);
        return ResponseEntity.ok("Usuário  cadastrado");

    }
}
