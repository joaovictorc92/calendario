package br.com.deveficiente.calendario.model;

import br.com.deveficiente.calendario.model.enums.TipoNotificacaoEnum;
import br.com.deveficiente.calendario.model.enums.UnidadeTempoEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Notificacao {
    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoNotificacaoEnum tipoNotificacao;
    private Integer quantidadeTempo;
    @Enumerated(EnumType.STRING)
    private UnidadeTempoEnum unidadeTempoEnum;
}
