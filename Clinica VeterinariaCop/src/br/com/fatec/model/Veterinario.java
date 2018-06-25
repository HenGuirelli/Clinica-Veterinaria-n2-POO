package br.com.fatec.model;

import br.com.fatec.Enum.EnumEspecializacao;
import br.com.fatec.Enum.EnumTurno;
import br.com.fatec.excecoes.CampoInvalidoException;

public class Veterinario extends Pessoa{
    private EnumEspecializacao especializacao;
    private String pis;
    private EnumTurno turno;
    private boolean plantao;
    private boolean cirurgiao;
    private String atendimento;
    
    @Override
    public String toString(){
        return super.getNome();
    }
    
    //getters e setters
    public String getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(String atendimento) {
        if (atendimento.length() != 7)
            throw new CampoInvalidoException("atendimento tem que ter 7 caraceteres");
        for (int i=0; i<atendimento.length(); i++)
            if (atendimento.charAt(i) != '0' && atendimento.charAt(i) != '1')
                throw new CampoInvalidoException("apenas 0 e 1 para atendimento");
        this.atendimento = atendimento;
    }

    public EnumEspecializacao getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(EnumEspecializacao especializacao) {
        this.especializacao = especializacao;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public EnumTurno getTurno() {
        return turno;
    }

    public void setTurno(EnumTurno turno) {
        this.turno = turno;
    }

    public boolean isPlantao() {
        return plantao;
    }

    public void setPlantao(boolean plantao) {
        this.plantao = plantao;
    }

    public boolean isCirurgiao() {
        return cirurgiao;
    }

    public void setCirurgiao(boolean cirurgiao) {
        this.cirurgiao = cirurgiao;
    }
}
