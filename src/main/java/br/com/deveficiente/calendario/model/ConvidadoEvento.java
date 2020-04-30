package br.com.deveficiente.calendario.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
public class ConvidadoEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Evento evento;
    @ManyToOne
    private Usuario convidado;
    private LocalDateTime dataAceitaConvite;

    @Deprecated
    public ConvidadoEvento() {
    }

    public ConvidadoEvento(Evento evento, Usuario convidado) {
        this.evento = evento;
        this.convidado = convidado;
    }

    public void setDataAceitaConvite(LocalDateTime dataAceitaConvite) {
        this.dataAceitaConvite = dataAceitaConvite;
    }

    public Boolean jaAceitouConvite() {
        return Optional.ofNullable(dataAceitaConvite).isPresent();
    }

    public void aceitarConvite(){
        this.dataAceitaConvite = LocalDateTime.now();
    }

    public Evento getEvento() {
        return evento;
    }

    public Usuario getConvidado() {
        return convidado;
    }

    public Long getId() {
        return id;
    }
}
