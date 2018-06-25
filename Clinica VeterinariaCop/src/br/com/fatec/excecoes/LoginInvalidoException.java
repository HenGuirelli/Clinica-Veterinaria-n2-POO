package br.com.fatec.excecoes;

public class LoginInvalidoException extends Exception{
    public LoginInvalidoException(){
        super();
    }
    public LoginInvalidoException(String e){
        super(e);
    }
}
