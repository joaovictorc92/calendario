package br.com.deveficiente.calendario.controller.form;

import br.com.deveficiente.calendario.model.enums.TipoNotificacao;
import br.com.deveficiente.calendario.model.enums.UnidadeTempo;

import javax.validation.constraints.NotNull;

public class NotificacaoForm {

    @NotNull
    private TipoNotificacao tipoNotificacao;
    @NotNull
    private Integer quantidadeTempo;
    @NotNull
    private UnidadeTempo unidadeTempo;

    public TipoNotificacao getTipoNotificacao() {
        return tipoNotificacao;
    }

    public void setTipoNotificacao(TipoNotificacao tipoNotificacao) {
        this.tipoNotificacao = tipoNotificacao;
    }

    public Integer getQuantidadeTempo() {
        return quantidadeTempo;
    }

    public void setQuantidadeTempo(Integer quantidadeTempo) {
        this.quantidadeTempo = quantidadeTempo;
    }

    public UnidadeTempo getUnidadeTempo() {
        return unidadeTempo;
    }

    public void setUnidadeTempo(UnidadeTempo unidadeTempo) {
        this.unidadeTempo = unidadeTempo;
    }
}
