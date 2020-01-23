package br.com.deveficiente.calendario.controller.form;

import br.com.deveficiente.calendario.model.Usuario;
import lombok.Data;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.security.MessageDigest;
import java.util.Date;

@Data
public class UsuarioForm {

    @NotNull @NotEmpty @Email(message = "O login deve ser um email válido")
    private String login;
    @NotNull @NotEmpty @Length(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    private String senha;

    public Usuario converter(){
        String senhaCriptografada = DigestUtils.md5Hex(senha.getBytes()).toUpperCase();
        return new Usuario(login, senhaCriptografada);
    }
}
