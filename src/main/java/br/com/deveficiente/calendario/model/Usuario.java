package br.com.deveficiente.calendario.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String login;
    @Pattern(regexp = "^[a-fA-F0-9]{32}$", message = "A senha deve ser criptografada em MD5")
    private String senha;
    private LocalDateTime dataCadastro;


    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.dataCadastro = LocalDateTime.now();
    }


    public String getNome() {
        return nome;
    }

}
