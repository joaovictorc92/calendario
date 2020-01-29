package br.com.deveficiente.calendario.controller.validacao;

import br.com.deveficiente.calendario.controller.form.EventoForm;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class DataFinalDepoisInicialEvento implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return EventoForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        EventoForm eventoForm = (EventoForm) o;
        if(!eventoForm.validaFimDepoisdoInicio()){
            errors.rejectValue("Fim", "eventoForm.fim.invalido", "Data final deve vir depois da inicial");
        }
    }
}
