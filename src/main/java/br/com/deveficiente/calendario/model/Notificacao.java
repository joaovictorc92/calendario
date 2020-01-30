package br.com.deveficiente.calendario.model;

import br.com.deveficiente.calendario.model.enums.TipoNotificacao;
import br.com.deveficiente.calendario.model.enums.UnidadeTempo;

import javax.persistence.*;

@Entity
public class Notificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoNotificacao tipoNotificacao;
    private Integer quantidadeTempo;
    @Enumerated(EnumType.STRING)
    private UnidadeTempo unidadeTempo;
    @ManyToOne
    private Evento evento;

    public Notificacao(TipoNotificacao tipoNotificacao, Integer quantidadeTempo, UnidadeTempo unidadeTempo, Evento evento) {
        this.tipoNotificacao = tipoNotificacao;
        this.quantidadeTempo = quantidadeTempo;
        this.unidadeTempo = unidadeTempo;
        this.evento = evento;
    }
}
