package br.com.deveficiente.calendario.controller.form;

import br.com.deveficiente.calendario.model.Agenda;
import br.com.deveficiente.calendario.model.Evento;
import br.com.deveficiente.calendario.model.Notificacao;
import br.com.deveficiente.calendario.model.Usuario;
import br.com.deveficiente.calendario.repository.AgendaRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventoForm implements Serializable {
    @NotNull
    @NotEmpty
    @Length(max = 100, message = "O título não pode ultrapassar 100 caracteres")
    private String titulo;
    @NotNull
    @NotNull
    @Length(max = 255, message = "O título não pode ultrapassar 255 caracteres")
    private String descricao;
    @Future
    private LocalDateTime inicio;
    @Future
    private LocalDateTime fim;

    private Long codAgenda;

    @NotEmpty(message = "Adicione pelo menos um convidado para criar o evento")
    private List<@Email String> convidados = new ArrayList<>();

    private List<NotificacaoForm> notificacoes = new ArrayList<>();

    private AgendaRepository agendaRepository;

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

    public Long getCodAgenda() {
        return codAgenda;
    }

    public void setCodAgenda(Long codAgenda) {
        this.codAgenda = codAgenda;
    }

    public boolean validaFimDepoisdoInicio() {
        return fim.isAfter(inicio);
    }

    public List<NotificacaoForm> getNotificacoes() {
        return notificacoes;
    }

    public void setNotificacoes(List<NotificacaoForm> notificacoes) {
        this.notificacoes = notificacoes;
    }

    public Evento converter(AgendaRepository agendaRepository, Usuario usuario) {
        Agenda agenda = agendaRepository.findById(codAgenda).get();
        return new Evento(titulo, inicio, fim, descricao, agenda, usuario);
    }

    public List<Notificacao> getNotificacoesParaSalvar(Evento evento) {
        List<Notificacao> retorno = new ArrayList<>();
        for (NotificacaoForm n : notificacoes) {
            retorno.add(new Notificacao(n.getTipoNotificacao(),
                    n.getQuantidadeTempo(),
                    n.getUnidadeTempo(), evento));
        }
        return retorno;
    }
}
