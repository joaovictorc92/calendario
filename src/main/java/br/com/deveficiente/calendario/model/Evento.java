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

    public Evento(String titulo, LocalDateTime inicio, LocalDateTime fim, String descricao, Agenda agenda, Usuario usuarioCriadorEvento) {
        this.titulo = titulo;
        this.inicio = inicio;
        this.fim = fim;
        this.descricao = descricao;
        this.agenda = agenda;
        this.usuarioCriadorEvento = usuarioCriadorEvento;
    }
}
