/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.model;

import br.com.fatec.Enum.EnumTipoConta;
import br.com.fatec.excecoes.CampoInvalidoException;

/**
 *
 * @author henrique
 */
public class Usuario {
    private String login;
    private String senha;
    private boolean primeiroAcesso;
    private EnumTipoConta tipoConta;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EnumTipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(EnumTipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login.equals(""))
            throw new CampoInvalidoException("campo login não pode ser nulo");
        this.login = login;
    }   

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha.equals(""))
            throw new CampoInvalidoException("campo senha não pode ser nulo");
        this.senha = senha;
    }

    public boolean isPrimeiroAcesso() {
        return primeiroAcesso;
    }

    public void setPrimeiroAcesso(boolean primeiroAcesso) {
        this.primeiroAcesso = primeiroAcesso;
    }
}
