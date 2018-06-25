package br.com.fatec.model;

import br.com.fatec.Enum.EnumUF;

public class Endereco {
    private String endereco;
    private String cep;
    private int numero;
    private EnumUF UF;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public EnumUF getUF() {
        return UF;
    }

    public void setUF(EnumUF UF) {
        this.UF = UF;
    }
}
