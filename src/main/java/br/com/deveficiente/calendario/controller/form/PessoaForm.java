package br.com.deveficiente.calendario.controller.form;


import br.com.deveficiente.calendario.model.Pessoa;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PessoaForm {

    @NotNull
    @NotEmpty(message = "É necessário informar o nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa converter(){
        return new Pessoa(nome);
    }
}
