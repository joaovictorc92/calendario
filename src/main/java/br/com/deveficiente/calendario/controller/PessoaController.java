package br.com.deveficiente.calendario.controller;

import br.com.deveficiente.calendario.controller.form.AgendaForm;
import br.com.deveficiente.calendario.model.Agenda;
import br.com.deveficiente.calendario.model.Pessoa;
import br.com.deveficiente.calendario.repository.AgendaRepository;
import br.com.deveficiente.calendario.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private AgendaRepository agendaRepository;

    @PostMapping
    public ResponseEntity cadastrarPessoa(@RequestBody AgendaForm agendaForm){
        Pessoa pessoa = agendaForm.getPessoa().converter();
        pessoa = pessoaRepository.save(pessoa);
        Agenda agenda = agendaForm.converter(pessoa);
        agendaRepository.save(agenda);
        return ResponseEntity.ok("Pessoa cadastrada com sucesso");
    }
}
