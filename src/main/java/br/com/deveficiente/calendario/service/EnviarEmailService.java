package br.com.deveficiente.calendario.service;

import br.com.deveficiente.calendario.model.ConvidadoEvento;
import br.com.deveficiente.calendario.repository.ConvidadoEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnviarEmailService {

    @Autowired
    private ConvidadoEventoRepository convidadoEventoRepository;

    @Async
    public void enviar(Long codEvento){
        List<ConvidadoEvento> convidadosEvento = convidadoEventoRepository.findByEvento_Id(codEvento);
        for(ConvidadoEvento c : convidadosEvento){
            System.out.println("ENVIAR EMAIL");
        }
    }
}
