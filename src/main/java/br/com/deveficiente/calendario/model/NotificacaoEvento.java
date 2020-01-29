package br.com.deveficiente.calendario.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class NotificacaoEvento {
    @Id
    private Long id;
    @ManyToOne
    private Notificacao notificacao;
    @ManyToOne
    private Evento evento;
}
