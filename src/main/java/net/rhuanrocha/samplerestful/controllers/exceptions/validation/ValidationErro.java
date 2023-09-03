package net.rhuanrocha.samplerestful.controllers.exceptions.validation;

import net.rhuanrocha.samplerestful.controllers.exceptions.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class ValidationErro extends ObjectError {
    List<CampoMensagemErro> campoMensagemErroList = new ArrayList<>();

    public List<CampoMensagemErro> getCampoMensagemErroList() {
        return campoMensagemErroList;
    }

    public void setCampoMensagemErroList(List<CampoMensagemErro> campoMensagemErroList) {
        this.campoMensagemErroList = campoMensagemErroList;
    }
}
