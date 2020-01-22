package br.com.deveficiente.calendario.controller;

import br.com.deveficiente.calendario.controller.form.UsuarioForm;
import br.com.deveficiente.calendario.model.Usuario;
import br.com.deveficiente.calendario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid UsuarioForm usuarioForm) {
        Usuario usuario = usuarioForm.converter();

        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuário  cadastrado");

    }
}
