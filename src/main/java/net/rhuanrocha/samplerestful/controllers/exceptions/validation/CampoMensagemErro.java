package net.rhuanrocha.samplerestful.controllers.exceptions.validation;

import java.io.Serializable;

public class CampoMensagemErro implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nomeMensagem;
    private String mensagem;

    public CampoMensagemErro(String nomeMensagem, String mensagem){
        this.nomeMensagem = nomeMensagem;
        this.mensagem = mensagem;
    }

    public String getNomeMensagem() {
        return nomeMensagem;
    }

    public void setNomeMensagem(String nomeMensagem) {
        this.nomeMensagem = nomeMensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
