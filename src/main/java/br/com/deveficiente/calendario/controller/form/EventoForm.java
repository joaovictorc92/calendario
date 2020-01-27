package br.com.deveficiente.calendario.controller.form;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public class EventoForm {
    @NotNull @NotEmpty @Length(max = 100, message = "O título não pode ultrapassar 100 caracteres")
    private String titulo;
    @NotNull @NotNull @Length(max = 255, message = "O título não pode ultrapassar 255 caracteres")
    private String descricao;
    @Future
    private LocalDateTime inicio;
    @Future
    private LocalDateTime fim;
    private List<String> convidados;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

    public List<String> getConvidados() {
        return convidados;
    }

    public void setConvidados(List<String> convidados) {
        this.convidados = convidados;
    }
}
