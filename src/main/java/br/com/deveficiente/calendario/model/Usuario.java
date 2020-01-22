package br.com.deveficiente.calendario.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    @Pattern(regexp = "^[a-fA-F0-9]{32}$", message = "A senha deve ser criptografada em MD5")
    private String senha;
    private LocalDateTime dataCadastro;


    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
        this.dataCadastro = LocalDateTime.now();
    }
}
