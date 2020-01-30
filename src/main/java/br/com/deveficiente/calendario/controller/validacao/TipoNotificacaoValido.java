package br.com.deveficiente.calendario.controller.validacao;

import br.com.deveficiente.calendario.controller.form.EventoForm;
import br.com.deveficiente.calendario.controller.form.NotificacaoForm;
import br.com.deveficiente.calendario.model.enums.TipoNotificacao;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TipoNotificacaoValido implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return EventoForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        EventoForm eventoForm = (EventoForm) o;
        if(eventoForm.getNotificacoes()!=null){
            for(NotificacaoForm n : eventoForm.getNotificacoes()){
                if(!TipoNotificacao.contains(n.getTipoNotificacao())){
                    errors.rejectValue("Notificacoes", "eventoForm.notificacoes.invalido", "TipoNotificacao inválido");
                }
            }
        }
    }
}
