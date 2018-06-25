package br.com.fatec.excecoes;

public class CampoInvalidoException extends RuntimeException {
    public CampoInvalidoException(){
        super();
    }
    public CampoInvalidoException(String campo){
        super(campo);
    }
}
