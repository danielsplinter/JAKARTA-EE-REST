package net.rhuanrocha.samplerestful.services.exceptions;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String mensagem){
        super(mensagem);
    }
}
