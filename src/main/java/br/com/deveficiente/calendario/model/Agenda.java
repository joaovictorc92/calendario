package br.com.deveficiente.calendario.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @NotNull
    @NotEmpty
    @Length(max = 255, message = "A descrição deve ter no máximo 255 caracteres")
    private String descricao;
    @NotNull
    @ManyToOne
    private Usuario usuario;

    @Deprecated
    public Agenda() {
    }

    public Agenda(Usuario usuario) {
        this.nome = usuario.getNome();
        this.descricao = "Agenda "+ usuario.getNome();
        this.usuario = usuario;
    }

}
