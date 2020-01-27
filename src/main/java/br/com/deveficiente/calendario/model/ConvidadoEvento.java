package br.com.deveficiente.calendario.model;

import javax.persistence.*;

@Entity
public class ConvidadoEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Evento evento;
    @ManyToOne
    private Usuario convidado;

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void setConvidado(Usuario convidado) {
        this.convidado = convidado;
    }
}
