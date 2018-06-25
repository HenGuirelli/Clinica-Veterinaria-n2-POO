package br.com.fatec.excecoes;

public class ComboBoxInvalidoException extends RuntimeException{
    public ComboBoxInvalidoException(){
        super();
    }
    public ComboBoxInvalidoException(String combo){
        super(combo);
    }
}
