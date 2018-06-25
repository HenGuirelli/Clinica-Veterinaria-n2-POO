package br.com.fatec.excecoes;

public class DataInvalidaException extends RuntimeException{
    public DataInvalidaException(){
        super();
    }
    public DataInvalidaException(String e){
        super(e);
    }
}
