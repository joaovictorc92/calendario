package br.com.deveficiente.calendario.controller.form;

import br.com.deveficiente.calendario.model.Usuario;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UsuarioForm {
    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty @Email(message = "O login deve ser um email válido")
    private String login;
    @NotNull @NotEmpty @Length(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    private String senha;

    public Usuario converter(){
        String senhaCriptografada = DigestUtils.md5Hex(senha.getBytes()).toUpperCase();
        return new Usuario(nome,login, senhaCriptografada);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
