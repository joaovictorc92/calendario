package br.com.deveficiente.calendario.controller;

import br.com.deveficiente.calendario.controller.form.EventoForm;
import br.com.deveficiente.calendario.model.Agenda;
import br.com.deveficiente.calendario.model.ConvidadoEvento;
import br.com.deveficiente.calendario.model.Evento;
import br.com.deveficiente.calendario.model.Usuario;
import br.com.deveficiente.calendario.repository.AgendaRepository;
import br.com.deveficiente.calendario.repository.ConvidadoEventoRepository;
import br.com.deveficiente.calendario.repository.EventoRepository;
import br.com.deveficiente.calendario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/evento")
public class EventoController {

    private List<Usuario> usuariosConvidados;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private AgendaRepository agendaRepository;
    @Autowired
    private ConvidadoEventoRepository convidadoEventoRepository;
    private String message;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid EventoForm eventoForm){
        if(validaData(eventoForm) && todosConvidadosCadastrados(eventoForm.getConvidados())){
            Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Agenda agenda = agendaRepository.findById(eventoForm.getCodAgenda()).get();
            Evento evento = eventoForm.converter(agenda, usuario);
            evento = eventoRepository.save(evento);

            for(Usuario u: usuariosConvidados){
                ConvidadoEvento convidadoEvento = new ConvidadoEvento();
                convidadoEvento.setConvidado(u);
                convidadoEvento.setEvento(evento);
                convidadoEventoRepository.save(convidadoEvento);

            }
            return ResponseEntity.ok("Evento cadastrado com sucesso");

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
    }

    //GOSTARIA DE SUGESTÕES PARA MELHORAR A ORGANIZAÇÃO DESSA VALIDAÇÃO
    private boolean validaData(@Valid EventoForm eventoForm) {
        message = !eventoForm.validaFimDepoisdoInicio()?"Fim deve ser depois do início":"";
        return eventoForm.validaFimDepoisdoInicio();
    }
    //GOSTARIA DE SUGESTÕES PARA MELHORAR A ORGANIZAÇÃO DESSA VALIDAÇÃO TAMBEM
    private boolean todosConvidadosCadastrados(List<String> convidados) {
        usuariosConvidados = new ArrayList<>();
        for(String c : convidados){
            Optional<Usuario> usuario = usuarioRepository.findByLogin(c);
            if(usuario.isPresent()){
                usuariosConvidados.add(usuario.get());
            }else{
                message = "Todos os usuários devem ser cadastrados";
                return false;
            }
        }
        return true;
    }


}
