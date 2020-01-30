package br.com.deveficiente.calendario.controller.validacao;

import br.com.deveficiente.calendario.controller.form.EventoForm;
import br.com.deveficiente.calendario.model.Evento;
import br.com.deveficiente.calendario.repository.EventoRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

public class VerificaConflitoHorarioEvento implements Validator {
    private EventoRepository eventoRepository;

    public VerificaConflitoHorarioEvento(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return EventoForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        EventoForm eventoForm = (EventoForm) o;
        List<Evento> eventos = eventoRepository.findEventosConflituosos(eventoForm.getInicio(), eventoForm.getFim());
        if(eventos!=null && !eventos.isEmpty()){
            errors.reject("Eventos com conflitos de horarios");

        }
    }
}
