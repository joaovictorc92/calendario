package br.com.deveficiente.calendario.controller;

import br.com.deveficiente.calendario.service.AceitaConviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/aceitar")
public class AceitarConviteController {

    @Autowired
    private AceitaConviteService aceitaConviteService;

    @Transactional
    @GetMapping("/{convidadoEvento}")
    public ResponseEntity aceitarConvite(@PathVariable("convidadoEvento") Long codconvidadoEvento){
        return aceitaConviteService.executa(codconvidadoEvento);

    }
}
