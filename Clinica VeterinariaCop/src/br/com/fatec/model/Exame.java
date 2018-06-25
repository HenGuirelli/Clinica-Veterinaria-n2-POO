package br.com.fatec.model;

import br.com.fatec.Enum.EnumTipoExame;

public class Exame {
    private Cliente tutor;
    private Animal animal;
    private String observacao;
    private EnumTipoExame tipo;

    public Cliente getTutor() {
        return tutor;
    }

    public void setTutor(Cliente tutor) {
        this.tutor = tutor;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public EnumTipoExame getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipoExame tipo) {
        this.tipo = tipo;
    }
}
