package br.com.deveficiente.calendario.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private String descricao;
    @ManyToOne
    private Agenda agenda;
    @ManyToOne
    private Usuario usuarioCriadorEvento;

    @Deprecated
    public Evento() {

    }

    public Evento(String titulo, LocalDateTime inicio, LocalDateTime fim, String descricao, Agenda agenda, Usuario usuarioCriadorEvento) {
        this.titulo = titulo;
        this.inicio = inicio;
        this.fim = fim;
        this.descricao = descricao;
        this.agenda = agenda;
        this.usuarioCriadorEvento = usuarioCriadorEvento;
    }

    public Evento(ConvidadoEvento convidadoEvento) {
        this.agenda = convidadoEvento.getEvento().getAgenda();
        this.titulo = convidadoEvento.getEvento().getTitulo();
        this.descricao = convidadoEvento.getEvento().getDescricao();
        this.inicio = convidadoEvento.getEvento().getInicio();
        this.fim = convidadoEvento.getEvento().getFim();
        this.usuarioCriadorEvento = convidadoEvento.getConvidado();
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public String getDescricao() {
        return descricao;
    }
}
