package br.com.deveficiente.calendario.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String senha;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;

    public Usuario(){

    }

    public Usuario(String login, String senha, Date dataCadastro) {
        this.login = login;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
    }
}
