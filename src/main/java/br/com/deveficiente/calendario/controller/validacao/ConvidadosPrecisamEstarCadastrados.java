package br.com.deveficiente.calendario.controller.validacao;

import br.com.deveficiente.calendario.controller.form.EventoForm;
import br.com.deveficiente.calendario.model.Usuario;
import br.com.deveficiente.calendario.repository.UsuarioRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.Optional;

public class ConvidadosPrecisamEstarCadastrados implements Validator {
    private UsuarioRepository usuarioRepository;

    public ConvidadosPrecisamEstarCadastrados(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return EventoForm.class.isAssignableFrom(aClass);

    }

    @Override
    public void validate(Object o, Errors errors) {
        EventoForm eventoForm = (EventoForm) o;
        for(String u : eventoForm.getConvidados()){
            Optional<Usuario> usuario = usuarioRepository.findByLogin(u);
            if(!usuario.isPresent()){
                errors.rejectValue("convidados", "eventoForm.convidados.invalido", "Todos os convidaados devem estar cadastrados");
            }
        }
    }
}
