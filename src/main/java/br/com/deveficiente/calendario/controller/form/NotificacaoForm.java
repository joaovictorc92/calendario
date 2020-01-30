package br.com.deveficiente.calendario.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class NotificacaoForm {

    @NotEmpty(message = "Informe o tipo de notificação")
    private String tipoNotificacao;
    @NotNull
    private Integer quantidadeTempo;
    @NotEmpty(message = "Informe a unidade de tempo")
    private String unidadeTempo;

    public String getTipoNotificacao() {
        return tipoNotificacao;
    }

    public void setTipoNotificacao(String tipoNotificacao) {
        this.tipoNotificacao = tipoNotificacao;
    }

    public Integer getQuantidadeTempo() {
        return quantidadeTempo;
    }

    public void setQuantidadeTempo(Integer quantidadeTempo) {
        this.quantidadeTempo = quantidadeTempo;
    }

    public String getUnidadeTempo() {
        return unidadeTempo;
    }

    public void setUnidadeTempo(String unidadeTempo) {
        this.unidadeTempo = unidadeTempo;
    }
}
