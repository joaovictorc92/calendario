package br.com.deveficiente.calendario.controller.form;

import br.com.deveficiente.calendario.model.Agenda;
import br.com.deveficiente.calendario.model.Pessoa;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AgendaForm {
    @NotNull
    @NotEmpty(message = "É necessário informar a descrição")
    @Length(max = 255, message = "Limite de caracteres para a descricao é de 255 caracteres")
    private String descricao;
    @NotNull @NotEmpty
    private PessoaForm pessoa;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public PessoaForm getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaForm pessoa) {
        this.pessoa = pessoa;
    }

    public Agenda converter(Pessoa pessoa){
        return new Agenda(descricao, pessoa);
    }
}
