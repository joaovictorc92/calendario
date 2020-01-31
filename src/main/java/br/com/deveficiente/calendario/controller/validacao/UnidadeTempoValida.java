package br.com.deveficiente.calendario.controller.validacao;

import br.com.deveficiente.calendario.controller.form.EventoForm;
import br.com.deveficiente.calendario.controller.form.NotificacaoForm;
import br.com.deveficiente.calendario.model.enums.UnidadeTempo;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UnidadeTempoValida implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return EventoForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        EventoForm eventoForm = (EventoForm) o;
        if(eventoForm.getNotificacoes() != null){
            for(NotificacaoForm n : eventoForm.getNotificacoes()){
                if(!UnidadeTempo.contains(n.getUnidadeTempo())){
                    errors.rejectValue("Notificacoes", "eventoForm.notificacoes.invalido", "UnidadeTempo inválido");
                }
            }
        }
    }
}
