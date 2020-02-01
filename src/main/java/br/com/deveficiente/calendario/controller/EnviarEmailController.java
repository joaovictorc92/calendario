package br.com.deveficiente.calendario.controller;

import br.com.deveficiente.calendario.service.EnviarEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enviar-email")
public class EnviarEmailController {

    @Autowired
    private EnviarEmailService enviarEmailService;

    @GetMapping("/{codEvento}")
    public void enviarEmailConvidados(@PathVariable Long codEvento){
        enviarEmailService.enviar(codEvento);
    }
}
