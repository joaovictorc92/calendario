package br.com.deveficiente.calendario.service;

import br.com.deveficiente.calendario.model.ConvidadoEvento;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnviarEmailService {

    @Async
    public void enviar(List<ConvidadoEvento> convidadosEvento){
        for(ConvidadoEvento c : convidadosEvento){
            System.out.println("ENVIAR EMAIL");
        }
    }
}
